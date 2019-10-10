package easy;

/**
 * @ClassName NO197
 * @Description 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * @Author 11432
 * @DATE 2019/9/4 17:32
 */
public class NO197 {
    public static void main(String[] args) {
        NO197 no197 = new NO197();
        System.out.println(no197.buddyStrings("aa","aa"));
    }
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()){
            return false;
        }
        int[] ints = new int[2];
        int index = 0;
        int[] nums = new int[26];
        boolean ok = false;
        char[] chars = A.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != B.charAt(i)){
                if (index < 2){
                    ints[index++] = i;
                }else {
                    return false;
                }
            }else {
                if (!ok && nums[chars[i] - 97]++ >= 1){
                    ok = true;
                }
            }
        }
        if (index == 0){
            return ok;
        }
        if (index < 2){
            return false;
        }
        return chars[ints[0]] == B.charAt(ints[1]) && chars[ints[1]] == B.charAt(ints[0]);
    }
}
