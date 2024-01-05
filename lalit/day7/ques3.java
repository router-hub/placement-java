//Min-Stack

class MinStack {
    class Node{
        int val;
        int min;
        Node next;

    private Node(int val,int min){
        this.val = val;
        this.min = min;
    }
}

    private Node head;
    
    public boolean isEmpty(){
        return head == null;
    }

    public void push(int val) {
        if(isEmpty()){
            head = new Node(val, val);
        }else{
        int min = Math.min(val, head.min);
        Node newNode = new Node(val, min);
        newNode.next = head;
        head = newNode; 
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        if(isEmpty()){
            return -1;
        }
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}