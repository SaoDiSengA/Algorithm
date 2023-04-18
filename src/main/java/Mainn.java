import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Mainn {

    public static String[] getwordschain(String[] words) {

        int n = words.length;
        for(int i = 0; i < n;i++){
            String word = words[i];
            char word1 = word.charAt(word.length()-1);
            boolean flag = false;
            if(flag==false) {
                for (int j = i + 1; j < n; j++) {
                    if(words[j].charAt(0) == word1){
                        String temp = words[j];
                        words[j] = words[i+1];
                        words[i+1] = temp;
                        flag = true;
                        break;
                    }
                }
                word1 += 1;
            }
        }
        return words;
    }
    public static void main(String[] args) {
        String[] words = getwordschain(new String[]{"abs","fgg","solute","gt","ww","ead"});
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }



    }
}

