package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName NO90
 * @Description 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * @Author 11432
 * @DATE 2019/7/27 14:42
 */
public class NO90 {

    /** 迭代 慢*/
    public List<List<Integer>> levelOrder(Node root) {
        if (null == root){
            return new ArrayList<>();
        }
        Queue<Node> queue_1 = new LinkedList<>();
        Queue<Node> queue_2 = new LinkedList<>();
        queue_1.offer(root);
        Node poll;
        List<List<Integer>> res = new ArrayList<>();
        while (!queue_1.isEmpty() || !queue_2.isEmpty()){
            Queue<Node> M = queue_1.isEmpty() ? queue_2 : queue_1;
            Queue<Node> N = !queue_1.isEmpty() ? queue_2 : queue_1;
            ArrayList<Integer> list = new ArrayList<>();
            while (!M.isEmpty()){
                poll = M.poll();
                if (poll != null){
                    list.add(poll.val);
                    for (Node child : poll.children) {
                        N.offer(child);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
    /** 递归 快*/
    public List<List<Integer>> levelOrder2(Node root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        digui(root,res,0);
        return res;
    }

    public void digui(Node root,List<List<Integer>> res,int c){
        if (res.size() <= c){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(list);
        }else {
            res.get(c).add(root.val);
        }
        for (Node child : root.children) {
            if (child != null){
                digui(child,res,c + 1);
            }
        }
    }

}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
