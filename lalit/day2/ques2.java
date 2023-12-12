//Fruits in Basket-Sliding Algorithm

//simplified problem statement
//find the length of the longest 
//contiguous subarray with atmost 2 distinct integers

import java.util.*;
class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> basket = new HashMap<>();
        
        //taking two pointers
        int left = 0;
        int right = 0;
        int ans = 0;

        for(right = 0;right <fruits.length;right++){
            int currentFruits = basket.getOrDefault(fruits[right],0);
            basket.put(fruits[right],currentFruits+1);

            //as if basket have more than 2 types of fruits 
            //starting emptying it
            while(basket.size()>2){
                int fruitsCount = basket.get(fruits[left]);
                if(fruitsCount == 1){
                    basket.remove(fruits[left]);
                    left++;
                }else{
                    basket.put(fruits[left],fruitsCount - 1);
                    left++;
                }
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
