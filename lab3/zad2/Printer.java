package lab3.zad2;

public class Printer extends Thread{
    private int id;

    public Printer(int id){
        this.id = id;
    }

    public void print(String document) {
        System.out.println("Printer" + id + ": '" + document + "'");
    }
}
