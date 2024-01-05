// All O`one Data Structure

import java.util.*;

class AllOne {
    Node head = null;
    Node tail = null;

    Map<String,Node> map = new HashMap<>();

    public AllOne() {
        
    }
    
    public void inc(String key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value++;
            moveUp(node);
        }else{
            Node node = new Node(key,1);
            add(node);
            map.put(key,node);
        }
    }
    
    public void dec(String key) {
        Node node = map.get(key);
        if(node.value == 1){
            map.remove(key);
            remove(node);
        }else{
            node.value--;
            moveDown(node);
        }
    }
    
    public String getMaxKey() {
        if(!map.isEmpty()){
            return tail.key;
        }
        return "";
    }
    
    public String getMinKey() {
        if(!map.isEmpty()){
            return head.key;
        }
        return "";
    }

    void add(Node node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    void remove(Node node){
        if (node == head && node == tail) {
        head = null;
        tail = null;
        return;
    }

    if (node == head) {
        head = node.next;
        head.prev = null;
    } else if (node == tail) {
        tail = node.prev;
        tail.next = null;
    } else {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    }

    void moveUp(Node node){
        Node pre = node.next;
        while (pre != null && pre.value < node.value) {
            pre = pre.next;
        }
        if (pre != node.next) {
            if (node == head) {
                head = node.next;
            } else {
                node.prev.next = node.next;
            }
            node.next.prev = node.prev;

            node.next = pre;
            if (pre == null) {
                node.prev = tail;
                tail.next = node;
                tail = node;
            } else {
                node.prev = pre.prev;
                pre.prev.next = node;
                pre.prev = node;
            }
        }
    }

    void moveDown(Node node) {
        Node pre = node.prev;
        while (pre != null && pre.value > node.value) {
            pre = pre.prev;
        }
        if (pre != node.prev) {
            if (node == tail) {
                tail = node.prev;
            } else {
                node.next.prev = node.prev;
            }
            node.prev.next = node.next;

            node.prev = pre;
            if (pre == null) {
                node.next = head;
                head.prev = node;
                head = node;
            } else {
                node.next = pre.next;
                pre.next.prev = node;
                pre.next = node;
            }
        }
    }

    class Node{
        Node prev;
        Node next;
        String key;
        int value;

        Node(String k,int v){
            key = k;
            value = v;
        }
    }
}
