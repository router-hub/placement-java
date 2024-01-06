public class Ques01 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char ch = stack.peek();
                if(c==')' && ch=='(') stack.pop();
                else if(c=='}' && ch=='{') stack.pop();
                else if(c==']' && ch=='[') stack.pop();
                else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
