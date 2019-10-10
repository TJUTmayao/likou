package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NO201
 * @Description 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/6 15:13
 */
public class NO201 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        digui(root1,list1);
        digui(root2,list2);
        if (list1.size() != list2.size()){
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)){
                return false;
            }
        }
        return true;
    }

    public void digui(TreeNode root, List<Integer> list){
        if (root.left != null){
            digui(root.left,list);
        }
        else if (root.right == null){
            list.add(root.val);
        }
        if (root.right != null){
            digui(root.right,list);
        }
    }
}
