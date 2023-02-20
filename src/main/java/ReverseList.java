/***
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode ahead = head;
        ListNode p;
        if(head == null){
            return null;
        }else{
            head = head.next;
        }
        ahead.next = null;
        while(head != null){
            p = head;
            head = head.next;
            p.next = ahead;
            ahead = p;
        }
        return ahead;
    }
}
