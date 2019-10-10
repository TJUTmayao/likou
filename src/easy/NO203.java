package easy;

/**
 * @ClassName NO203
 * @Description 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 * @Author 11432
 * @DATE 2019/9/6 17:21
 */
public class NO203 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode man = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            man = man.next;
        }
        return man;
    }
}
