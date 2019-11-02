package lab3.zad1;

public class Main {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();
        (new Producer(buffer)).start();
        (new Producer(buffer)).start();
        (new Consumer(buffer)).start();
        (new Consumer(buffer)).start();
    }
}
