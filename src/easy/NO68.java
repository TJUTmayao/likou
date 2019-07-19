package easy;

import java.util.HashMap;

/**
 * @ClassName NO68
 * @Description 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * @Author 11432
 * @DATE 2019/7/19 17:11
 */
public class NO68 {

    /** hash */
    public boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        if (strings.length != pattern.length()){
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            char c = pattern.charAt(i);
            String s = map.get(c);
            if (s != null){
                if (!s.equals(strings[i])){
                    return false;
                }
            }else {
                if (map.containsValue(strings[i])){
                    return false;
                }
                map.put(c,strings[i]);
            }
        }
        return true;
    }

    
    /** hash */
    public boolean wordPattern2(String pattern, String str) {
        String[] strings = str.split(" ");
        if (strings.length != pattern.length()){
            return false;
        }
        HashMap<String, Character> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            char c = pattern.charAt(i);
            Character s = map.get(strings[i]);
            if (s != null){
                if (!s.equals(c)){
                    return false;
                }
            }else {
                if (map.containsValue(c)){
                    return false;
                }
                map.put(strings[i],c);
            }
        }
        return true;
    }

}
