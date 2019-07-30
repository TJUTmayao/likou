package other;

import java.util.Random;

/**
 * @ClassName OneTwoPage
 * @Description TODO
 * @Author 11432
 * @DATE 2019/7/23 16:24
 */
public class OneTwoPage {

    public static void main(String[] args) {
        int[] ints = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            ints[i] = random.nextInt(50);
        }
        getMax2(0,60,ints,-1);
    }

    public static void getMax(int weight,int n,int[] array,int i,int last){
        if (weight >= n || i >= 10){
            System.out.println(weight == n ? weight : weight - array[last]);
            return;
        }
        getMax(weight,n,array,i + 1,last);
        if (weight <= n){
            getMax(weight + array[i],n,array,i + 1,i);
        }
    }

    public static void getMax2(int weight,int n,int[] array,int last){
        if (weight >= n){
            System.out.println(weight == n ? weight : weight - last);
            return;
        }
        for (int j = 0; j < array.length; j++) {
            if (array[j] == -1){

            }else {
                int i1 = array[j];
                array[j] = -1;
                getMax2(weight + i1,n,array,i1);
                array[j] = i1;
            }
        }
    }


}
