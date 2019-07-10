package easy;

/**
 * @ClassName NO37
 * @Description 编写一个程序，找到两个单链表相交的起始节点。
 * @Author 11432
 * @DATE 2019/7/10 17:40
 */
public class NO37 {

    /** 双指针 分别从两个链头出发 到达链尾时转到连一个链表链头 两个指针相等时即为对应相交节点*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode index1 = headA;
        ListNode index2 = headB;
        while (index1 != index2){
            if (index1 == null){
                index1 = headB;
            }else {
                index1 = index1.next;
            }
            if(index2 == null){
                index2 = headA;
            }else {
                index2 = index2.next;
            }
        }
        return index1;
    }

}
