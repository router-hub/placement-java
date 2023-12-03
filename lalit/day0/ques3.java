//Maximum Points You Can Obtain from Cards

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum1 = 0;
        int sum2 = 0;
        //first adding k left numbers
        for(int i = 0;i<k;i++){
            sum1 += cardPoints[i];
        }
        // assigning left sum to max
        int max = sum1;
// here in each iteration we first removing 1 element from left and adding 1 element from right
// and then updating the max value for each iteration 
        for(int i = 0;i<k;i++){
            sum1 -= cardPoints[k-i-1];
            sum2 += cardPoints[n-i-1];
            max = Math.max(max,sum1+sum2);
        }

        return max;
    }
}
