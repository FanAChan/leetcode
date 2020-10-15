package multithread;

import jdk.nashorn.internal.ir.CallNode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个线程或多个线程等待另一组线程执行后执行
 * 执行countDownLatch.await();阻塞等待计数器，知道计数器为0
 *
 * 执行countDownLatch.countDown()减少计数器
 *
 *
 * 倒计时，所有准备工作完成，倒计时结束才可进行后续的事项
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("start--" + Thread.currentThread().getName());
        int i = 0;
        while (i < 5) {
            i++;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        System.out.println("end--" +Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }

        try {
            System.out.println("start2--" + Thread.currentThread().getName());
            countDownLatch.await();
            Thread.sleep(2000);
            System.out.println("end--" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
