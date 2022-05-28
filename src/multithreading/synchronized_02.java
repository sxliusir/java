package multithreading;
/*
    同步和非同步方法是否可以同时调用？
 */

public class synchronized_02 {
    public synchronized void f1() {
        System.out.println("synchronized fuc");
        for(int i=1;i<=10;i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A" + i);
        }
    }

    public void f2() {
        System.out.println("unsynchronized fuc");
        for(int i=1;i<=10;i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B" + i);
        }
    }

    public static void main(String[] args) {
        synchronized_02 synchronized_02 = new synchronized_02();
        new Thread(synchronized_02::f1, "f1").start();
        new Thread(synchronized_02::f2, "f2").start();
    }
}
