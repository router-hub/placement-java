import java.util.*;

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int l=0; 
        int f=0;
        int t=0;

        

        int max=0;

        for(int r=0; r<answerKey.length(); r++){
            if(answerKey.charAt(r)=='T'){
                t++;
            }
            else{
                f++;
            }
            int s= Math.max(t,f);
            while(r-l+1-s > k){
                if(answerKey.charAt(l)=='T'){
                    t--;
                }
                else{
                    f--;
                }
                l++;
            }

            max = Math.max(max,r-l+1);
        }

        return max;
    }
}