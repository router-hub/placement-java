import java.util.*;
class Solution {
    public int rightInterval(int start[], int k){
        int r=2147483647;
        for(int i=0; i<start.length; i++){
            if(start[i]>= k ){
                r=Math.min(r,start[i]);

            }
        }

        for(int i=0; i<start.length; i++){
            if(start[i]==r){
                return i;
            }
        }

        return -1;
    }
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int start[] = new int[n];
        int end[] = new int[n];
        int result[] = new int[n];

        for(int i=0; i<n; i++){
            start[i] = intervals[i][0];
            end[i]= intervals[i][1];
        }

        for(int i=0; i<n; i++){
            int k= end[i];
            result[i]= rightInterval(start,k);
        }


        return result;


    }
}