package lab2;

public class BinarySemaphore {
    private boolean semaphore;

    public BinarySemaphore(){
        semaphore = true;
    }

    public synchronized void P(){
        while(!semaphore){
            try{
                wait();
            } catch (InterruptedException e){}
        }
        semaphore = false;
    }

    public synchronized void V(){
        semaphore = true;
        notifyAll();           // notify() or notifyAll() ?????
    }
}
