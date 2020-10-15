package multithread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 通过信号量控制并发程度
 * 获取到信号量才允许继续运行，否则阻塞等待
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        System.out.println("start--" + Thread.currentThread().getName());
        int i = 0;
        while (i < 5) {
            i++;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("start--" +Thread.currentThread().getName());
                        semaphore.acquire();
                        System.out.println("end--" +Thread.currentThread().getName());
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        }
    }
}
