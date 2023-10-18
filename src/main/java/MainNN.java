import java.util.Scanner;

public class MainNN {

    private static final long MOD = 1000000007L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        long result = countOperations(arr);
        System.out.println(result);
    }

    private static long countOperations(int[] arr) {
        long[] dp = new long[100001];
        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i <= 100000; i++) {
//            dp[i] = (dp[i - 1] + (2 * i + 1) * dp[i - 2]) % MOD;
            dp[i] = ((i+1)*dp[i-1] + dp[i-2])% MOD;
        }

        long operations = 0;
        for (int value : arr) {
            operations = (operations + dp[value]) % MOD;
        }

        return operations;
    }
}
