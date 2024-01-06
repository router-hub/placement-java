public class Ques02 {

        public String simplifyPath(String path) {
            Stack<String> st = new Stack<>();
            String [] thePath = path.trim().split("\\/");

            for(String p : thePath){
                if(p.equals(".") || p.length()==0){
                    continue;
                }
                else if(p.equals("..")){
                    if(!st.empty())st.pop();
                }
                else{
                    st.push(p);
                }
            }

            StringBuilder sb = new StringBuilder();

            while(!st.empty()){
                sb.insert(0,"/" + st.pop() );

            }

            if(sb.length() == 0){
                return "/";
            }

            //sb.reverse();

            return sb.toString();
        }

}
