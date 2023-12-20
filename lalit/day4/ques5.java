// Random pick with weight

import java.util.*;

class Solution {
    private final int arr[];
    private int sum;

    public Solution(int[] w) {
        arr = new int[w.length];

        for(int i = 0;i< w.length;i++){
            sum += w[i];
            arr[i] = sum;
        }
    }
    
    public int pickIndex() {
    final int target = new Random().nextInt(sum) + 1;

        int low = 0;
        int high = arr.length-1;

        while(low < high){
            final  int mid = low + (high-low)/2;

            if(target <= arr[mid]){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }
}