package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName NO35
 * @Description 给定一个链表，判断链表中是否有环。
 *              为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * @Author 11432
 * @DATE 2019/7/10 16:00
 */
public class NO35 {
    /** 双指针  index_1一次走一步，index_2一次做两步，当index_1 == index_2时，该节点即为环的起点 证明略 */
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode index_1 = head;
        ListNode index_2 = head;
        while (index_2 != null && index_2.next != null){
            index_1 = index_1.next;
            index_2 = index_2.next.next;
            if (index_1 == index_2){
                return true;
            }
        }
        return false;
    }

    /** hash表  超级慢 推测hash表的查询及插入 */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}