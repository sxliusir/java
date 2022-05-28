package multithreading;

public class synchronized_test implements Runnable{
    private /*volatile*/ int count = 100;

    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        synchronized_test t = new synchronized_test();
        for(int i=0; i<100; i++) {
            new Thread(t, "THREAD" + i).start();
        }
    }
}
