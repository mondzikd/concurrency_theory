package lab7.starving_monitor;

import lab7.Fork;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int number = 5;
        Philosopher[] philosophers = new Philosopher[number];
        Fork[] forks = new Fork[number];
        Table table = new Table(number);

        for (int i = 0; i < number; i++) {
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < number; i++) {
            philosophers[i] = new Philosopher(forks[i], forks[(i + 1) % number], 20, table, i);
        }

        for (int i = 0; i < number; i++) {
            Thread thread = new Thread(philosophers[i]);
            thread.join();
            thread.start();
        }
    }
}
