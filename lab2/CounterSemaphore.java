package lab2;

public class CounterSemaphore {
    private int semaphore;

    public CounterSemaphore(int n){
        semaphore = n;
    }

    public synchronized void P(){
        while(semaphore < 1){
            try{
                wait();
            } catch (InterruptedException e){}
        }
        semaphore--;
    }

    public synchronized void V(){
        semaphore++;
        notifyAll();
    }
}
