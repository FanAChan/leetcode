package thread;

public class ImplementsRunable {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread2());

        thread.start();
    }
}

class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("myThread2---run---"+Thread.currentThread().getName());
    }
}
