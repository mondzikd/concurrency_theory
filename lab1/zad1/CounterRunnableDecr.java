package lab1.zad1;

public class CounterRunnableDecr implements Runnable{
    Counter counter;

    public void run() {
        for (int i = 0; i < 100000000 ; i++) {
            counter.decrement();
        }
    }

    public CounterRunnableDecr(Counter counter){
        this.counter = counter;
    }
}
