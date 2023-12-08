//Count number of Occurence of Anagram

import java.util.HashMap;

class ques1{

    private static int countAnagram(String str,String ptr){
        int n = str.length();
        int m = ptr.length();
        int ans = 0;

        HashMap<Character,Integer> strMap = new HashMap<>();
        HashMap<Character,Integer> ptrMap = new HashMap<>();

        for(int i = 0;i<m;i++){
            ptrMap.put(ptr.charAt(i),ptrMap.getOrDefault(ptr.charAt(i),0)+1);
        }

        for(int i = 0;i<n;i++){
            char current = str.charAt(i);
            strMap.put(current,strMap.getOrDefault(current, 0)+1);


            if(i >= m){
                char remove = str.charAt(i-m);
                if(strMap.get(remove) == 1){
                    strMap.remove(remove);
                }else{
                    strMap.put(remove,strMap.get(remove)-1);
                }
            }

            if(i >= m-1 && strMap.equals(ptrMap)){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String args[]){
        String str = "forxxorfxdofr";
        String ptr = "for";

        int result = countAnagram(str,ptr);
        System.out.println(result);
    }

}