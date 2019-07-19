package easy;

import java.util.HashMap;

/**
 * @ClassName NO61
 * @Description 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @Author 11432
 * @DATE 2019/7/18 16:22
 */
public class NO61 {

    public static void main(String[] args) {
        NO61 no61 = new NO61();
        System.out.println(no61.isAnagram1("anagram"
                ,"nagaram"));
    }

    /** 非unicode版 */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] ints = new int[26];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ints[chars[i] - 'a'] += 1;
        }
        for (int i = 0; i < chart.length; i++) {
            ints[chart[i] - 'a'] -= 1;
        }
        for (int i : ints) {
            if (i != 0){
                return false;
            }
        }
        return true;
    }
    /** unicode版 */
    public boolean isAnagram1(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c,1);
            }else {
                map.put(c,map.get(c) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)){
                return false;
            }
            map.put(c,map.get(c) - 1);
        }
        for (Integer integer : map.values()){
            if (integer != 0){
                return false;
            }
        }
        return true;
    }

}
