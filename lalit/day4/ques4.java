// find-the-smallest-divisor-given-a-threshold

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxValue = Integer.MIN_VALUE;

        for(int i = 0;i<nums.length;i++){
            maxValue = Math.max(nums[i],maxValue);
        }

        int low = 0;
        int high = maxValue;

        while(low<=high){
            int mid = low + (high-low)/2;
            int sum = 0;
            
            for(int i = 0;i<nums.length;i++){
                sum += Math.ceil((double)nums[i]/mid);
            }
            if(sum <= threshold){
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
