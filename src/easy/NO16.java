package easy;

/**
 * @ClassName NO16
 * @Description 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 * @Author 11432
 * @DATE 2019/6/23 9:35
 */
public class NO16 {

    public static void main(String[] args) {
        System.out.println(addBinary("0",
                "0"));
    }

    public static String addBinary(String a, String b) {
        return a.length() > b.length() ? addBin(a,b) : addBin(b,a);
    }

    public static String addBin(String a, String b){
        char[] as = a.toCharArray();
        int num = 0;
        int count;
        for (int i = as.length - 1,j = b.length() - 1; i >= 0; i--,j--) {
            if (j < 0){
                count = getInt(as[i]) + num;
            }else {
                count = getInt(as[i]) + getInt(b.charAt(j)) + num;
            }
            num = count / 2;
            if (count % 2 == 0){
                as[i] = '0';
            }else {
                as[i] = '1';
            }
        }
        return (num == 0 ? "" : "1") + new String(as);
    }

    public static int getInt(char c){
        switch (c){
            case '0':
                return 0;
            case '1':
                return 1;
        }
        return -1;
    }

//    if (j < 0){
//        if (num != 0){
//            if (as[i] == '1'){
//                builder.insert(0,0);
//            }else {
//                builder.insert(0,1);
//                num = 0;
//            }
//        }else {
//            builder.insert(0,as[i]);
//        }
//        continue;
//    }
//            if (as[i] == '1' && bs[j] == '1'){
//        if (num == 0){
//            builder.insert(0,0);
//        }else {
//            builder.insert(0,1);
//        }
//        num = 1;
//    }else if (as[i] == '1' ^ bs[j] == '1'){
//        if (num == 0){
//            builder.insert(0,1);
//        }else {
//            builder.insert(0,0);
//        }
//    }else if(as[i] != '1' && bs[j] != '1'){
//        if (num == 0){
//            builder.insert(0,0);
//        }else {
//            builder.insert(0,1);
//        }
//        num = 0;
//    }
}
