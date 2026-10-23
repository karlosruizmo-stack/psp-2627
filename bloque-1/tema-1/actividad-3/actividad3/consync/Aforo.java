package consync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Aforo {
    private int entradas = 0;
    private final Lock lock = new ReentrantLock();

    public void entrar() {
        lock.lock();
        try {
            entradas++;
        } finally {
            lock.unlock();
        }
    }

    public int getTotal() {
        return entradas;
    }
}
