class TextEditor {

    Deque<Character> stack = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();
    

    public TextEditor() {
        
    }
    
    public void addText(String text) {
        sb.append(text);
    }

    private String getString(){
        while(sb.length() < 10){
            return sb.toString();
        }
        return sb.substring(sb.length() - 10).toString();
    }
    
    public int deleteText(int k) {
        int deleteNum = Math.min(k, sb.length());
        while(!sb.isEmpty() && k-->0){
            sb.deleteCharAt(sb.length()-1);
        }

        return deleteNum;
    }
    
    public String cursorLeft(int k) {
        while(!sb.isEmpty() && k-->0){
            stack.push(sb.charAt(sb.length()-1));
            sb.deleteCharAt(sb.length()-1);
        }

        return getString();

    }
    
    public String cursorRight(int k) {
        while(!stack.isEmpty() && k-->0){
            sb.append(stack.pop());

        }
        return getString();
    }

    
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */