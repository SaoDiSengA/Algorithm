import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int[] cnt = new int[n+1]; // cnt数组记录每个数字出现的次数
        boolean[][][] dp = new boolean[n+1][m+1][p+1]; // dp数组表示是否能够分装成恰好P的价值
        dp[0][0][0] = true; // 初始状态
        for (int i = 1; i < n; i++) {
            int v = i * i;
            for (int j = m-1; j >= 0; j--) { // 枚举小包装的数量
                for (int k = v; k <= p; k++) { // 枚举小包装的价值
                    dp[i][j][k] |= dp[i-1][j-1][k-v]; // 情况1：将i放入新的小包装中
                    dp[i][j][k] |= dp[i-1][j][k]; // 情况2：将i加入到已有的小包装中
                }
            }
        }
        int idx = -1;
        for (int i = 1; i <= n; i++) {
            if (dp[n-1][m-1][p-i*i]) { // 如果能够分装成价值为P-i^2的方案存在
                idx = i;
                break;
            }
        }
        if (idx == -1) { // 不存在方案
            System.out.println("-1");
        } else { // 存在方案
            int j = m-1;
            int k = p-idx*idx;
            for (int i = n-1; i >= 0; i--) {
                if (dp[i][j][k]) { // i可以分装到最后一个小包装中
                    cnt[i+1]++; // 记录i出现的次数
                    k -= i*i;
                    if (j == 0) break;
                    while (dp[i-1][j][k]) i--; // 寻找下一个可以分装的数字
                    j--;
                }
            }
            for (int i = 1; i <= n; i++) { // 输出结果
                for (int t = 0; t < cnt[i]; t++) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
