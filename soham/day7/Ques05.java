public class Ques05 {
    class Solution {
        public int calculate(String s) {
            Stack<Integer> st=new Stack();
            int num=0;
            char operator='+';

            char ch[]=s.toCharArray();
            for(int i=0;i<ch.length;i++)
            {
                if(Character.isDigit(ch[i]))
                    num=num*10+ch[i]-'0';
                if(!Character.isDigit(ch[i]) && ch[i]!=' ' || i==ch.length-1)
                {
                    if(operator=='+')
                        st.push(num);
                    else if(operator=='-')
                        st.push(-num);
                    else if(operator=='*')
                        st.push(st.pop()*num);
                    else if(operator=='/')
                        st.push(st.pop()/num);
                    num=0;
                    operator=ch[i];

                }
            }

            int sum=0;
            while(!st.isEmpty())
            {
                sum+=st.pop();
            }

            return sum;

        }
    }
}
