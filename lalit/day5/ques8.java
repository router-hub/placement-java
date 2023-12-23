import java.util.Scanner;

public class ques8 {
    public static int countDivisors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countNDivisors(int a, int b, int n) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            int divisors = countDivisors(i);
            if (divisors == n) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();

            int result = countNDivisors(a, b, n);
            System.out.println(result);
    }
}

