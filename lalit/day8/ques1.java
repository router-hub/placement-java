// largest-rectangle-in-histogram

import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        for(int i = 0;i<=heights.length;i++){
            while(!stack.isEmpty() && (i == heights.length || heights[stack.peek()] >= heights[i])){
                int idx = stack.pop();

                int left = stack.empty() ? 0 : stack.peek() + 1;

                maxArea = Math.max(maxArea,heights[idx] * (i-1-left + 1));
            }
            stack.push(i);
        }
        return maxArea;
    }
}