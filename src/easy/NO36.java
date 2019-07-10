package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName NO36
 * @Description 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * @Author 11432
 * @DATE 2019/7/10 16:29
 */
public class NO36 extends MinStack{

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
    }

}
/** 耗时较长，思路有问题，没必要维护一个同步且元素相同的栈，但该栈提供获取Min N（N个最小值） */
class MinStack {

    private ArrayList<Integer> minStack;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        this.minStack = new ArrayList<>();
        this.stack = new Stack<>();
    }

    public void push(int x) {
        this.stack.push(x);
        int i;
        for (i = 0; i < minStack.size(); i++) {
            if (minStack.get(i) > x){
                break;
            }
        }
        if (i == minStack.size()){
            minStack.add(x);
        }else {
            minStack.add(i,x);
        }
    }
    public void pop() {
        Integer pop = stack.pop();
        minStack.remove(pop);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.get(0);
    }
}
/** 标答，非同步栈 */
class MinStack2 {
    private Stack<Integer> data, min;

    public MinStack2() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        if (min.isEmpty() || x <= min.peek())
            min.push(x);
        data.push(x);
    }

    public void pop() {
        if (min.peek().equals(data.peek()))
            min.pop();
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
/** 参考后 ，题目仅要求获取最小值 ，仅需要将每次push的小于等于辅助栈栈顶的值放入辅助栈栈顶，保证多个相同最小值时出栈一个不会出错，
 * 而大于辅助栈栈顶的值出栈入栈都不会影响最小值，所以没有必要进入辅助栈
 * 出栈时仅当出栈的值与辅助栈栈顶相同时才删除辅助栈栈顶，而大于辅助栈栈顶的值因为不会入栈辅助栈所以不影响 */
class MinStack3 {
    private Stack<Integer> data, min;

    public MinStack3() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        if (min.isEmpty() || min.peek() >= x){
            min.push(x);
        }
        data.push(x);
    }

    public void pop() {
        Integer pop = data.pop();
        if (min.peek().equals(pop)){
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}