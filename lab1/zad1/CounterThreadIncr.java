package lab1.zad1;

public class CounterThreadIncr extends Thread{
    Counter counter;

    public void run() {
        for (int i = 0; i < 100000000 ; i++) {
            counter.increment();
        }
    }

    public CounterThreadIncr(Counter counter){
        this.counter = counter;
    }
}
