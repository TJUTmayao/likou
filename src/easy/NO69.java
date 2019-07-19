package easy;

/**
 * @ClassName NO69
 * @Description 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 *
 *              你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 *
 * @Author 11432
 * @DATE 2019/7/19 17:40
 */
public class NO69 {

    public static void main(String[] args) {
        NO69 no69 = new NO69();
        System.out.println(no69.canWinNim(8));
    }


    /** 脑筋急转弯 若石子数量为4的倍数，不论如何拿，在最后轮到你时，总是剩下4个石子，这时你无论怎么拿都是输 */
    /** 总结：两个人轮流拿取石子，每次最多拿N个，最少1个，那么，如果是先手，石子总数不为（N-1）的倍数是必赢，若是后手，石子总数为（N-1）倍数时必赢*/
    public boolean canWinNim(int n) {
        return n % 4 == 0;
    }
}
