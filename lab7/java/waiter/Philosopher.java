package lab7.waiter;

import lab7.Fork;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable{
    private final Semaphore waiter;
    private Fork leftFork;
    private Fork rightFork;
    private long party_time;

    public Philosopher(Fork leftFork, Fork rightFork, long party_time, Semaphore waiter) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.party_time = party_time;
        this.waiter = waiter;
    }

    @Override
    public void run() {
        long party_start = System.currentTimeMillis();
        ArrayList<Long> times = new ArrayList();

        while ((System.currentTimeMillis() - party_start) < party_time * 1000) {
            doAction("thinking");
            think();

            long start = System.nanoTime();
            doAction("want to eat");
            pick_up_forks();
            long finish = System.nanoTime();
            long timeElapsed = finish - start;

            doAction("eating after " + timeElapsed);
            eat();

            put_down_forks();

            times.add(timeElapsed);
        }

        long averageTime = 0;
        long sum = 0;
        if (!times.isEmpty()) {
            for (Long time : times) {
                sum += time;
            }
            averageTime = sum / times.size();
        }

        doAction(times.size() + " eats, average time: " + averageTime / 1000000 +  "ms");
    }

    private void pick_up_forks() {
        try {
            waiter.acquire();
            leftFork.acquire();
            rightFork.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void put_down_forks() {
        leftFork.release();
        rightFork.release();
        waiter.release();
    }

    private void eat(){
        try {
            Thread.sleep(((int) (Math.random() * 100)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void think(){
        try {
            Thread.sleep(((int) (Math.random() * 100)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doAction(String action){
        System.out.println(
                Thread.currentThread().getName() + ": " + action);
    }
}