# 04 · Memoria compartida — Lock explícito

Misma escena que el ejemplo 03, pero con `ReentrantLock`.

La gracia frente a `synchronized` en un método entero:

- El Lock protege **solo un bloque concreto** de código.
- Se ve el **acquire** (`lock()`) y el **release** (`unlock()`).
- El `unlock()` va en un `finally`: si no, un fallo deja el Lock cogido.

```java
lock.lock();   // acquire
try {
    // solo esta critical section
} finally {
    lock.unlock(); // release
}
```

## Qué enseñar

- Comparad con el 03: mismo resultado (200_000), pero aquí controláis el trozo exacto.
- Fuera del `try/finally`, el código no está bajo el Lock.
