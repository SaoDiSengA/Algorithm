import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final long MOD = 1000000007L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(arr.get(i));
//        }
        scanner.close();

        long result = countOperations(arr);
        System.out.println(result);
    }

    private static long countOperations(ArrayList<Integer> arr) {
        long operations0 = 0;
        long operations1 = 0;
        int i = 0;
        while (!arr.isEmpty()) {
            if (arr.get(i) == 0) {
                arr.remove(i);
                operations0++;
            } else {
                int value = arr.get(i) - 1;
//                for (int j = 0; j < arr.get(i); j++) {
//                    arr.add(value);
//                }
                arr.set(i, arr.get(i) - 1);

//                i++;
                operations1 *= value;

            }
            continue;
        }
//        return operations % MOD;
        return 0;
    }
}
