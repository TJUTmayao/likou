import java.util.Random;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 11432
 * @DATE 2019/7/23 16:39
 */
public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
