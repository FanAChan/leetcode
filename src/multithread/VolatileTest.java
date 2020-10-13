package multithread;

import java.util.concurrent.*;


/**
 * volatile 关键字
 *
 * 保证可见性 保证取到的是最新的值，但是不会同步更新已保存至工作内存的变量的值（无法更新已获取的值）
 * 保证有序性 使用volatile关键字修饰的变量前后的代码禁止指令重排序，即在之前的代码必须已经执行完成，
 * 之后的代码必须在当前代码执行完成之后
 *
 * 不保证原子性
 *
 * 使用场景：
 *      1 不依赖旧值 例如 count++;
 *      2 没有包含在具有其他变量的不变式中
 *
 *      只有在状态真正独立于程序内其他内容时才能使用 volatile。
 */
public class VolatileTest {


    private static  volatile int count = 0;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 500, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));

        int i = 0;
        while (i < 10) {
            i++;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    int j = 0;
                    while (j < 1000) {
                        count++;
                        j++;
                    }
                    System.out.println(count);
                }
            });
        }
    }
}
