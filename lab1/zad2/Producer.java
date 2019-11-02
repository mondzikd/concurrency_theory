package lab1.zad2;

public class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int ILOSC = 5;
        for(int i = 0;  i < ILOSC;   i++) {
            buffer.put("message " + i);
        }

    }
}
