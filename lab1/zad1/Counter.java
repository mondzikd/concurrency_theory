package lab1.zad1;

public class Counter {
    public int number;
    public synchronized void increment(){
        number += 1;
    }
    public synchronized void decrement(){
        number -= 1;
    }
    public synchronized int getNumber(){
        return number;
    }
    public Counter(int n){
        number = n;
    }
}
