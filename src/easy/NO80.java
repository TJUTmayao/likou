package easy;

/**
 * @ClassName NO80
 * @Description 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @Author 11432
 * @DATE 2019/7/21 18:02
 */
public class NO80 {
    public int firstUniqChar(String s) {
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 97] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (ints[s.charAt(i) - 97] == 1){
                return i;
            }
        }
        return -1;
    }

}
