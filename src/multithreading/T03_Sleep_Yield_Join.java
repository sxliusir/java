package multithreading;

public class T03_Sleep_Yield_Join {
    public static void main(String[] args) {
//        testSleep();
//        testYield();
        testJoin();
    }
    private static void testSleep() {
        for(int i=1;i<=10;i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    private static void testYield() {
        new Thread(()->{
            for(int i=0; i<10; i++) {
                System.out.println("A" + i);
                if(i == 2) Thread.yield();
            }
        }).start();

        new Thread(()->{
            for(int i=0; i<10; i++) {
                System.out.println("------------B" + i);
                if(i == 5) Thread.yield();
            }
        }).start();
    }

    private static void testJoin() {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A" + i);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B" + i);
            }
        });

        t1.start();
        t2.start();
    }
}
