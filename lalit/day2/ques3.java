//Max Consecutive Ones III

class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int left = 0,right = 0;
        int ans = 0;

        while(right < n){
            if(nums[right] == 0){
                count++;
            }
            
            // for maintaining window size
            while(count>k){
                if(nums[left] == 0){
                    count--;
                }
                left++;
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}
