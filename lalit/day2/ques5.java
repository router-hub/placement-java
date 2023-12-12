// Contains Duplicate-ii

import java.util.*;
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0;i<n;i++){
            if(!map.containsKey(nums[i])){
            map.put(nums[i],i);
            }else{
                int prevInd = map.get(nums[i]);
                if(Math.abs(i-prevInd) <= k){
                    return true;
                }else{
                    map.put(nums[i],i);
                }
            }
        }
            return false;
    }
}