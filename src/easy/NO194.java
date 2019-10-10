package easy;

/**
 * @ClassName NO194
 * @Description 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * @Author 11432
 * @DATE 2019/9/4 16:10
 */
public class NO194 {
    public static void main(String[] args) {
        NO194 no194 = new NO194();
        System.out.println(no194.backspaceCompare("y#fo##f"
                ,"y#f#o##f"));
    }
    public boolean backspaceCompare(String S, String T) {
        int maxLength = Math.max(S.length(),T.length());
        char[] chars = new char[maxLength];
        int i = 0;
        for (int j = 0; j < S.length(); j++) {
            if (S.charAt(j) == '#'){
                if (i > 0){
                    i--;
                }
            }else {
                chars[i++] = S.charAt(j);
            }
        }
        String string = new String(chars, 0, i);
        i = 0;
        for (int j = 0; j < T.length(); j++) {
            if (T.charAt(j) == '#'){
                if (i > 0){
                    i--;
                }
            }else {
                chars[i++] = T.charAt(j);
            }
        }
        return string.equals(new String(chars,0,i));
    }
}
