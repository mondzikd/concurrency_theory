package lab7.asymetric;

import lab7.Fork;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int number = 5;
        Philosopher[] philosophers = new Philosopher[number];
        Fork[] forks = new Fork[number];

        for (int i = 0; i < number; i++) {
            forks[i] = new Fork(i);
        }
        for (int i = 0; i < number; i++) {
            if(i % 2 == 0)
                philosophers[i] = new Philosopher(forks[(i + 1) % number], forks[i], 20);
            else
                philosophers[i] = new Philosopher(forks[i], forks[(i + 1) % number], 20);
        }
        for (int i = 0; i < number; i++) {
            Thread thread = new Thread(philosophers[i]);
            thread.join();
            thread.start();
        }
    }
}
