//Median of two sorted Array

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m =nums1.length;
        int n =nums2.length;
        int size = m + n;
        int mergedArr [] = new int [size];
        double median = 0;
        
    int i=0, j=0, k=0;

        while (i<=m && j<=n) {
            if (i == m) {
                while(j<n) {
                mergedArr[k++] = nums2[j++];    
                }
                break;
            } else if (j == n) {
                while (i<m){
                mergedArr[k++] = nums1[i++];
                } 
                break;
            }

            if (nums1[i] < nums2[j]) {
                mergedArr[k++] = nums1[i++];
            } else {
                mergedArr[k++] = nums2[j++];
            }
        }

        if(size % 2 != 0){
            int ind1 = (size + 1)/2 ;
            median = mergedArr[ind1 - 1];
        }else{
            int ind2 = size/2;
            int ind3 = (size/2) + 1;
            double sum = mergedArr[ind2-1] + mergedArr[ind3 - 1];
            median = (sum / 2);
        }
        return median;
    }
}