import java.util.ArrayList;
import java.util.List;

public class ques2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        backtrace(0, ans, new ArrayList<Integer>(), nums);
        return ans;
    }


    public void backtrace(int s , List<List<Integer>> ans , List<Integer> arr , int[] nums ){
        ans.add(new ArrayList<>(arr));
        for(int i=s; i<nums.length; i++){
            arr.add(nums[i]);
            backtrace(i+1, ans, arr, nums);
            arr.remove(arr.size()-1);
        }
    }
}
