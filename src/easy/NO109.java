package easy;

import java.util.ArrayList;

/**
 * @ClassName NO109
 * @Description 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 * @Author 11432
 * @DATE 2019/8/6 16:20
 */
public class NO109 {
    public static void main(String[] args) {
        String[] words = findWords(new String[]{"abdfs", "cccd", "a", "qwwewm"});
        System.out.println();
    }
    public static String[] findWords(String[] words) {
        int[] positions = {2, 1, 1, 2, 3, 2, 2, 2, 3, 2, 2, 2, 1, 1, 3, 3, 3, 3, 2, 3, 3, 1, 3, 1, 3, 1};
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String string = words[i];
            int k = 0;
            int last = 0;
            for (int j = 0; j < string.length(); j++) {
                char c = string.charAt(j);
                if (c > 90){
                    c = (char)(c - 32);
                }
                k = positions[c - 'A'];
                if (last != 0 && k != last){
                    break;
                }
                last = k;
            }
            if (k == last){
                strings.add(string);
            }
        }
        return strings.toArray(new String[strings.size()]);
    }
}
