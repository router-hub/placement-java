import java.util.Scanner;

public class ques7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int c = 1; c <= testCases; c++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int b = sc.nextInt();
            int t = sc.nextInt();

            int[] positions = new int[n];

            for (int i = 0; i < n; i++) {
                positions[i] = sc.nextInt();
            }

            int[] speeds = new int[n];
            for (int i = 0; i < n; i++) {
                speeds[i] = sc.nextInt();
            }

            int chicksReached = 0;
            int swaps = 0;

            int reachCount = 0;

            for (int i = n - 1; i >= 0; i--) {
                int distance = b - positions[i];
                int timeRequired = distance / speeds[i];

                if (timeRequired <= t) {
                    reachCount++;
                } else {
                    swaps += reachCount;
                }

                if (reachCount >= k) {
                    break;
                }
            }

            chicksReached = reachCount;

            if (chicksReached >= k) {
                System.out.println("Case #" + c + ": " + swaps);
            } else {
                System.out.println("Case #" + c + ": IMPOSSIBLE");
            }
        }
    }
}

