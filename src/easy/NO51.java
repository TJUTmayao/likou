package easy;

import java.util.Stack;

/**
 * @ClassName NO51
 * @Description 反转一个单链表。
 * @Author 11432
 * @DATE 2019/7/16 10:40
 */
public class NO51 {

    /** 笨方法 栈 */
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode node = head;
        while (!stack.isEmpty()){
            head.next = stack.pop();
        }
        return node;
    }
    /** 笨方法 三指针 */
    public ListNode reverseList1(ListNode head) {
        ListNode lastNode = null;
        ListNode cNode;
        while (head != null){
            cNode = head.next;
            head.next = lastNode;
            lastNode = head;
            head = cNode;
        }
        return lastNode;
    }

    /** 递归 */
    public ListNode reverseList2(ListNode head) {
        ListNode digui = digui(head);
        if (digui == null)return null;
        head.next = null;
        return digui;
    }
    public ListNode digui(ListNode head){
        if (head == null || head.next == null ){
        return head;
        }
        // 记录新链头
        ListNode node = digui(head.next);
        head.next.next = head;
        return node;
    }
}
