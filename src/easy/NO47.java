package easy;

/**
 * @ClassName NO47
 * @Description 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * @Author 11432
 * @DATE 2019/7/14 13:36
 */
public class NO47 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    /** 暴力法 出现相同的平方和返回false */
    public static boolean isHappy(int n) {
        int num ;
        while (true){
            num = 0;
            while (n != 0){
                num += Math.pow(n % 10,2);
                n /= 10;
            }
            n = num;
            if (n < 10){
                if (n == 1 || n == 7){
                    return true;
                }
                return false;
            }
        }
    }

    /** 数学法 1-9只有1,7为快乐数 */
    public static boolean isHappy1(int n) {
        if (n == 1 || n == 7){
            return true;
        }
        if (n < 10){
            return false;
        }
        int num = 0;
        while (n != 0){
            num += Math.pow(n % 10,2);
            n /= 10;
        }
        return isHappy(num);
    }
}
