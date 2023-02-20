/***
 * 剑指 Offer 35. 复杂链表的复制
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 */
public class CopyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        //遍历head并在每一个节点后加上一个复制的新节点
        for(Node node = head;node != null;node = node.next.next){
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        //遍历head，此时已经有新加节点了，这次遍历复制random的值
        for(Node node = head;node!=null;node = node.next.next){
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        //这次遍历改变node节点的next指针
        for(Node node = head;node!=null;node = node.next){
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }

        return headNew;

    }
}
