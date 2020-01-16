package lab7.starving_monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Table {
    final Lock lock = new ReentrantLock();
    final Condition[] philo;
    private final int size;
    private final int[] free;

    public Table(int number){
        this.size = number;
        free = new int[number];
        philo = new Condition[number];
        for(int i = 0; i < number; i++){
            philo[i] = lock.newCondition();
            free[i] = 2;
        }
    }

    public void take(int id) throws InterruptedException {
        lock.lock();
        try{
            while(free[id] < 2){
                philo[id].await();
            }
            free[(id + 1) % size] -= 1;
            free[(id + size - 1) % size] -= 1;
        }
        finally {
            lock.unlock();
        }
    }

    public void put(int id) throws InterruptedException {
        lock.lock();
        try{
            free[(id + 1) % size] += 1;
            free[(id + size - 1) % size] += 1;
            if(free[(id + 1) % size] == 2)
                philo[(id + 1) % size].signal();
            if(free[(id + size - 1) % size] == 2)
                philo[(id + size - 1) % size].signal();
        }
        finally {
            lock.unlock();
        }
    }
}
