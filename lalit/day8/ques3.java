//Remove Duplicate Letters

import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder result = new StringBuilder();
        Map<Character,Integer> occurence = new HashMap<>();
        boolean visited[] = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<s.length();i++){
            occurence.put(s.charAt(i),i);
        }

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);

            if(!visited[ch - 'a']){
                while(!stack.isEmpty() && stack.peek() > ch && occurence.get(stack.peek())>i){
                    visited[stack.pop() - 'a'] = false;
                }

                stack.push(ch);
                visited[ch - 'a'] = true;
            }
        }

        for(Character c : stack){
            result.append(c);
        }
        return result.toString();
    }
}
