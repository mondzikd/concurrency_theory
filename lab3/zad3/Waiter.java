package lab3.zad3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Waiter {
    private Lock lock = new ReentrantLock();
    private Condition waitForFriend = lock.newCondition();
    private Condition waitForTable = lock.newCondition();

    private int[] pairVolume;
    private int seatsOccupied = 0;

    public Waiter(int pairNumber){
        pairVolume = new int[pairNumber];
        for(int i = 0; i < pairNumber; i++) pairVolume[i] = 0;
    }

    public void tablePlease(int pairID) throws InterruptedException {
        lock.lock();
        try{
            pairVolume[pairID]++;
            while(pairVolume[pairID] == 1){
                waitForFriend.await();
            }
            while(pairVolume[pairID] == 2){
                if (seatsOccupied != 0)     waitForTable.await();           // if else not to wait for free table
                else                        pairVolume[pairID] = 0;
            }
            seatsOccupied++;
            waitForFriend.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void releaseTable() {
        lock.lock();
        try {
            seatsOccupied--;
            if(seatsOccupied == 0){
                waitForTable.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}
