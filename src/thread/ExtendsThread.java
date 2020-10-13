package thread;

public class ExtendsThread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("main---"+Thread.currentThread().getName());
    }
}

class MyThread extends Thread{

    @Override
    public void run() {

        System.out.println("myThread---run---"+Thread.currentThread().getName());
    }
}
