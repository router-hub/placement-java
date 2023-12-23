import java.util.*;

public class ques10 {
    public static int getTotalCost(int[] heights, int[] costs, int targetHeight) {
        int totalCost = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > targetHeight) {
                totalCost += (heights[i] - targetHeight) * costs[i];
            } else{
                totalCost += (targetHeight - heights[i]) * costs[i];
            }
        }
        return totalCost;
    }

    public static int findMinimalCost(int[] heights, int[] costs) {
        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;

        for(int i = 0;i<heights.length;i++){
            minH = Math.min(minH, heights[i]);
            maxH = Math.max(maxH, heights[i]);
        }


        int left = minH;
        int right = maxH;
        int minCost = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cost = getTotalCost(heights, costs, mid);

            minCost = Math.min(minCost, cost);

            if (cost < getTotalCost(heights, costs, mid + 1)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] heights = new int[n];
            int[] costs = new int[n];

            for (int i = 0; i < n; i++) {
                heights[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                costs[i] = sc.nextInt();
            }

            int minimalCost = findMinimalCost(heights, costs);
            System.out.println(minimalCost);
        }
        sc.close();
    }
}

