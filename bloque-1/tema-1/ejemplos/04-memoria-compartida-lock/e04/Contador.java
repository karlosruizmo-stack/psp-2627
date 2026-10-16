package e04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock explícito: protege SOLO el bloque que toca la variable.
 * acquire = lock()  |  release = unlock()
 */
public class Contador {
    private int valor = 0;
    private final Lock lock = new ReentrantLock();

    public void incrementar() {
        // Aquí puede haber código que NO necesita el Lock...

        lock.lock(); // acquire: entro en la critical section
        try {
            // Solo este bloque está protegido
            int actual = valor;
            valor = actual + 1;
        } finally {
            lock.unlock(); // release: siempre, aunque falle
        }

        // ...y aquí también, ya fuera del Lock
    }

    public int getValor() {
        return valor;
    }
}
