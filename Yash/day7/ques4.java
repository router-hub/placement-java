
import java.util.*;
class MinStack {

    Stack<Integer> s1;
    Stack<Integer> minS;
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        minS = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
        if (minS.isEmpty() || x <= minS.peek()) {
            minS.push(x);
        }
    }
    
    public void pop() {
        int value = s1.pop();
        if (minS.peek() == value) {
            minS.pop();
        }
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}