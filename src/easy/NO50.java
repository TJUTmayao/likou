package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName NO50
 * @Description 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身
 *
 * @Author 11432
 * @DATE 2019/7/15 10:38
 */
public class NO50 {

    public static void main(String[] args) {
        NO50 no50 = new NO50();
        System.out.println(no50.isIsomorphic2("egg","add"));
    }
    public boolean isIsomorphic(String s, String t) {
        int[] n1 = new int[s.length()];
        int[] n2 = new int[t.length()];
        int x = getInts(s, n1);
        int y = getInts(t, n2);
        if (x != y){
            return false;
        }
        for (int i = 0; i < n1.length; i++) {
            if (n1[i] != n2[i]){
                return false;
            }
        }
        return true;
    }
    public int getInts(String s,int[] n1){
        char[] chars_1 = s.toCharArray();
        int x = 0;
        HashMap<Character, Integer> map_1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map_1.containsKey(chars_1[i])){
                map_1.put(chars_1[i],x ++);
            }
            n1[i] = map_1.get(chars_1[i]);
        }
        return x;
    }
    /** 节省空间 */
    public boolean isIsomorphic1(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(chars[i])){
                if (map.containsValue(chart[i])){
                    return false;
                }
                map.put(chars[i],chart[i]);
            }else if (map.get(chars[i]) != chart[i]){
                    return false;
            }
        }
        return true;
    }
    /** 空间换时间 */
    public boolean isIsomorphic2(String s, String t) {
        int[] n1 = new int[128];
        int[] n2 = new int[128];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (n1[chars[i]] != 0 && n1[chars[i]] != chart[i]){
                return false;
            }
            if (n2[chart[i]] != 0 && n2[chart[i]] != chars[i]){
                return false;
            }
            n1[chars[i]] = chart[i];
            n2[chart[i]] = chars[i];
        }
        return true;
    }
}
