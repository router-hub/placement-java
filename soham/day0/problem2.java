import java.util.ArrayList;
import java.util.List;

public class problem2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> subset=new ArrayList<>();
        p(nums,0,subset,ans);
        return ans;
    }
    public void p(int []nums,int i,ArrayList<Integer> subset,List<List<Integer>> ans){
        if(i>=nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        p(nums,i+1,subset,ans);
        subset.remove(subset.size()-1);
        p(nums,i+1,subset,ans);
    }
}
