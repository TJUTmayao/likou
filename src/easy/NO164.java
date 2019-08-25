package easy;

/**
 * @ClassName NO164
 * @Description 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 
 * 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
 * 假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/23 15:30
 */
public class NO164 {

    public static void main(String[] args) {
        //["MyLinkedList","addAtHead","addAtHead","deleteAtIndex","addAtIndex","addAtHead","addAtHead","addAtHead","get","addAtTail","addAtIndex","addAtHead"]
        //[[],[5],[2],[1],[1,9],[4],[9],[8],[3],[1],[3,6],[3]]
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(5);
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtIndex(1,9);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtHead(9);
        myLinkedList.addAtHead(8);
        System.out.println(myLinkedList.get(3));
        myLinkedList.addAtTail(1);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5,0);
        myLinkedList.addAtHead(6);
//        System.out.println(myLinkedList.get(0));
//        System.out.println(myLinkedList.get(2));
//        myLinkedList.deleteAtIndex(1);
//        System.out.println(myLinkedList.get(1));
    }
}
class MyLinkedList {

    private Node head;
    private Node tail;
    int length;
    int F;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node();
        tail = head;
        length = 0;
        F = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node = find(index);
        return node == null ? -1 : node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val, head.next, head);
        if (head.next != null){
            head.next.prev = node;
        }
        head.next = node;
        if (tail == head){
            tail = node;
        }
        add(1);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val, null, tail);
        tail.next = node;
        tail = node;
        add(1);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index <= 0){
            addAtHead(val);
        }else {
            if (index == length){
                addAtTail(val);
                return;
            }
            Node node = find(index);
            if (node != null){
                Node newNode = new Node(val, node, node.prev);
                if (node.prev != null){
                    node.prev.next = newNode;
                }
                node.prev = newNode;
                add(1);
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node node = find(index);
        if (node != null){
            if (node == tail){
                tail = tail.prev;
            }
            if (node.prev != null){
                node.prev.next = node.next;
            }
            if (node.next != null){
                node.next.prev = node.prev;
            }
            add(-1);
        }
    }

    public Node find(int index){
        if (index >= length || index < 0){
            return null;
        }
        Node x;
        int i;
        if (index > F){
            i = length - index - 1;
            x = tail;
            while (i > 0 && x != null){
                x = x.prev;
                i--;
            }
        }else {
            i = index;
            x = head.next;
            while (i > 0 && x != null){
                x = x.next;
                i--;
            }
        }
        return x;
    }
    private void add(int i){
        length += i;
        F = length >> 1;
    }
    static class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public Node() {
        }
    }
}
