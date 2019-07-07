package easy;

import javafx.util.Pair;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NO28
 * @Description 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @Author 11432
 * @DATE 2019/7/7 11:49
 */
public class NO28 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(-2);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
//        head.left = node1;
        head.right = node2;
//        node1.left = node3;
//        node3.left = node6;
//        node3.right = node7;
//        node2.left = node4;
//        node2.right = node5;
//        node5.right = node8;
        System.out.println(hasPathSum1(head,-5));
    }

    /** 递归版 */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        return has(root,sum);
    }

    public static boolean has(TreeNode root, int sum){
        if (root == null) {
            return false;
        }
        int newSum = sum - root.val;
        if (root.left == null && root.right == null){
            return newSum == 0;
        }else {
            return has(root.left,newSum) || has(root.right,newSum);
        }
    }


    /** 迭代 */
    public static boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root,sum));
        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> poll = queue.poll();
            TreeNode key = poll.getKey();
            if(key != null){
                int value = poll.getValue() - key.val;
                if (value == 0){
                    if (key.left == null && key.right == null){
                       return true;
                    }
                }
                queue.add(new Pair<>(key.left,value));
                queue.add(new Pair<>(key.right,value));
            }
        }
        return false;
    }
}
