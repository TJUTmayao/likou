package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NO62
 * @Description 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * @Author 11432
 * @DATE 2019/7/18 17:02
 */
public class NO62 {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> strings = new ArrayList<>();
        digui(root,new StringBuilder(),strings);
        return strings;
    }
    public void digui(TreeNode root,StringBuilder s,List<String> list){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            list.add(s.toString() + root.val);
            return;
        }
        String s1 = root.val + "->";
        s.append(s1);
        digui(root.left,s,list);
        digui(root.right,s,list);
        s.delete(s.lastIndexOf(s1),s.length());
    }

    /** 递归2 */
    public List<String> binaryTreePaths1(TreeNode root) {
        ArrayList<String> strings = new ArrayList<>();
        digui2(root,new StringBuilder(),strings);
        return strings;
    }
    public void digui2(TreeNode root,StringBuilder s,List<String> list){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            list.add(s.toString() + root.val);
            return;
        }
        String s1 = root.val + "->";
        if (root.left != null && root.right != null){
            s.append(s1);
            StringBuilder builder = new StringBuilder(s);
            digui2(root.left,s,list);
            digui2(root.right,builder,list);
        }else {
            s.append(s1);
            digui2(root.left,s,list);
            digui2(root.right,s,list);
        }
    }
}
