package lab1.zad2;

public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int ILOSC = 5;
        for(int i = 0;  i < ILOSC;   i++) {
            String message = buffer.take();
            System.out.println("Consumer: " + message);
        }

    }
}
