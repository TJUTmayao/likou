package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName No180
 * @Description 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * @Author 11432
 * @DATE 2019/8/30 14:44
 */
public class No180 {
    public static void main(String[] args) {
        List<String> strings = new No180().letterCasePermutation2("a1b2");
        for (String string : strings) {
            System.out.print(string + "\t");
        }
    }
    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        res.add(S);
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLowerCase(S.charAt(i))|| Character.isUpperCase(S.charAt(i))){
                int j = i + 1;
                int k = res.size();
                Character c = (char)(Character.isLowerCase(S.charAt(i)) ? S.charAt(i) - 32 : S.charAt(i) + 32);
                String replace = c.toString();
                for (int x = 0;x < k; x++) {
                    res.add(new StringBuilder(res.get(x)).replace(i,j,replace).toString());
                }
            }
        }
        return res;
    }

    public List<String> letterCasePermutation2(String S) {
        ArrayList<String> res = new ArrayList<>();
        digui(S.toCharArray(),0,res);
        return res;
    }

    /** 全排列可以考虑 -- 深度遍历 */
    public void digui(char[] chars,int index,List<String> list){
        if (index == chars.length){
            list.add(String.valueOf(chars));
            return;
        }
        // 不变的分支
        digui(chars,index + 1,list);
        // 变的分支
        if (isCase(chars[index])){
            chars[index] =(char) (Character.isLowerCase(chars[index]) ? chars[index] - 32 : chars[index] + 32);
            digui(chars,index + 1,list);
        }
    }

    public boolean isCase(char c){
        return Character.isUpperCase(c) || Character.isLowerCase(c);
    }
}
