//Find First and Last Position of Element in Sorted Array

class Solution {
    private int firstSearch(int nums[],int target){
        int low = 0;
        int high=nums.length-1;
        int first = -1;
        while(low <= high){
            int mid = (low+high)/2;

            if(nums[mid] == target){
                first = mid;
                high = mid-1;
            }else if(target>nums[mid]){
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return first;
    }

    private int lastSearch(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int last=-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            
            if(nums[mid]==target){
                last=mid;
                low=mid+1;
            }
            
            else if(target>nums[mid]){             
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return last;
    }

    public int[] searchRange(int[] nums, int target) {
    int result[] = new int[2];
    result[0] = firstSearch(nums,target);
    result[1] = lastSearch(nums,target);

    return result;
    }
}