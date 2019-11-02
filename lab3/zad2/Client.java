package lab3.zad2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client extends Thread{
    private int id;
    private PrinterMonitor monitor;

    public Client(PrinterMonitor monitor, int id){
        this.monitor = monitor;
        this.id = id;
    }

    public void run() {
        while(true){
            String document = this.createDocumentToPrint();

            Printer printer = null;
            try {
                printer = monitor.reserve();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            printer.print(document);

            try {
                monitor.returnPrinter(printer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String createDocumentToPrint() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        return String.valueOf(id) + " " + formatter.format(new Date());
    }
}
