package lab2.zad1;
import lab2.BinarySemaphore;

public class CounterDecr implements Runnable {
    private BinarySemaphore semaphore;
    private Counter counter;
    private int times;

    public CounterDecr(Counter counter, BinarySemaphore semaphore, int times){
        this.counter = counter;
        this.semaphore = semaphore;
        this.times = times;
    }

    public void run() {
        for (int i = 0; i < times ; i++) {
            semaphore.P();
            counter.decrement();
            semaphore.V();
        }
    }
}
