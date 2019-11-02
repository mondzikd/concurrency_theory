package lab2.zad2;

import lab2.BinarySemaphore;
import lab2.CounterSemaphore;

import java.util.Stack;

public class Shop {
    private CounterSemaphore counterSemaphore;
    private Stack<Basket> baskets = new Stack<>();
    private BinarySemaphore binarySemaphore = new BinarySemaphore();

    public Shop(int basketsNumber){
        this.counterSemaphore = new CounterSemaphore(basketsNumber);
        for(int i = 0; i < basketsNumber; i++){
            baskets.push(new Basket(i));
        }
    }

    public Basket takeBasket() {
        binarySemaphore.P();
        Basket b = baskets.pop();
        binarySemaphore.V();
        return b;
    }

    public void returnBasket(Basket basket) {
        binarySemaphore.P();
        baskets.push(basket);
        binarySemaphore.V();
    }

    public void comeIn() {
        counterSemaphore.P();
    }

    public void goOut() {
        counterSemaphore.V();
    }
}
