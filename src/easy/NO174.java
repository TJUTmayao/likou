package easy;

import java.util.Arrays;

/**
 * @ClassName NO174
 * @Description 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。
 *
 * 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 *
 * 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
 *
 * 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-completing-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/28 14:30
 */
public class NO174 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] ints = new int[26];
        int[] haves = new int[26];
        int sum = 0;
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isUpperCase(c)){
                ints[c - 65] ++;
                sum ++;
            }else if (Character.isLowerCase(c)){
                ints[c - 97] ++;
                sum ++;
            }
        }
        String res = null;
        for (int i = 0; i < words.length; i++) {
            if (sum > words.length){
                break;
            }
            if (res == null || words[i].length() < res.length()){
                for (int j = 0; j < words[i].length(); j++) {
                    char c = words[i].charAt(j);
                    if (Character.isUpperCase(c)){
                        haves[c - 65] ++;
                    }else {
                        haves[c - 97] ++;
                    }
                }
                boolean is = true;
                for (int j = 0; j < haves.length; j++) {
                    if (haves[j] < ints[j]){
                        is = false;
                    }
                    haves[j] = 0;
                }
                if (is){
                    res = words[i];
                }
            }
        }
        return res;
    }

}
