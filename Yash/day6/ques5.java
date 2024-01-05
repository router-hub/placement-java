class BrowserHistory {

    Stack<String> past = new Stack<>();
    Stack<String> future = new Stack<>();
    String curr;

    public BrowserHistory(String homepage) {
        curr = homepage;
    }
    
    public void visit(String url) {
        past.push(curr);
        curr = url;

        while(!future.isEmpty()){
            future.pop();
        }
    }
    
    public String back(int steps) {
        while(steps > 0 && !past.isEmpty()){
            future.push(curr);
            curr = past.peek();
            past.pop();
            steps--;
        }

        return curr;
    }
    
    public String forward(int steps) {
        while(steps > 0 && !future.isEmpty()){
            past.push(curr);
            curr = future.peek();
            future.pop();
            steps--;
        }

        return curr;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
