import java.util.*;
class Solution {

    public boolean isPossible(int[] arr, int m, int k, int mid){
        int adj=0;
        int boq = 0;
        for(int i=0; i< arr.length; i++){
            if(arr[i]<= mid){
                adj++;
                if(adj==k){
                    boq++;
                    
                    if(boq==m){
                        return true;
                    }
                    adj=0;
                }
            }
            else{
                adj=0;
            }
        }


        return false;
    }


    public int minDays(int[] bloomDay, int m, int k) {

        if(m*k > bloomDay.length){
            return -1;
        }
        int l=bloomDay[0];
        int h = bloomDay[0];

        for(int i=0; i< bloomDay.length; i++){
            if(bloomDay[i]<l){
                l= bloomDay[i];
            }
            if(bloomDay[i]>h){
                h=bloomDay[i];
            }
        }

        int result =-1;
        while(l<=h){
            int mid = l+ (h-l)/2;

            if(isPossible(bloomDay, m, k, mid)){
                result = mid;
                h= mid-1;

            }
            else{
                l = mid+1;
            }
        }

        return result;
    }
}