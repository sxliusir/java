package multithreading;

public class T04_ThreadState {
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(this.getState());
            for(int i=1;i<=10;i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myThread.getState());
    }
}
