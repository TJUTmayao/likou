package easy;

/**
 * @ClassName NO79
 * @Description 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
 *              如果可以构成，返回 true ；否则返回 false。
 *              (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *

 * @Author 11432
 * @DATE 2019/7/21 17:36
 */
public class NO79 {

    public static void main(String[] args) {
        canConstruct("aa","aab");
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] zifu = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            zifu[magazine.charAt(i) - 'a'] += 1;
        }
        for (int i = 0,j; i < ransomNote.length(); i++) {
            j = ransomNote.charAt(i) - 'a';
            zifu[j] -= 1;
            if (zifu[j] < 0){
                return false;
            }
        }
        return true;
    }
}
