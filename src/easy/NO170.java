package easy;

/**
 * @ClassName NO170
 * @Description 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 *
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 *
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 *
 * 最后返回经过上色渲染后的图像。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/24 15:24
 */
public class NO170 {
    public static void main(String[] args) {
        int[][] image = {{0,0,0},{0,1,1}};
        int[][] ints = new NO170().floodFill(image, 1, 1, 1);
        System.out.println();
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] ints = new int[image.length][image[0].length];
        digui(image,sr,sc,newColor,image[sr][sc],ints);
        image[sr][sc] = newColor;
        return image;
    }

    public void digui(int[][] image, int sr, int sc, int newColor,int oldColor,int[][] ints){
        // 上
        for (int i = sr + 1; i < image.length && image[i][sc] == oldColor; i++) {
            change(image,i,sc,newColor,oldColor,ints);
        }
        // 下
        for (int i = sr - 1; i >= 0 && image[i][sc] == oldColor; i--) {
            change(image,i,sc,newColor,oldColor,ints);
        }
        // 左
        for (int i = sc + 1; i < image[sr].length && image[sr][i] == oldColor; i++) {
            change(image,sr,i,newColor,oldColor,ints);
        }
        // 右
        for (int i = sc - 1; i >= 0 && image[sr][i] == oldColor; i--) {
            change(image,sr,i,newColor,oldColor,ints);
        }
    }

    public void change(int[][] image,int x,int y,int newColor,int oldColor,int[][] ints){
        if (ints[x][y] == 0){
            image[x][y] = newColor;
            ints[x][y] = 1;
            digui(image,x,y,newColor,oldColor,ints);
        }
    }
}
