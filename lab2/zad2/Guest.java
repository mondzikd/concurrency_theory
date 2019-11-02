package lab2.zad2;

import java.util.concurrent.TimeUnit;

public class Guest extends Thread {
    private Shop shop;
    private int times;
    private int id;

    public Guest(Shop shop, int times, int id){
        this.shop = shop;
        this.times = times;
        this.id = id;
        System.out.println("Guest " + id + " wants to visit shop " + times + " times.");
    }

    public void run(){
        for(int i = 0; i < times; i++){
            System.out.println("Guest " + id + " waits outside the shop.");
            shop.comeIn();
            System.out.println("Guest " + id + " waits for the basket.");
            Basket basket = shop.takeBasket();
            System.out.println("Guest " + id + " has basket " + basket.getId());
            try {
                TimeUnit.MICROSECONDS.sleep(1);                                 // Guest thread is shopping
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Guest " + id + " returns basket " + basket.getId());
            shop.returnBasket(basket);
            shop.goOut();
        }
    }

}
