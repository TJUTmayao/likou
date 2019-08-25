package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName NO167
 * @Description 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。
 *
 * 若无答案，则返回空字符串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/23 17:08
 */
public class NO167 {
    public static void main(String[] args) {
        NO167 no167 = new NO167();
        System.out.println(no167.longestWord(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"}));
//        System.out.println('e'+'w'+'q'+'z');
//        System.out.println('y'+'o'+'d'+'n');
    }
    public String longestWord(String[] words) {
        TrieTree trieTree = new TrieTree();
        Arrays.sort(words);
        for (int i = 0; i < words.length; i++) {
            trieTree.add(words[i]);
        }
        return trieTree.maxStr;
    }

    /** 字典树节点 */
    static class TreeNode{
        char c;
        TreeNode[] nodes = new TreeNode[26];

        public TreeNode(char c) {
            this.c = c;
        }

        public TreeNode() {
        }
    }

    static class TrieTree{
        private TreeNode root = new TreeNode();
        String maxStr = "";

        public void add(String str){
            char[] chars = str.toCharArray();
            TreeNode node = this.root;
            boolean is = true;
            int i;
            for (i = 0; i < chars.length; i++) {
                int k = chars[i] - 97;
                if (node.nodes[k] == null){
                    if (is){
                        is = false;
                        if (maxStr == null){
                            maxStr = str.substring(0,i + 1);
                        }else {
                            // 若当前字符串长度大于最长字符串长度
                            if (maxStr.length() < i + 1){
                                maxStr = str.substring(0,i + 1);
                            } else if (maxStr.length() == i + 1){
                                // 判断字典序
                                String substring = str.substring(0, i + 1);
                                if (maxStr.compareTo(substring) > 0){
                                    maxStr = substring;
                                }
                            }
                        }
                    }
                    node.nodes[k] = new TreeNode(chars[i]);
                }
                node = node.nodes[k];
            }
        }
    }
}
