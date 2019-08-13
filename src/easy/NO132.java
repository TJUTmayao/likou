package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NO132
 * @Description 给定一个 N 叉树，返回其节点值的前(后)序遍历。
 * @Author 11432
 * @DATE 2019/8/12 16:56
 */
public class NO132 {
    /** 前序 */
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> integers = new ArrayList<>();
        digui(root,integers);
        return integers;
    }
    public void digui(Node root,List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        for (Node child : root.children) {
            digui(child,list);
        }
    }

    /** 后序 */
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> integers = new ArrayList<>();
        digui2(root,integers);
        return integers;
    }
    public void digui2(Node root,List<Integer> list){
        if (root == null){
            return;
        }
        for (Node child : root.children) {
            digui2(child,list);
        }
        list.add(root.val);
    }
}
