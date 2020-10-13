package multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrivateLockTest {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));

        int i = 0;
        while (i < 5) {
            i++;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    PrivateLockTest lockTest = new PrivateLockTest();
                    lockTest.test1();
                }
            });
        }
    }

    private void test() {
        try {
            System.out.println("start" + Thread.currentThread().getName());
            System.out.println("getLock" + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("end" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }

    private void test1() {
        lock.lock();
        try {
            System.out.println("start" + Thread.currentThread().getName());
            System.out.println("getLock" + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("end" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
