package lab1.zad1;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Counter counter = new Counter(0);
        Counter counter2 = new Counter(0);

        CounterRunnableDecr runnable1 = new CounterRunnableDecr(counter);
        CounterRunnableIncr runnable2 = new CounterRunnableIncr(counter);
        Thread thread11 = new Thread(runnable1);
        Thread thread12 = new Thread(runnable2);

        CounterThreadDecr thread21 = new CounterThreadDecr(counter2);
        CounterThreadIncr thread22 = new CounterThreadIncr(counter2);

        thread11.start();
        thread12.start();
        thread21.start();
        thread22.start();
        thread11.join();
        thread12.join();
        thread21.join();
        thread22.join();

        System.out.println("Runnable: " + counter.getNumber());
        System.out.println("Thread: " + counter2.getNumber());
    }
}
