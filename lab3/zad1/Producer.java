package lab3.zad1;

public class Producer extends Thread{
    private BoundedBuffer buffer;

    public Producer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int ILOSC = 5;
        for(int i = 0;  i < ILOSC;   i++) {
            try {
                buffer.put("message " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
