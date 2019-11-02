package lab3.zad3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Guest> guests = new ArrayList<>();
        int n = 10;                         // n par osób
        Waiter waiter = new Waiter(n);

        for (int i = 0; i < 2*n; i++) {
            guests.add(new Guest(waiter, i, i/2));
        }
        for (int i = 0; i < 2*n; i++) {
            guests.get(i).join();
            guests.get(i).start();
        }
    }
}
