
import java.util.*;
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); ++i)
            freq[s.charAt(i) - 'a']++;

        
        Stack<Character> st = new Stack<>(); 
        boolean[] seen = new boolean[26]; 
        for (int i = 0; i < s.length(); ++i) {
            if (seen[s.charAt(i) - 'a']) { 
                freq[s.charAt(i) - 'a']--;
                continue;
            }
            while (!st.isEmpty() && st.peek() > s.charAt(i) && freq[st.peek() - 'a'] > 0) { 
                seen[st.peek() - 'a'] = false;
                st.pop();
            }
            st.push(s.charAt(i));
            seen[s.charAt(i) - 'a'] = true;
            freq[s.charAt(i) - 'a']--;
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) { 
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}