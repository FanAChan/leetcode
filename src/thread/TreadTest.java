package thread;

public class TreadTest {


    public static void main(String[] args) {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (TreadTest.class) {
                    System.out.println(1);
                    try {
                        System.out.println("thread1 wait");
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(11);


                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (TreadTest.class) {
                    System.out.println(1);
                    try {
                        System.out.println("thread2 wait");
                        Thread.sleep(3000);
                        this.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(11);


                }
            }
        });

        thread.start();


    }
}
