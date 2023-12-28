import java.util.*;
class Solution {
    
    public static boolean areAnagram(String s1, String s2){
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        if(Arrays.equals(ch1,ch2)){
            return true;
        }else{
            return false;
        }
    }

    int search(String pat, String txt) {
        int n= txt.length();
        int m= pat.length();

        int ans=0; 
        
        for(int i=0; i<=n-m; i++){
            String s = txt.substring(i, i+m);

            if(areAnagram(s,pat)){
                ans++;
            }
        }

        return ans;

    }
}