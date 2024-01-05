//Simplify Path

import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i = 0;i<path.length();i++){
            if(path.charAt(i) == '/'){
                continue;
            }

            StringBuilder temp = new StringBuilder();

            while(i < path.length() && path.charAt(i) != '/'){
                temp.append(path.charAt(i));
                i++;
            }

            String tempStr = temp.toString();

            if(tempStr.equals(".")){
                continue;
            }else if(tempStr.equals("..")){
                if(!stack.empty()){
                stack.pop();
                }
            }else{
                stack.push(tempStr);
            }
        }

        if(stack.isEmpty()){
            return "/";
        }

        while(!stack.isEmpty()){
        result.insert(0,"/" + stack.pop());
        }
        return result.toString();
    }
}
