import java.util.Scanner;

public class shulie {

    static long[] s = new long[50005];
    static long a, b, m;

    public static void f(int i) {
        if (i == 50003)
            return;
        s[i] = ((s[i - 1] * a) % m + (s[i - 2] * b) % m) % m;
        f(i + 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int q, qi;
        s[0] = 1;
        s[1] = 1;
        a = input.nextLong();
        b = input.nextLong();
        m = input.nextLong();

        f(2);
        q = input.nextInt();
        for (int i = 0; i < q; i++) {
            qi = input.nextInt();
            System.out.println(s[qi]);
        }
        input.close();
    }
}
