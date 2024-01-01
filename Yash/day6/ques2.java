class Node {
        public int key ; 
        public int value;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
}
class LRUCache {

    public int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    LinkedHashSet<Node> cache = new LinkedHashSet<>();
    

    public LRUCache(int capacity) {
        this.capacity = capacity;

        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node newNode = map.get(key);
        cache.remove(newNode);
        cache.add(newNode);

        return newNode.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value = value;
            get(key);
            return;
        }

        if(cache.size()==capacity){
            Node lru = cache.iterator().next();
            cache.remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key,value);
        map.put(key,node);
        cache.add(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */