package multithread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程协作交换数据
 */
public class ExchangerTest {

    public static void main(String[] args) {


        Exchanger<String> exchanger = new Exchanger<>();


        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("start--" +Thread.currentThread().getName());

                    String exchange = exchanger.exchange(Thread.currentThread().getName());
                    System.out.println(exchange);
                    System.out.println("end--" +Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("start--" +Thread.currentThread().getName());
                    Thread.sleep(10000);
                    String exchange = exchanger.exchange(Thread.currentThread().getName());
                    System.out.println(exchange);
                    System.out.println("end--" +Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
