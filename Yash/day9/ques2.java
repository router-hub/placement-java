import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int sLen = words[0].length();
        int Len = words.length;
        int n = s.length();

        if(n==0 || Len==0 || words ==null || s==null){
            return new ArrayList<>();
        }



        HashMap<String , Integer> count = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0; i< words.length; i++){

            count.put(words[i], count.getOrDefault(words[i], 0)+1);
        }

        for(int i=0; i<n-sLen*Len+1; i++){
            String subStr  = s.substring(i, i+sLen*Len);
            Map<String, Integer> seen = new HashMap<>();
            for(int j=0; j<subStr.length(); j+=sLen){
                String element = subStr.substring(j,j+sLen);
                seen.put(element, seen.getOrDefault(element, 0)+1);

            }

            if(seen.equals(count)){
                res.add(i);
            }
        }



        return res;
        

        
    }
}