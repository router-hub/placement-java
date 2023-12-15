import java.util.*;
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l=0; 
        int result=0;
        long currSum=0;

        for(int r=0; r<n; r++){
            currSum += nums[r];
             

            while((r-l+1)*nums[r] - currSum > k ){
                currSum -= nums[l];
                l++;
            }

            result = Math.max(result, r-l+1);


        }

        return result;
    }
}