package lab3.zad3;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Guest extends Thread{
    private Waiter waiter;
    private int pairID;
    private int id;

    public Guest(Waiter waiter, int id, int pairID){
        this.pairID = pairID;
        this.id = id;
        this.waiter = waiter;
    }

    public void run(){
        while(true) {
            try {
                TimeUnit.MICROSECONDS.sleep((new Random()).nextInt(1000));             //  personal things to do
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(id + " waits for the table");

            try {
                waiter.tablePlease(pairID);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(id + " has the table");

            try {
                TimeUnit.MICROSECONDS.sleep((new Random()).nextInt(1000));             //  eating
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(id + " finished eating");

            waiter.releaseTable();
        }
    }
}
