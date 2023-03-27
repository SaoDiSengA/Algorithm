import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        System.out.println(s);
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(isPlindrome(s.substring(0,i)+s.substring(i+1))){
                count++;
            }
        }
        if(count == 0 ){
            System.out.println("NO");

        }else{
            System.out.println("YES");
        }

    }
    public static boolean isPlindrome(String s){
        //判断是否为回文
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}