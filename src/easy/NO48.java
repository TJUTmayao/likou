package easy;

import java.util.List;

/**
 * @ClassName NO48
 * @Description TODO
 * @Author 11432
 * @DATE 2019/7/14 14:19
 */
public class NO48 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        head = listNode;
        while (listNode.next != null){
            if (listNode.next.val == val){
                listNode.next = listNode.next.next;
            }else {
                listNode = listNode.next;
            }
        }
        return head.next;
    }
}
