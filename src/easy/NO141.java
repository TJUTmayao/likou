package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName NO141
 * @Description 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * @Author 11432
 * @DATE 2019/8/13 17:31
 */
public class NO141 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        int num = 0;
        double he = 0;
        ArrayList<Double> list = new ArrayList<>();
        while (true){
            if (queue1.isEmpty()){
                list.add(he / num);
                he = 0;
                num = 0;
                Queue x = queue1;
                queue1 = queue2;
                queue2 = x;
            }
            if (queue1.isEmpty() && queue2.isEmpty()){
                break;
            }
            TreeNode poll = queue1.poll();
            if (poll != null){
                he += poll.val;
                num++;
                if (poll.left != null){
                    queue2.offer(poll.left);
                }
                if (poll.right != null){
                    queue2.offer(poll.right);
                }
            }
        }
        return list;
    }

    public List<Double> averageOfLevels2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        double num;
        ArrayList<Double> list = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            num = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null){
                    num += poll.val;
                    if (poll.left != null){
                        queue.offer(poll.left);
                    }
                    if (poll.right != null){
                        queue.offer(poll.right);
                    }
                }
            }
            list.add(num / size);
        }
        return list;
    }
}
