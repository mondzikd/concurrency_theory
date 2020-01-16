package lab7;

import java.util.concurrent.Semaphore;

public class Fork extends Semaphore {
    private int id;

    public Fork(int i) {
        super(1);
        id = i;
    }

    public int getId() {
        return id;
    }
}
