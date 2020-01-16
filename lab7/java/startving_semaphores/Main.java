package lab7.startving_semaphores;

import lab7.Fork;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int number = 5;

        Philosopher[] philosophers = new Philosopher[number];
        Fork[] forks = new Fork[number];
        PhilosopherPlace[] places = new PhilosopherPlace[number];

        Semaphore table = new Semaphore(1);

        for (int i = 0; i < number; i++) {
            forks[i] = new Fork(i);
            places[i] = new PhilosopherPlace(table, i);
        }

        for (int i = 0; i < number; i++) {
            philosophers[i] = new Philosopher(forks[i], forks[(i + 1) % number], 20, table,
                    places[(i + number - 1) % number], places[i], places[(i + 1) % number]);
        }

        for (int i = 0; i < number; i++) {
            Thread thread = new Thread(philosophers[i]);
            thread.join();
            thread.start();
        }
    }
}
