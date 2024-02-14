//  Substring with Concatenation of All Words

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();

    for (int i = 0;i<words.length;i++){
        wordMap.put(words[i], wordMap.getOrDefault(words[i], 0) + 1);
    }    
        
        int wordSize = words[0].length();
        int windowSize = words.length * wordSize;
        int sLength = s.length();
        
        int i = 0; 
        int j = 0; 
        
        while (i <= sLength - windowSize) {
            Map<String, Integer> map = new HashMap<>(wordMap);
            int left = i;
            int match = 0; 
            
            while (j < i + windowSize) {
                String curr = s.substring(j, j + wordSize);
                
                if (map.containsKey(curr)) {
                    map.put(curr, map.get(curr) - 1);

                    if (map.get(curr) == 0) match++;
                } else {
                    break; 
                }
                
                j += wordSize;
            }

            if (match == wordMap.size()) {
                result.add(left);
            }
            
            i++;
            j = i;
        }
        return result;
    }
}

