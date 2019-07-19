package easy;

/**
 * @ClassName NO60
 * @Description 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * @Author 11432
 * @DATE 2019/7/18 16:12
 */
public class NO60 {
    public void deleteNode(ListNode node) {
        ListNode last = null;
        while (node.next != null){
            node.val = node.next.val;
            last = node;
            node = node.next;
        }
        last.next = null;
    }


    /** 没必要将所有后续节点的值交换 */
    public void deleteNode2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
