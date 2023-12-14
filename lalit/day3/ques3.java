// Minimum Number of Days to Make m Bouquets

class Solution {
    private boolean possible(int bloomDay[],int m,int k,int day){
        int count = 0;
        int bloom = 0;

        for(int i = 0;i<bloomDay.length;i++){
            if(bloomDay[i] <= day){
                count++;
            }else{
                bloom += (count/k);
                count = 0;
            }
        }
        bloom += (count/k);

        if(bloom >= m){
            return true;
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = bloomDay.length;
        long val = (long)m*k;

        if(val > n){
            return -1;
        }

        for(int i = 0;i<n;i++){
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max,bloomDay[i]);
        }

        int low = min;
        int high = max;

        while(low <= high){
            int mid = (low+high)/2;

            if(possible(bloomDay,m,k,mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
