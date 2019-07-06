package easy;

import javafx.util.Pair;

import java.util.*;

/**
 * @ClassName NO24
 * @Description 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @Author 11432
 * @DATE 2019/7/6 10:56
 */
public class NO24 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        levelOrderBottom1(root,0,lists);
        return lists;
    }

    /** 递归 */
    public void levelOrderBottom1(TreeNode root,int depth,List<List<Integer>> lists) {
        if (root == null){
            return;
        }
        if (lists.size() <= depth){
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(root.val);
            lists.add(0,integers);
        }else {
            lists.get(lists.size() - depth - 1).add(root.val);
        }
        levelOrderBottom1(root.left,depth + 1,lists);
        levelOrderBottom1(root.right,depth + 1,lists);
    }

    /** 迭代 */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue.add(new Pair<>(root,0));
        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> poll = queue.poll();
            TreeNode key = poll.getKey();
            if (key != null){
                if (lists.size() <= poll.getValue()){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(key.val);
                    lists.add(0,integers);
                }else {
                    lists.get(lists.size() - poll.getValue() - 1).add(key.val);
                }
                queue.add(new Pair<>(key.left,poll.getValue() + 1));
                queue.add(new Pair<>(key.right,poll.getValue() + 1));
            }
        }
        return lists;
    }
}
