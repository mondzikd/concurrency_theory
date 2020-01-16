package lab7.startving_semaphores;

// Something similar to AND-Semaphore
// PhilosopherPlace tells when two forks are free
// Class name could just as well be FreeForks

import java.util.concurrent.Semaphore;

public class PhilosopherPlace {
    private Semaphore table;
    private int freeForks = 2;
    int id;

    public PhilosopherPlace(Semaphore table, int id){
        this.table = table;
        this.id = id;
    }

    public synchronized void decrease(){
        freeForks--;
    }

    public synchronized boolean acquire(){
        if(freeForks < 2){
            try {
                table.release();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;        // try again
        }
        return false;           // acquired
    }

    public synchronized void increase(){
        freeForks++;
        notifyAll();
    }

    public synchronized void release(){
//        nothing needed here
    }
}
