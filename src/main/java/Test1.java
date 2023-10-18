
import java.util.Scanner;
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(!str.contains(":-)") && !str.contains(":-(")) System.out.print("None");
        int happy = countOccurrences(str,":-)");
        int sad = countOccurrences(str,":-(");
        if(happy > sad) System.out.print("Happy");
        else if (happy == sad && happy != 0) System.out.print("Just so so");
        else if (happy < sad) System.out.print("Sad");
    }

    public static int countOccurrences(String str, String substr) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substr, index)) != -1) {
            count++;
            index += substr.length();
        }
        return count;
    }
} 