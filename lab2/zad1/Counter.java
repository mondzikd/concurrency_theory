package lab2.zad1;

public class Counter {
    private int number;
    public void increment(){
        number++;
    }
    public void decrement(){
        number--;
    }
    public int getNumber(){
        return number;
    }
    public Counter(int n){
        number = n;
    }
}
