package lab3.zad1;

public class Consumer extends Thread{
    private BoundedBuffer buffer;

    public Consumer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int ILOSC = 5;
        for(int i = 0;  i < ILOSC;   i++) {
            String message = null;
            try {
                message = (String)buffer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer: " + message);
        }

    }
}
