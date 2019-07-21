package easy;

/**
 * @ClassName NO73
 * @Description 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * @Author 11432
 * @DATE 2019/7/20 16:06
 */
public class NO73 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        char c;
        for (int i = 0,j = chars.length - 1; i < j;) {
            if (!isVowel(chars[i])){
                i ++;
                continue;
            }
            if (!isVowel(chars[j])){
                j --;
                continue;
            }
            c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i ++;
            j --;
        }
        return new String(chars);
    }

    public boolean isVowel(char c){
        switch (c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
                default:
                    return false;
        }
    }
}
