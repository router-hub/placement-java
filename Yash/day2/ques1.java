import java.util.*;
class Solution {
    public int longestSubarray(int[] nums) {
        int zero= 0;
        int i=0;
        int window=0;

        for(int j=0; j<nums.length; j++){
            if(nums[j]==0){
                zero++;

            }

            while(zero > 1){
                if(nums[i]==0){
                    zero--;
                    
                }
                i++;
                
            }

            window = Math.max(window, j-i);
        }

        return window;
    }
}