package easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName NO187
 * @Description 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 *
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-common-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/31 15:45
 */
public class NO187 {

    public static void main(String[] args) {
        NO187 no187 = new NO187();
        System.out.println(no187.mostCommonWord("Bob",new String[]{}));
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedMap = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        String maxStr = "";
        int max = 0;
        for (String string : banned) {
            bannedMap.add(string);
        }
        for (int i = 0,j = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (i == paragraph.length() - 1 || !isCase(c)){
                if(isCase(c)){
                    i ++;
                }
                // 转换为小写
                String string = paragraph.substring(j,i).toLowerCase();
                // 判断是否为禁用词
                if (!bannedMap.contains(string)){
                    Integer integer = map.get(string);
                    if (integer == null){
                        map.put(string,1);
                        if (max == 0){
                            maxStr = string;
                            max = 1;
                        }
                    }else {
                        integer ++;
                        map.put(string,integer);
                        if (integer > max){
                            maxStr = string;
                            max = integer;
                        }
                    }
                }
                // 跳过其他非字母
                j = i;
                while (j < paragraph.length() && !isCase(paragraph.charAt(j))){
                    j++;
                }
                i = j;
            }
        }
        return maxStr;
    }

    public boolean isCase(char c){
        return Character.isLowerCase(c) || Character.isUpperCase(c);
    }
}
