import java.util.Scanner;

public class qiu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 轮数
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt(); //袋子数

            for (int j = 0; j < n; j++) {
                int num = scanner.nextInt();
                int[] arr = new int[num];
                for (int k = 0; k < num; k++) {
                    arr[i] = scanner.nextInt();
                }
                for (int k = 0; k < num; k++) {}

            }
        }
    }
}
