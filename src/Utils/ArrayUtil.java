package Utils;

/**
 * @ClassName ArrayUtil
 * @Description 通用数组功能
 * @Author 11432
 * @DATE 2019/6/9 8:47
 */
public class ArrayUtil {

    public static void showInts(int... ints){
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }
        System.out.println();
    }
}
