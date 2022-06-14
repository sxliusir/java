package Volatile;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    AtomicInteger count = new AtomicInteger(0);

    void m() {
        for (int i = 0; i<10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        AtomicIntegerTest t = new AtomicIntegerTest();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i< 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }
        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
