package easy;

/**
 * @ClassName NO7
 * @Description 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Author 11432
 * @DATE 2019/6/9 8:11
 */
public class NO7 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeList(ListNode l1,ListNode l2){
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode lastNode;
        lastNode = newHead;
        while(l1 != null || l2 != null){
            if (l2 != null && (l1 == null || l1.val > l2.val)){
                lastNode.next = l2;
                lastNode = l2;
                l2 = l2.next;
            }else{
                lastNode.next = l1;
                lastNode = l1;
                l1 = l1.next;
            }
        }
        return newHead.next;
    }
}
