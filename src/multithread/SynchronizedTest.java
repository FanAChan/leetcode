package multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * synchronized 互斥锁,
 */
public class SynchronizedTest {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));


        int i = 0;
        while (i < 5) {
            i++;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    SynchronizedTest synchronizedTest = new SynchronizedTest();
                    synchronizedTest.test2();
                }
            });
        }
    }

    private void test() {
        System.out.println("start" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            System.out.println("test----" + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("end" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void test1() {
        System.out.println("start" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            System.out.println("test1----" + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("end" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void test2() {
        System.out.println("start" + Thread.currentThread().getName());
        synchronized (this) {
            try {
                Thread.sleep(1000);
                System.out.println("test2----" + Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("end" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void test3() {
        System.out.println("start" + Thread.currentThread().getName());
        synchronized (SynchronizedTest.class) {
            try {
                Thread.sleep(1000);
                System.out.println("test3-----" + Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("end" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
