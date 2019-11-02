package lab1.zad1;

public class CounterRunnableIncr implements Runnable {
    Counter counter;

    public void run() {
        for (int i = 0; i < 100000000 ; i++) {
            counter.increment();
        }
    }

    public CounterRunnableIncr(Counter counter){
        this.counter = counter;
    }
}
