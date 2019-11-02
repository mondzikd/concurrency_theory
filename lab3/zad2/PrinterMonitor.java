package lab3.zad2;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterMonitor {
    final Lock lock = new ReentrantLock();
    final Condition notEmpty = lock.newCondition();

    Stack<Printer> printers = new Stack<>();

    public PrinterMonitor(int M){
        for(int i = 0; i < M; i++){
            printers.push(new Printer(i));
        }
    }

    public Printer reserve() throws InterruptedException {
        lock.lock();
        try {
            while (printers.isEmpty())
                notEmpty.await();
            return printers.pop();
        } finally {
            lock.unlock();
        }
    }

    public void returnPrinter(Printer x) throws InterruptedException {
        lock.lock();
        try {
            printers.push(x);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
}
