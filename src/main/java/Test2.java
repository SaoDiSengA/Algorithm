import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[N][6];
        for(int i = 0;i < N;i++){
            for(int j = 0;j< 6;j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.sort(arr[i]);
        }
        sortColumn(arr,5);
        for(int i = 0;i < N;i++){
            for(int j = 0;j< 6;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
        StringBuilder sb = new StringBuilder();
        for(int i = N-1;i>=0;i--){
            sb.append(arr[i][5]);
        }
        System.out.println(sb.toString());
    }
    public static void sortColumn(int[][] array, int column) {
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[column], o2[column]);
            }
        });
    }
}
