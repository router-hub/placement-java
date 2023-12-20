import java.util.*;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=0;
        int end = nums.length-1;
        int result[]= new int[2];
        result[0]= starting(nums, start, end, target);
        result[1]= ending(nums, start, end, target);


        return result;

        

        
        


        
    }


    public int starting(int nums[], int start, int end, int target){
            int minIdx =-1;;

            while(start<= end){
                int mid = (start+end)/2;
                if(nums[mid]==target){
                minIdx = mid;
                end= mid-1;
                }
                else if(nums[mid]< target){
                start = mid+1;

                }
                else{
                end= mid-1;
                }
            }

            return minIdx;
        }


        public int ending(int nums[], int start, int end, int target){
            int maxIdx =-1;

            while(start<= end){
                int mid = (start+(end - start)/2);
                if(nums[mid]==target){
                    maxIdx = mid;
                    start = mid+1;
                }
                else if(nums[mid]< target){
                    start = mid+1;

                }
                else{
                end= mid-1;
                }
            }
            
            return maxIdx;
        }
}
