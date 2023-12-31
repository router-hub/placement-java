//design-a-text-editor

import java.util.*;

class TextEditor {
    StringBuilder result;
    int position = 0;

    public TextEditor() {
        result = new StringBuilder();
    }
    
    public void addText(String text) {
        result.insert(position,text);
        position += text.length();
    }
    
    public int deleteText(int k) {
        int temp = position;
        result.delete(Math.max(0,position-k),position);
        position = Math.max(0,position-k);

        return temp - position;
    }
    
    public String cursorLeft(int k) {
        position = Math.max(0, position - k);
        String str = result.substring(Math.max(0,position-10),position);
        
        return str;
    }
    
    public String cursorRight(int k) {
        position = Math.min(result.length(), position+k);
        String str = result.substring(Math.max(0,position-10),position);
        
        return str;
    }
}