//Contains Duplicate iii

import java.util.*;
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
    TreeSet<Integer> set = new TreeSet<>();

    for(int i = 0;i<nums.length;i++){
        Integer smaller = set.floor(nums[i]);
        Integer larger = set.ceiling(nums[i]);

        if(smaller != null && nums[i]-smaller <= valueDiff){
            return true;
        }

        if(larger != null && larger - nums[i] <= valueDiff){
            return true;
        }
        set.add(nums[i]);

        if(set.size() > indexDiff){
            set.remove(nums[i-indexDiff]);
        }
    }
    return false;
    }
}