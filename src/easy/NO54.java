package easy;

import java.util.*;

/**
 * @ClassName NO54
 * @Description 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空

 * @Author 11432
 * @DATE 2019/7/16 14:33
 */
public class NO54 {


}
class MyStack{

    private List<Integer> queue;

/** Initialize your data structure here. */
    public MyStack() {
        this.queue = new ArrayList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return this.queue.remove(queue.size() - 1);
    }

    /** Get the top element. */
    public int top() {
        return this.queue.get(queue.size() - 1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queue.isEmpty();
    }
}
