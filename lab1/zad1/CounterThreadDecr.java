package lab1.zad1;

public class CounterThreadDecr extends Thread{
    Counter counter;

    public void run() {
        for (int i = 0; i < 100000000 ; i++) {
            counter.decrement();
        }
    }

    public CounterThreadDecr(Counter counter){
        this.counter = counter;
    }
}
