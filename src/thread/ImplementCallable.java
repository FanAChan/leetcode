package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ImplementCallable {

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName());
                return "callable";
            }
        });
        new Thread(task).start();
        try {
            System.out.println("1111111");
            //等待获取子线程返回
            String s = task.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


