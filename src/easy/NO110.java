package easy;

import org.omg.PortableInterceptor.INACTIVE;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @ClassName NO110
 * @Description 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 *
 * @Author 11432
 * @DATE 2019/8/6 16:46
 */
public class NO110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.right = node1;
        node1.left = node2;
        NO110 no110 = new NO110();
        int[] mode = no110.findMode(root);
        Arrays.stream(mode).forEach(System.out :: println);
    }

    /** 不使用额外空间 注意，流处理很慢，前驱节点可以用全局变量记录 */
    private int num = 1;
    private TreeNode last = null;
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (root != null){
            digui2(root,integers);
        }
        int[] ints = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ints[i] = integers.get(i);
        }
        return ints;
    }

    public void digui2(TreeNode root,List<Integer> list){
        if (root.left != null){
            digui2(root.left,list);
        }
        if (last != null){
            if (last.val == root.val){
                num ++;
            }else {
                num = 1;
            }
        }
        if (num > max){
            max = num;
            list.clear();
            list.add(root.val);
        }else if (num == max){
            list.add(root.val);
        }
        last = root;
        if (root.right != null){
            digui2(root.right,list);
        }
    }


    /** 使用额外空间 */
    private HashMap<Integer,Integer> map = new HashMap<>();
    private int max = 0;

    public int[] findMode2(TreeNode root) {
        digui(root);
        ArrayList<Integer> integers = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() == max){
                integers.add(entry.getKey());
            }
        }
        return integers.stream().mapToInt(Integer :: valueOf).toArray();
    }

    public void digui(TreeNode root){
        if (root == null){
            return;
        }
        Integer integer = map.get(root.val);
        if (integer == null){
            map.put(root.val,1);
        }else {
            integer ++;
            if (integer > max){
                max = integer;
            }
            map.put(root.val,integer);
        }
        digui(root.left);
        digui(root.right);
    }

}
