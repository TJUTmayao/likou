package easy;

/**
 * @ClassName NO19
 * @Description 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @Author 11432
 * @DATE 2019/7/6 8:01
 */
public class NO19 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode x,y;
        x = y = head;
        while (y != null){
            if (x.val == y.val){
                y = y.next;
            } else {
                x.next = y;
                x = y;
                y = y.next;
            }
        }
        if (x != null){
            x.next = y;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
