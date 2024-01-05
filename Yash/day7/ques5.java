import java.util.*;
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int val = 0;
        char sign = '+';

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                val = val*10 + (ch-'0');
                
                
            }
            if(i+1 == s.length() || ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                    if(sign=='+'){
                        stack.push(val);
                    }
                    if(sign=='-'){
                        stack.push(-val);
                    }
                    if(sign=='*'){
                        stack.push(stack.pop()*val);
                    }
                    if(sign=='/'){
                        stack.push(stack.pop()/val);
                    }

                    val=0;
                    sign=ch;
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;

    }
}
