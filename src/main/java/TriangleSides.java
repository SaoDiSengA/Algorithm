import java.util.Scanner;

public class TriangleSides {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(countValidSides(a, b, l, r));
        }
        scanner.close();
    }

    public static int countValidSides(int a, int b, int l, int r) {
        int c_min = Math.max(l, Math.abs(a - b) + 1);
        int c_max = Math.min(r, a + b - 1);
        return Math.max(c_max - c_min + 1, 0);
    }
}
