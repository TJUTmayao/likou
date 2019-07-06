package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName NO22
 * @Description 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * @Author 11432
 * @DATE 2019/7/6 9:23
 */
public class NO22 {

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetric(root.left,root.right);
    }

    /** 比较结构--深度优先搜索 */
    public boolean isSymmetric(TreeNode left,TreeNode right) {
        if (left == null || right == null){
            if (left == right){
                return true;
            }
            return false;
        }
        if (left.val == right.val){
            return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        }
        return false;
    }

    /** 迭代 */
    public boolean isSymmetric2(TreeNode root) {
        if(root == null){return true;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null || node2 == null){
                if (node1 == node2){
                    continue;
                }
                return false;
            }
            if (node1.val == node2.val){
                queue.add(node1.left);
                queue.add(node2.right);
                queue.add(node1.right);
                queue.add(node2.left);
            }else {
                return false;
            }
        }
        return true;
    }
}
