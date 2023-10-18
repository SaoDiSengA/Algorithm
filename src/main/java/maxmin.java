import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class maxmin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            arr.add(scanner.nextInt());
        }
        while(arr.size() > 1){
            int max = Integer.MIN_VALUE;
            int index = 0;
            for (int i = 0; i < arr.size(); i++) {
                if(arr.get(i) > max){
                    max = arr.get(i);
                    index = i;
                }
            }
            if(index > 0 && index < arr.size()-1){
                if(k < 2){
                    arr.remove(arr.get(index));
                    continue;
                } else {
                    System.out.print(arr.get(index));
                    break;
                }
            }
            if(index == 0 || index == arr.size()-1){
                if(k < 1){
                    arr.remove(arr.get(index));
                    continue;
                }else {
                    System.out.print(arr.get(index));
                    break;
                }
            }
        }
    }
}
