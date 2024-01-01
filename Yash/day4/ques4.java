import java.util.*;
class Solution {


    public int thresholdSum(int nums[], int k){
        int sum =0;
        for(int i=0; i< nums.length; i++){
            sum += Math.ceil((double)(nums[i])/ (double)(k));
        }

        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int low = 1;
        int high = max;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(thresholdSum(nums, mid)<= threshold){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }
}