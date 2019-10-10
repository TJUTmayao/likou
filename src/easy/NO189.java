package easy;

/**
 * @ClassName NO189
 * @Description 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 *
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 *
 * 山羊拉丁文的规则如下：
 *
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 *
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 *
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * 返回将 S 转换为山羊拉丁文后的句子。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/goat-latin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/1 19:08
 */
public class NO189 {
    private int[] ints = {1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0};
    public String toGoatLatin(String S) {
        StringBuilder a = new StringBuilder().append('a');
        StringBuilder res = new StringBuilder();
        String[] split = S.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (isVowel(split[i].charAt(0))){
                res.append(split[i]).append("ma").append(a);
            }else {
                res.append(split[i].substring(1)).append(split[i].charAt(0)).append("ma").append(a);
            }
            if(i < split.length - 1){
                res.append(' ');
            }
            a.append('a');
        }
        return res.toString();
    }
    public boolean isVowel(char c){
        if (c >= 97){
            return ints[c - 97] == 1;
        }
        if (c >= 65){
            return ints[c - 65] == 1;
        }
        return false;
    }
}
