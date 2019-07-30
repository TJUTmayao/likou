package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NO93
 * @Description 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *              字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * @Author 11432
 * @DATE 2019/7/28 15:27
 */
public class NO93 {
    public static void main(String[] args) {
        NO93 no93 = new NO93();
        System.out.println(no93.findAnagrams2("baa"
                ,"aa"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        if (s.length() < p.length()){
            return list;
        }
        int[] ints = new int[26];
        int[] ints_2 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ints[p.charAt(i) - 'a'] ++;
            ints_2[s.charAt(i) - 'a'] ++;
        }
        if (check(ints,ints_2)){
            list.add(0);
        }
        for (int i = 0,j = p.length(); j < s.length(); i++,j++) {
            ints_2[s.charAt(i) - 'a'] --;
            ints_2[s.charAt(j) - 'a'] ++;
            if (check(ints,ints_2)){
                list.add(i + 1);
            }
        }
        return list;
    }
    public boolean check(int[] a1,int[] a2){
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]){
                return false;
            }
        }
        return true;
    }

    /** 滑动窗口 */
    public List<Integer> findAnagrams2(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        if (s.length() < p.length()){
            return list;
        }
        int[] ints = new int[26];
        int[] ints_2 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ints[p.charAt(i) - 'a'] ++;
        }
        int i,j;
        for (i = 0,j = 0;j < s.length();){
            int value = s.charAt(j) - 'a';
            ints_2[value]++;
            while (ints[value] < ints_2[value]){
                ints_2[s.charAt(i) - 'a'] --;
                i++;
            }
            if (j - i == p.length()){
                list.add(i);
            }
            j++;
        }
        return list;
    }
}
