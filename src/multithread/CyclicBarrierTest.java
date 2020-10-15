package multithread;

import java.util.concurrent.*;

/**
 * 一组线程均达到某个位置后再同时开始执行
 *  cyclicBarrier.await();
 *
 *  可循环使用的屏障，均到达屏障前才会开门，线程才会继续运行
 *
 * 可调用reset重复使用
 *
 *
 * 人齐才发车
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);


        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("start--" + Thread.currentThread().getName());
        int i = 0;
        while (i < 4) {
            i++;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("start--" +Thread.currentThread().getName());
                        cyclicBarrier.await();
                        System.out.println("end--" +Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("end");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("end------");
    }
}
