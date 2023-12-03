//SubSet
import java.util.*;
class Solution {
    private void backtrack(List<List<Integer>> result,List<Integer> arr,int nums[],int start){
        result.add(new ArrayList<>(arr));
        for(int i = 0;i<nums.length;i++){
            //if number is adding in result
            arr.add(nums[i]);
            backtrack(result, arr, nums, i+1);
            //if number is not adding in result
            arr.remove(arr.size()-1);
        }
    }
    public List<List<Integer>> subsets(int nums[]){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        backtrack(result,arr,nums,0);
        return result;
    }
}
