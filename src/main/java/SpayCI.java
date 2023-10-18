import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpayCI {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
//        输入描述
//        第一行读入用空格隔开的两个正整数n,k 。
//
//        第二行读入用空格隔开的n个正整数ai 。
//
//        对于所有的数据：
//
//        输出描述
//        一行输出用空格隔开的n个正整数，表示按时间从早到晚离席的人的编号。
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //n个人
        int k = scanner.nextInt(); //每次数k个人
        List<Integer> hot = new ArrayList<>();
        ListNode head = new ListNode(Integer.MAX_VALUE,null);
        ListNode tail = head;
        tail.next = head;
        for (int i = 0; i < n; i++) {
            ListNode cur = new ListNode(scanner.nextInt(),null);
            cur.next = tail.next;
            tail.next = cur;
            tail = tail.next;
        }
//        List<Integer> gone = new ArrayList<>();
//        int i = 0;
//        int j = 0;
//        while(gone.size() < n){
//
//        }



    }
}
