class LFUCache {
    final int capacity;
    int curSize;
    int minFreq;
    Map<Integer, Node> cache;
    Map<Integer, DoubleLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFreq = 0;

        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node curNode = cache.get(key);
        if (curNode == null) {
            return -1;
        }
        updateNode(curNode);
        return curNode.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            Node curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }
        else {
            curSize++;
            if (curSize > capacity) {
                DoubleLinkedList minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }

            minFreq = 1;
            Node newNode = new Node(key, value);

            DoubleLinkedList curList = freqMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            freqMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(Node curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = freqMap.get(curFreq);
        curList.removeNode(curNode);

        if (curFreq == minFreq && curList.listSize == 0) {
            minFreq++;
        }

        curNode.frequency++;

        DoubleLinkedList newList = freqMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        freqMap.put(curNode.frequency, newList);
    }

    class Node {
        int key;
        int val;
        int frequency;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    class DoubleLinkedList {
        int listSize;
        Node head;
        Node tail;
        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(Node curNode) {
            Node nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        public void removeNode(Node curNode) {
            Node prevNode = curNode.prev;
            Node nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */