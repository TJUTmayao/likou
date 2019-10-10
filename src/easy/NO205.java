package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName NO205
 * @Description 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 *
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 *
 * 返回所有不常用单词的列表。
 *
 * 您可以按任何顺序返回列表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uncommon-words-from-two-sentences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/9 14:57
 */
public class NO205 {
    public static void main(String[] args) {
        NO205 no205 = new NO205();
        System.out.println(no205.uncommonFromSentences("this apple is sweet"
                ,"this apple is sour"));
    }
    public String[] uncommonFromSentences(String A, String B) {
        String[] splitA = A.split(" ");
        String[] splitB = B.split(" ");
        HashMap<String,Boolean> map = new HashMap<>();
        for (String string : splitA) {
            Boolean isHave = map.get(string);
            if (isHave == null){
                map.put(string,true);
            }else {
                map.put(string,false);
            }
        }
        for (String string : splitB) {
            Boolean isHave = map.get(string);
            if (isHave == null){
                map.put(string,true);
            }else {
                map.put(string,false);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String,Boolean> entry : map.entrySet()){
            if (entry.getValue()){
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
