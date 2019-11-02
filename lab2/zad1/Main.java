package lab2.zad1;

import lab2.BinarySemaphore;

public class Main {
    public static void main(String args[]) throws InterruptedException{
        BinarySemaphore binarySemaphore = new BinarySemaphore();
        Counter counter = new Counter(0);

        CounterDecr runnable1 = new CounterDecr(counter, binarySemaphore, 5000000);
        CounterIncr runnable2 = new CounterIncr(counter, binarySemaphore, 5000000);
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        binarySemaphore.P();
        System.out.println("Counter: " + counter.getNumber());
        binarySemaphore.V();
    }
}
