public class Ques06 {
    private StringBuilder sb;
    private int cur;

    public TextEditor() {
        sb = new StringBuilder();
        cur = 0;
    }

    public void addText(String text) {
        sb.insert(cur,text);
        cur+=text.length();
    }

    public int deleteText(int k) {
        int l = Math.max(0,cur-k);
        int r = cur;
        sb.delete(l,r);
        cur = l;
        return r-l;

    }

    public String cursorLeft(int k) {
        int start = Math.max(cur-k,0);
        cur = start;
        return StringLeft();
    }

    public String cursorRight(int k) {
        int start = Math.min(cur+k,sb.length());
        cur = start;
        return StringLeft();
    }

    public String StringLeft(){
        int start = Math.max(0,cur-10);
        return sb.substring(start,cur);
    }
}
