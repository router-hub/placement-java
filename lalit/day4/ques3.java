// Right Interval

import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int i=0; i<intervals.length; i++) {
            int[] interval = intervals[i];
            max = Math.max(max, interval[0]);
            map.put(interval[0], i);
        }
        
        for(int i=0; i<intervals.length; i++){
            int end = intervals[i][1];
            if(end > max) {
                res[i] = -1;
                continue;
            }
            int j = end;
            while(!map.containsKey(j)) {
                j++;
            }
            res[i] = map.get(j);
        }

        return res;
    }
}