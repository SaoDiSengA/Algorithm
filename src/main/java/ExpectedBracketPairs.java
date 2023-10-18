import java.util.Scanner;

public class ExpectedBracketPairs {
    public static final long MOD = 1000000007L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        System.out.println(calculateExpectedPairs(input));
    }

    public static long calculateExpectedPairs(String s) {
        return backtracking(s, 0, 0, 0);
    }

    public static long backtracking(String s, int index, int leftCount, int rightCount) {
        if (index == s.length()) {
            return leftCount == rightCount ? leftCount : 0;
        }

        char c = s.charAt(index);
        if (c == '(') {
            return backtracking(s, index + 1, leftCount + 1, rightCount);
        } else if (c == ')') {
            if (leftCount > rightCount) {
                return backtracking(s, index + 1, leftCount, rightCount + 1);
            } else {
                return 0;
            }
        } else { // c == '?'
            long leftOption = backtracking(s, index + 1, leftCount + 1, rightCount);
            long rightOption = leftCount > rightCount ? backtracking(s, index + 1, leftCount, rightCount + 1) : 0;
            return (leftOption + rightOption) % MOD;
        }
    }
}
