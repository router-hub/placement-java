// Repeated DNA Sequences
// Time Complexity - O(N * M)

import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();

        if(s.length() < 10){
            return list;
        }

        int i = 0;
        int j = 10;

        while(j<=s.length()){
            String str = s.substring(i,j);
                if(!map.containsKey(str)){
                    map.put(str,1);
                }else{
                    map.put(str,map.get(str)+1);

                    if(!list.contains(str)){
                        list.add(str);
                    }
                }
            i++;
            j++;
        }
        return list;
    }
}