import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> basket = new HashMap<>();

        int l=0; 
        int maxFruit=0;

        for(int r=0; r<fruits.length; r++){
            basket.put(fruits[r], basket.getOrDefault(fruits[r], 0)+1);

            while(basket.size()> 2){
                if(basket.get(fruits[l])==1){
                    basket.remove(fruits[l]);
                }
                else{
                    basket.put(fruits[l], basket.get(fruits[l])-1);
                }

                l++;
            }

            maxFruit = Math.max( maxFruit, r-l+1);
        }

        return maxFruit;
        
    }
}