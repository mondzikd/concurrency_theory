package lab7.waiter;

import lab7.Fork;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int number = 5;
        Philosopher[] philosophers = new Philosopher[number];
        Fork[] forks = new Fork[number];
        Semaphore waiter = new Semaphore(number-1);
        for (int i = 0; i < number; i++) {
            forks[i] = new Fork(i);
        }
        for (int i = 0; i < number; i++) {
            philosophers[i] = new Philosopher(forks[i], forks[(i + 1) % number], 20, waiter);
        }
        for (int i = 0; i < number; i++) {
            Thread thread = new Thread(philosophers[i]);
            thread.join();
            thread.start();
        }
    }
}
