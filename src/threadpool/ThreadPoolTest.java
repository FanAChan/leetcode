package threadpool;

import sun.nio.ch.ThreadPool;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.*;

public class ThreadPoolTest {


    public static void main(String[] args) {


        //双节流阀  1 队列？核心线程数？？  2 最大线程数
        //corePoolSize 核心线程池大小
        //maximumPoolSize 最大线程数
        //keepAliveTime 线程最大空闲时间
        //queue 等待队列
        //当nowThreadSize < corePoolSize时 新任务新建线程
        //当nowThreadSize = corePoolSize时 新任务入队列
        //当队列满且 当nowThreadSize < maximumPoolSize时 创建新线程执行队列中的任务
        //当 nowThreadSize = maximumPoolSize 执行任务拒绝策略 RejectedExecutionHandler
        //当 队列为空 且 nowThreadSize > corePoolSize时 空闲线程等待keepAliveTime后销毁
        //threadPoolExecutor.allowCoreThreadTimeOut(); 可令corePoolSize 内线程销毁
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));
//
//        //空闲线程回收 60s 无最大线程数限制 依赖操作系统
//        ExecutorService cachedExcutor = Executors.newCachedThreadPool();
//
//        //单线程线程池 FIFO LIFO顺序执行
//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//

//
//        //定量线程池，超出则等待
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        //可定期或延时执行的定长线程池 执行定时任务或周期性任务
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        //单线程定期或延时线程池
        ScheduledExecutorService singleScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//
//        int[] array = {1,2,3,4,5};
//        for (int i : array) {
//            singleScheduledExecutorService.schedule(()->{
//                System.out.println(Thread.currentThread().getName());
//                System.out.println(System.currentTimeMillis() +"---------------"+i);
//            },i,TimeUnit.SECONDS);
//        }

//        ExecutorService workStealingPool = Executors.newWorkStealingPool();

//        System.out.println((8-1) & 4);

        BigDecimal a  = null;
        BigDecimal subtract = Optional.ofNullable(a).orElse(new BigDecimal(0)).subtract(new BigDecimal(1));

        System.out.println(subtract.intValue());

    }
}
