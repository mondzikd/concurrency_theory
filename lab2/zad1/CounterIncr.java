package lab2.zad1;
import lab2.BinarySemaphore;

public class CounterIncr implements Runnable{
    private BinarySemaphore semaphore;
    private Counter counter;
    private int times;

    public CounterIncr(Counter counter, BinarySemaphore semaphore, int times){
        this.counter = counter;
        this.semaphore = semaphore;
        this.times = times;
    }

    public void run() {
        for (int i = 0; i < times ; i++) {
            semaphore.P();
            counter.increment();
            semaphore.V();
        }
    }
}
