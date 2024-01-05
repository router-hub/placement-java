// Evaluate Reverse Polish Notation

import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String str = "";

        for(int i = 0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                str = Integer.toString(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop()));
            }else if(tokens[i].equals("-")){
                str = Integer.toString(-Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop()));
            }else if(tokens[i].equals("*")){
              str = Integer.toString(Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop())); 
            }else if(tokens[i].equals("/")){
                String y = stack.pop();
                str = Integer.toString(Integer.parseInt(stack.pop()) / Integer.parseInt(y));
            }else{
                str = tokens[i];
            }
                stack.push(str);
        }
        return Integer.parseInt(stack.pop());
    }
}