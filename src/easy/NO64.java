package easy;

/**
 * @ClassName NO64
 * @Description 编写一个程序判断给定的数是否为丑数。
 *              丑数就是只包含质因数 2, 3, 5 的正整数。
 * @Author 11432
 * @DATE 2019/7/19 15:15
 */
public class NO64 {

    /** 首先除2，直到不能整除为止，然后除5到不能整除为止，然后除3直到不能整除为止。最终判断剩余的数字是否为1，如果是1则为丑数，否则不是丑数。*/
    public boolean isUgly(int num) {
        if (num <= 0){
            return false;
        }
        while (num != 1 ){
            if (num % 2 == 0){
                num /= 2;
            }else if (num % 3 == 0){
                num /= 3;
            }else if(num % 5 == 0){
                num /= 5;
            }else {
                break;
            }
        }
        return num == 1;
    }
}
