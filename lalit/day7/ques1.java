//Valid Parentheses

import java.util.*;

class Solution {
    public boolean opening(char ch){
        if(ch == '(' || ch == '{' || ch == '['){
            return true;
        }
        return false;
    }

    public boolean matching(char a,char b){
        if(a == '(' && b == ')' ||a=='{' && b == '}' || a == '[' && b == ']'){
            return true;
        }
        return false;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char curr = s.charAt(i);
            if(opening(curr)){
                stack.push(curr);
            }else{
                if(stack.empty()){
                    return false;
                }
                else if(matching(stack.peek(),curr)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.empty();
    }
}