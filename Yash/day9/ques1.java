import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n= s.length();
        
        
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();


        for(int i=0; i<n-9; i++){
            String str = s.substring(i,i+10);
            map.put(str, map.getOrDefault(str,0)+1);
            

        }

        for(Map.Entry<String, Integer> e : map.entrySet()){
            if(e.getValue()>1){
                list.add(e.getKey());
            }
        }

        

        return list;
    }
}