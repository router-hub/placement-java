public class Ques03 {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            String symbol = "+-*/";
            for(String thisis: tokens){
                if(thisis.length() == 1 && symbol.indexOf(thisis.charAt(0))>=0){
                    int a = stack.pop(), b = stack.pop(), c= 0;
                    switch(thisis.charAt(0)){
                        case '+':
                            c= a+ b;
                            break;
                        case '-':
                            c=b - a ;
                            break;
                        case '*':
                            c = a*b;
                            break;
                        case '/':
                            c = b / a;
                            break;

                    }
                    stack.push(c);
                }
                else{
                    stack.push(Integer.valueOf(thisis));
                }
            }

            return stack.pop();
        }
    }
}
