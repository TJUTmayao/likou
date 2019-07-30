package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NO83
 * @Description 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * @Author 11432
 * @DATE 2019/7/23 14:56
 */
public class NO83 {
    /** h-4,m-6 暴力法 直接枚举所有0：00 - 11:59 */
    public List<String> readBinaryWatch(int num) {
        int hn;
        int mn;
        int x;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            hn = 0;
            x = i;
            while (x != 0){
                if ((x & 1) == 1){
                    hn ++;
                }
                x >>= 1;
            }
            for (int j = 0; j < 60; j++) {
                mn = 0;
                x = j;
                while (x != 0){
                    if ((x & 1) == 1){
                        mn ++;
                    }
                    x >>= 1;
                }
                if (mn + hn == num){
                    String time = i + ":" + (j > 9 ? j :"0"+ j);
                    list.add(time);
                }
            }
        }
        return list;
    }
    public List<String> readBinaryWatch2(int num) {
        int[] ints = {0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,2,3,3,4,3,4,4,5,3,4,4,5};
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (ints[i] + ints[j] == num){
                    list.add(i + ":" + (j > 9 ? j :"0"+ j));
                }
            }
        }
        return list;
    }

    /** 回溯 */
    public List<String> readBinaryWatch3(int num) {
        int[] ints = {0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,2,3,3,4,3,4,4,5,3,4,4,5};
        ArrayList<String> list = new ArrayList<>();
        digui(num,0,0,ints,list);
        return list;
    }
    public void digui(int num,int H,int M,int[] oneNum,List<String> list){
        if (H > 11){
            return;
        }
        if (oneNum[H] + oneNum[M] == num){
            list.add(H + ":" + (M > 9 ? M : "0" + M));
        }
        if (M < 59){
            digui(num,H,M + 1,oneNum,list);
        }else {
            digui(num,H + 1,0,oneNum,list);
        }
    }


//    public List<String> readBinaryWatch2(int num) {
//
//    }

    public static void main(String[] args) {
        int x;
        int mn;
        for (int i = 0; i < 60; i++) {
            mn = 0;
            x = i;
            while (x != 0){
                if ((x & 1) == 1){
                    mn ++;
                }
                x >>= 1;
            }
            System.out.print(mn + ",");
        }
    }

}
