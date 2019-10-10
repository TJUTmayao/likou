package easy;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MO233
 * @Description 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/24 14:49
 */
public class NO233 {
    public static void main(String[] args) {
        NO233 no233 = new NO233();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right.left = new TreeNode(8);
        node.right.right = new TreeNode(9);
        node.left.left.right = new TreeNode(5);

        node.left.left.right.left = new TreeNode(6);
        node.left.left.right.right = new TreeNode(10);

        node.left.left.right.left.left = new TreeNode(13);
        node.left.left.right.left.right = new TreeNode(7);

        node.left.left.right.right.left = new TreeNode(15);
        node.left.left.right.right.right = new TreeNode(14);
        System.out.println(no233.isCousins(node,14,13));
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue_1 = new LinkedList<>();
        Queue<TreeNode> queue_2 = new LinkedList<>();
        queue_1.offer(root);
        boolean flag = false;
        while (!queue_1.isEmpty() || !queue_2.isEmpty()){
            if (queue_1.isEmpty()){
                if (flag){
                    return false;
                }
                Queue k = queue_1;
                queue_1 = queue_2;
                queue_2 = k;
            }
            TreeNode poll = queue_1.poll();
            if (poll != null){
                int i = 0,j = 0;
                if (poll.left != null){
                    i = check(poll.left,x,y,0);
                    queue_2.offer(poll.left);
                }
                if (poll.right != null){
                    j = check(poll.right,x,y,0);
                    queue_2.offer(poll.right);
                }
                if (i == 1 && j == 1){
                    return false;
                }
                if (i == 1 || j == 1){
                    if (flag){
                        return true;
                    }
                    flag = true;
                }

            }
        }
        return false;
    }

    public int check(TreeNode poll,int x,int y,int flag){
        if (poll.val == x || poll.val == y){
            switch (flag){
                case 0:
                    return 1;
                default:
                    return -1;
            }
        }
        return 0;
    }
}
