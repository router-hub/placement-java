import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack();


        for(int i=0; i< tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("*") 
                ||tokens[i].equals("-") || tokens[i].equals("/")){

                int num2 = Integer.parseInt(s.pop());
                int num1 = Integer.parseInt(s.pop());

                if(tokens[i].equals("+")){
                    s.push(String.valueOf(num1+num2));
                }
                if(tokens[i].equals("-")){
                    s.push(String.valueOf(num1-num2));
                }
                if(tokens[i].equals("*")){
                    s.push(String.valueOf(num1*num2));
                }
                if(tokens[i].equals("/")){
                    s.push(String.valueOf(num1/num2));
                }

            }
            else{
                s.push(tokens[i]);
            }


        }

        return Integer.parseInt(s.pop());
    }
}