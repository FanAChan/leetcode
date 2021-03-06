package threadpool;

import sun.nio.ch.ThreadPool;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;

public class ThreadPoolTest {


//    public static void main(String[] args) {
//
//
//        //双节流阀  1 队列？核心线程数？？  2 最大线程数
//        //corePoolSize 核心线程池大小
//        //maximumPoolSize 最大线程数
//        //keepAliveTime 线程最大空闲时间
//        //queue 等待队列
//        //当nowThreadSize < corePoolSize时 新任务新建线程
//        //当nowThreadSize = corePoolSize时 新任务入队列
//        //当队列满且 当nowThreadSize < maximumPoolSize时 创建新线程执行队列中的任务
//        //当 nowThreadSize = maximumPoolSize 执行任务拒绝策略 RejectedExecutionHandler
//        //当 队列为空 且 nowThreadSize > corePoolSize时 空闲线程等待keepAliveTime后销毁
//        //threadPoolExecutor.allowCoreThreadTimeOut(); 可令corePoolSize 内线程销毁
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(2));
////
////        //空闲线程回收 60s 无最大线程数限制 依赖操作系统
////        ExecutorService cachedExcutor = Executors.newCachedThreadPool();
////
////        //单线程线程池 FIFO LIFO顺序执行
////        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
////
//
////
////        //定量线程池，超出则等待
////        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
//
//        //可定期或延时执行的定长线程池 执行定时任务或周期性任务
////        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
//
//        //单线程定期或延时线程池
////        ScheduledExecutorService singleScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//
//
//        //-阿里开发手册不允许使用Executors创建默认设置的线程池，目的是更了解线程池的运行规则，避免资源耗尽的风险
//        //使用的是无界阻塞队列，有可能出现OOM
        ScheduledThreadPoolExecutor singleScheduledExecutorService = new ScheduledThreadPoolExecutor(1);
//        singleScheduledExecutorService.setCorePoolSize(1);
////
//        int[] array = {1,2,3,4,5};
//        for (int i : array) {
//            singleScheduledExecutorService.schedule(()->{
//                System.out.println(Thread.currentThread().getName());
//                System.out.println(System.currentTimeMillis() +"---------------"+i);
//            },i,TimeUnit.SECONDS);
//        }
//
////        ExecutorService workStealingPool = Executors.newWorkStealingPool();
//
////        System.out.println((8-1) & 4);
//
//        BigDecimal a  = null;
//        BigDecimal subtract = Optional.ofNullable(a).orElse(new BigDecimal(0)).subtract(new BigDecimal(1));
//
//        System.out.println(subtract.intValue());
//
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10), new ThreadPoolExecutor.CallerRunsPolicy());


            FutureTask command = new FutureTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    Thread.sleep(100);
                    System.out.println(1+Thread.currentThread().getName());
                    return Thread.currentThread().getName();
                }
            });
            FutureTask command2 = new FutureTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    Thread.sleep(100);

                    System.out.println(2+Thread.currentThread().getName());
                    return Thread.currentThread().getName();
                }
            });
            FutureTask command3 = new FutureTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    Thread.sleep(100);
                    System.out.println(3+Thread.currentThread().getName());
                    return Thread.currentThread().getName();
                }
            });
            FutureTask command4 = new FutureTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    Thread.sleep(100);
                    System.out.println(4+Thread.currentThread().getName());
                    return Thread.currentThread().getName();
                }
            });
            FutureTask command5 = new FutureTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    System.out.println(5+Thread.currentThread().getName());
                    return Thread.currentThread().getName();
                }
            });

            threadPoolExecutor.execute(command);

            threadPoolExecutor.execute(command2);

            threadPoolExecutor.execute(command3);

            threadPoolExecutor.execute(command4);

            threadPoolExecutor.execute(command5);


            threadPoolExecutor.shutdownNow();
            System.out.println(threadPoolExecutor.toString());

            Thread.interrupted();
    }
}

class DelayMsg implements Runnable,Delayed{

    private long delayTime;

    public DelayMsg(long delayTime) {
        this.delayTime = delayTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    @Override
    public void run() {

    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }
}
