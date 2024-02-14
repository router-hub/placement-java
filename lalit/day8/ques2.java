// Basic Calculator-I
import java.util.*;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int oper = 1;

        for(int i = 0;i<s.length();i++){
            char chr = s.charAt(i);

            if(Character.isDigit(chr)){
                num = num * 10 + (chr - '0'); 
            }else if(chr == '+'){
                result += oper * num;
                num = 0;
                oper = 1;
            }else if(chr == '-'){
                result += oper * num;
                num = 0;
                oper = -1;
            }else if(chr == '('){
                stack.push(result);
                stack.push(oper);
                oper = 1;
                result = 0;
            }else if(chr == ')'){
                result += oper * num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if(num != 0){
            result += oper * num;
        }
        return result;
    }
}
