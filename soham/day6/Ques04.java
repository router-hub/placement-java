public class Ques04 {
    class ListNode {
        int count;
        Set<String> set;
        ListNode pre, next;
        public ListNode(int count) {
            this.count = count;
            this.set = new HashSet();
            this.pre = null;
            this.next = null;
        }
    }

    class AllOne {
        ListNode head, tail;
        Map<String, ListNode> map;
        public AllOne() {
            this.head = new ListNode(0);
            this.tail = new ListNode(0);
            head.next = tail;
            tail.pre = head;
            this.map = new HashMap();
        }

        public void inc(String key) {
            if (!map.containsKey(key)) {
                if (head.next.count == 1) {
                    head.next.set.add(key);
                }else {
                    add(head, head.next, key, 1);
                }
                map.put(key, head.next);
            }else {
                ListNode node = map.get(key);
                if (node.count + 1 == node.next.count) {
                    node.next.set.add(key);
                }else {
                    add(node, node.next, key, node.count + 1);
                }
                node.set.remove(key);
                map.put(key, node.next);
                if (node.set.isEmpty()) {
                    delete(node);
                }
            }
        }

        public void dec(String key) {
            if (map.containsKey(key)) {
                ListNode node = map.get(key);
                if (node.count == 1) {
                    map.remove(key);
                }else {
                    if (node.count - 1 == node.pre.count) {
                        node.pre.set.add(key);
                    }else {
                        add(node.pre, node, key, node.count - 1);
                    }
                    map.put(key, node.pre);
                }
                node.set.remove(key);
                if (node.set.isEmpty()) {
                    delete(node);
                }
            }
        }
        public void add(ListNode node, ListNode next, String key, int count) {
            ListNode newnode = new ListNode(count);
            newnode.set.add(key);
            node.next = newnode;
            newnode.pre = node;
            newnode.next = next;
            next.pre = newnode;
        }
        public void delete(ListNode node) {
            ListNode pre = node.pre;
            ListNode next = node.next;
            pre.next = next;
            next.pre = pre;
        }
        public String getMaxKey() {
            if (tail.pre == head) {
                return "";
            }else {
                return tail.pre.set.iterator().next();
            }
        }

        public String getMinKey() {
            if (head.next == tail) {
                return "";
            }else {
                return head.next.set.iterator().next();
            }
        }
    }

}
