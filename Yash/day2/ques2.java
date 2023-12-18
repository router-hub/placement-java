import java.util.*;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero = 0;
        int i=0; 
        int ans = 0;

        for(int j=0; j<nums.length; j++){
            if(nums[j]==0){
                zero++;
            }
            while(zero > k){
                if(nums[i]==0){
                    zero--;

                }
                i++;
            }

            ans = Math.max(ans, j-i+1);


        }


        return ans;
    }
}