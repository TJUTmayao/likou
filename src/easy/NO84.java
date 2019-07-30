package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NO84
 * @Description 计算给定二叉树的所有左叶子之和。
 * @Author 11432
 * @DATE 2019/7/26 9:16
 */
public class NO84 {
    /** 递归 */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int he = 0, i = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                he = root.left.val;
            } else {
                he = sumOfLeftLeaves(root.left);
            }
        }
        i = sumOfLeftLeaves(root.right);
        return he + i;
    }

    /** 迭代 */
    public int sumOfLeftLeaves2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                if (poll.left != null) {
                    if (poll.left.left == null && poll.left.right == null) {
                        num += poll.left.val;
                    } else {
                        queue.offer(poll.left);
                    }
                }
                queue.offer(poll.right);
            }
        }
        return num;
    }
}
