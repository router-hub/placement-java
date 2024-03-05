import java.util.*;
class Solution {
    public int calculate(String s) {
        int n = s.length();
        int sum =0;
        int sign = 1;
        Stack<Integer> st = new Stack();

        for(int i =0; i<n ; i++){
            if(Character.isDigit(s.charAt(i))){
                int num = 0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    num = num*10+ (s.charAt(i)-'0');
                    i++;
                }
                sum += num*sign;
                i--;
            }
            else if(s.charAt(i)=='+'){
                sign= 1;
            }
            else if(s.charAt(i)=='-'){
                sign=-1;
            }
            else if(s.charAt(i)=='('){
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign=1;

            }
            else if(s.charAt(i)==')'){
                sum = sum *st.pop();
                sum+= st.pop();
            }

            
        }

        return sum;
    }
}
