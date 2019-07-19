package easy;

import java.util.ListIterator;
import java.util.Stack;

/**
 * @ClassName NO58
 * @Description 请判断一个链表是否为回文链表。
 * @Author 11432
 * @DATE 2019/7/17 13:54
 */
public class NO58 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(1);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(isPalindrome(listNode));
    }
    /** 快慢指针 + 翻转后半部分链表 */
    public static boolean isPalindrome(ListNode head) {
        ListNode k = head;
        ListNode m = head;
        while (k != null && k.next != null){
            k = k.next.next;
            m = m.next;
        }
        if (m == k){
            return true;
        }
        ListNode last = null;
        ListNode next;
        while (m != null){
            next = m.next;
            m.next = last;
            last = m;
            m = next;
        }
        while (head != m && last != null){
            if (head.val != last.val){
                return false;
            }
            head = head.next;
            last = last.next;
        }
        return true;
    }

    /** 栈 */
    public static boolean isPalindrome1(ListNode head) {
        if (head == null){
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        while (node != null && !stack.isEmpty()){
            if (stack.pop().val != node.val){
                return false;
            }
            node = node.next;
        }
        return stack.isEmpty() && node == null;
    }
}


