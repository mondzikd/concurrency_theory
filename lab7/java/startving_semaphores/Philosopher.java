package lab7.startving_semaphores;

import lab7.Fork;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable{
    private PhilosopherPlace leftNeighbour;
    private PhilosopherPlace rightNeighbour;
    private PhilosopherPlace place;
    private Fork leftFork;
    private Fork rightFork;
    private Semaphore table;
    private long partyTime;

    public Philosopher(Fork leftFork, Fork rightFork, long partyTime, Semaphore table, PhilosopherPlace leftNeighbour,
                       PhilosopherPlace place, PhilosopherPlace rightNeighbour) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.partyTime = partyTime;
        this.table = table;
        this.leftNeighbour = leftNeighbour;
        this.rightNeighbour = rightNeighbour;
        this.place = place;
    }

    @Override
    public void run() {
        long party_start = System.currentTimeMillis();
        ArrayList<Long> times = new ArrayList();

        while ((System.currentTimeMillis() - party_start) < partyTime * 1000) {
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
        if(!times.isEmpty()) {
            for(Long time : times) {
                sum += time;
            }
            averageTime = sum / times.size();
        }

        doAction(times.size() + " eats, average time: " + averageTime / 1000000 +  "ms");

    }

    private void pick_up_forks() {
        try {
            do{
                table.acquire();
            }while(place.acquire());
            leftNeighbour.decrease();
            rightNeighbour.decrease();
            leftFork.acquire();
            rightFork.acquire();
            table.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void put_down_forks() {
        try {
            table.acquire();
            leftFork.release();
            rightFork.release();
            place.release();
            leftNeighbour.increase();
            rightNeighbour.increase();
            table.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
