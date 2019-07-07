package easy;

import java.util.ArrayList;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/7 19:39
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(22);
        for (int i = 1; i < 4; i++) {
            integers.add(integers.size() - 1,i);
        }
        integers.forEach(aInt -> System.out.println(aInt));
    }
}
