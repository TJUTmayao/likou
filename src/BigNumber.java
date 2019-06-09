import java.util.ArrayList;

/**
 * @ClassName BigNumber
 * @Description 取一个超过50的数的阶乘
 * @Author 11432
 * @DATE 2019/6/7 20:58
 */
public class BigNumber {

    public static void main(String[] args) {
        System.out.println(getNthPower(2,4));
    }

    /** 大数阶乘   思路：使用数组，每个元素只存结果的一位数 */
    public static String getFactorial(int target){
        //将数的每一位存在一个数组中
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        int after;
        int before;
        int num;
        for (int i = 2; i <= target; i++) {
            num = 0;
            //将每一位乘以相同的数
            for (int j = 0;j == 0 || num > 0 || j < result.size(); j++) {
                if (j >= result.size()){
                    before = 0;
                }else {
                    before = result.get(j);
                }
                //将当前位的数乘以当前的乘数，再加上前一位进的数
                after = before * i + num;
                //获取除个位以外的数,即需要进的数
                num = after / 10;
                //获取当前的个位数，即该下标的新值
                after = after % 10;
                if (j >= result.size()){
                    result.add(after);
                }else {
                    result.set(j , after);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            builder.append(result.get(i));
        }
        return builder.toString();
    }

    /** 数的n次幂 */
    public static String getNthPower(int target,int n){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(target);
        int num,after,befor;
        for (int i = 2; i <= n; i++) {
            num = 0;
            for (int j = 0;j == 0 || num > 0 || j < result.size(); j++) {
                if (j >= result.size()){
                    befor = 0;
                }else {
                    befor = result.get(j);
                }
                after = befor * target + num;
                num = after / 10;
                after %= 10;
                if (j >= result.size()){
                    result.add(after);
                }else {
                    result.set(j,after);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            builder.append(result.get(i));
        }
        return builder.toString();
    }

    public static long check(int target){
        long num = 1;
        for (int i = 2; i <= target; i++) {
            num *= i;
        }
        return num;
    }
}
