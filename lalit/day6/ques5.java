// Design Browser History

import java.util.*;

class BrowserHistory {
    Stack<String> past;
    Stack<String> next;
    String current;

    public BrowserHistory(String homepage) {
        past = new Stack<>();
        next = new Stack<>();
        current = homepage;
    }
    
    public void visit(String url) {
        past.push(current);
        current = url;
        next.clear();
    }
    
    public String back(int steps) {
        while(steps-->0 && !past.isEmpty()){
            next.push(current);
            current = past.peek();
            past.pop();
        }
        return current;
    }
    
    public String forward(int steps) {
        while(steps-->0 && !next.isEmpty()){
            past.push(current);
            current = next.peek();
            next.pop();
        }
        return current;
    }
}
