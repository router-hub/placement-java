import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea =0;
        int nsl[] = new int[n];
        int nsr[] = new int[n];

        //next smaller right 
        Stack <Integer> s = new Stack();
        for(int i = n-1 ; i>=0 ; i--){
            while(!s.isEmpty() && heights[s.peek()]>= heights[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=n;
            }
            else{
                nsr[i]=s.peek();
            }

            s.push(i);
        }

        // next smaller left
        s = new Stack();

        for(int i = 0 ; i<n ; i++){
            while(!s.isEmpty() && heights[s.peek()]>= heights[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s.peek();
            }

            s.push(i);
        }


        for(int i=0; i<n; i++){
            int area = (nsr[i]-nsl[i]-1)*heights[i];
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
        
    }
}
