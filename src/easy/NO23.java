package easy;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NO23
 * @Description 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @Author 11432
 * @DATE 2019/7/6 10:09
 */
public class NO23 {
    /** 递归 */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int i1 = maxDepth(root.left);
        int i2 = maxDepth(root.right);
        return i1 > i2 ? i1 + 1 : i2 + 1;
    }

    /** 迭代 */
    public int maxDepth2(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root,0));
        int maxDepth = 0;
        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> poll = queue.poll();
            maxDepth = poll.getValue();
            if (poll.getKey() != null){
                queue.add(new Pair<>(poll.getKey().left,poll.getValue() + 1));
                queue.add(new Pair<>(poll.getKey().right,poll.getValue() + 1));
            }
        }
        return maxDepth;
    }

}
