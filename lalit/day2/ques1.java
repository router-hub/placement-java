// Longest Subarray of 1's After Deleting One Element

class Solution {
    public int longestSubarray(int[] nums) {
        int current = 0,prev = 0;
        int ans = 0;

        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                current++;
            }else{//when we encounter 0
                ans = Math.max(ans,current+prev);
                prev = current;
                current = 0;
            }
        }
        //corner cases
        ans = Math.max(ans,current+prev);
        if(ans == nums.length){
            return ans-1;
        }
        return ans;
    }
}