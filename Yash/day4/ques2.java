import java.util.*;
class Solution {
    public int hIndex(int[] citations) {
        int l =0;
        int n= citations.length;
        int r= n;
       

        while(l<r){
            int mid = (l+r)/2;
            if(citations[mid]>= n-mid){
                
                r=mid;
            }
            else{
                l= mid+1;
            }
        }

        return n-l;
    }
}