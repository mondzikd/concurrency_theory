package lab2.zad2;
import lab2.CounterSemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int basketsNumber = 5;
        int guestsNumber = 10;
        Random random = new Random();

        Shop shop = new Shop(basketsNumber);
        List<Guest> guests = new ArrayList<>();

        for(int i = 0; i < guestsNumber; i++){
            guests.add(new Guest(shop, random.nextInt(10), i));
        }
        for(int i = 0; i < guestsNumber; i++){
            guests.get(i).join();
            guests.get(i).start();
        }
    }
}
