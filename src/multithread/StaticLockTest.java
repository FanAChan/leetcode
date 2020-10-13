package multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock 接口 乐观锁，基于volatile和CAS实现
 *  可实现公平锁 非公平锁 读写锁
 *  主要方法 lock unlock trylock
 *  获取锁失败时阻塞等待，必须主动释放锁
 *  可中断等待锁的线程
 *
 */
public class StaticLockTest {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
        StaticLockTest lockTest = new StaticLockTest();

        int i = 0;
        while (i < 5) {
            i++;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
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
