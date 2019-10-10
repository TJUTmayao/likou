package other;

/**
 * @ClassName ThreadLocalTest
 * @Description 测试 ThreadLocal
 * @Author 11432
 * @DATE 2019/9/18 14:09
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Thread01()).start();
        }
    }

    static class Thread01 implements Runnable{
        /** Thread 类内置 ThreadLocalMap 属性，该属性为该线程私有。
         * 每一个 ThreadLocal 对象代表 Map 中的一个 Key-Value 对
         * （因为 ThreadLocal 类内存储着唯一的 Key，ThreadLocal.
         * get()方法为根据 ThreadLocal 中的 Key 从 ThreadLocalMap
         * 中取出相应的 Value）*/
        private ThreadLocal<String> threadLocal = new ThreadLocal<>();
        private ThreadLocal<Integer> threadLocal_2 = new ThreadLocal<>();
        @Override
        public void run() {
            int v = (int) (Math.random() * 100);
            threadLocal.set(Thread.currentThread().getName() + ": " + v);
            threadLocal_2.set(v + 100);
            try {
                Thread.sleep(v * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(threadLocal.get() + " %-----% " + Thread.currentThread().getName() + ": " + v);
            System.out.print("***");
            System.out.println(threadLocal_2.get() + " %----% " + (v+100));
        }
    }
}
