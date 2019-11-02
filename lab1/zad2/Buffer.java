package lab1.zad2;

public class Buffer {
    private String message;
    private boolean empty;

    public synchronized void put(String message){
        while(!empty){
            try{
                wait();
            } catch (InterruptedException e) {}
        }
        empty = false;
        this.message = message;
        notifyAll();
    }

    public synchronized String take(){
        while(empty){
            try{
                wait();
            } catch (InterruptedException e){}
        }
        empty = true;
        notifyAll();
        return message;
    }
}
