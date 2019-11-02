package lab3.zad2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int N = 10;         // ilosc watkow Client
        int M = 8;          // ilosc drukarek Printer
        PrinterMonitor monitor = new PrinterMonitor(M);

        List<Client> clients = new ArrayList<>();

        for(int i = 0; i < N; i++){
            clients.add(new Client(monitor, i));
        }
        for(int i = 0; i < N; i++){
            clients.get(i).join();
            clients.get(i).start();
        }
    }
}
