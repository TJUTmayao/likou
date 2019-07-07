package easy;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NO27
 * @Description 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @Author 11432
 * @DATE 2019/7/7 11:22
 */
public class NO27 {

    /** 迭代版 */
    public int minDepth1(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root,1));
        int min = 0;
        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> poll = queue.poll();
            TreeNode key = poll.getKey();
            if (key != null){
                min = poll.getValue();
                if (key.left == null && key.right == null){
                    return poll.getValue();
                }else {
                    queue.add(new Pair<>(key.left,poll.getValue() + 1));
                    queue.add(new Pair<>(key.right,poll.getValue() + 1));
                }
            }
        }
        return min;
    }


    /** 递归版 */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth != 0 && rightDepth != 0){
            return leftDepth > rightDepth ? rightDepth + 1 : leftDepth + 1;
        }
        return leftDepth == 0 ? rightDepth + 1: leftDepth + 1;
    }
}
