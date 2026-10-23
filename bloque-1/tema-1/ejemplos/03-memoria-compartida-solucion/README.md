# 03 · Memoria compartida — la solución

Misma escena que el ejemplo 02. Un solo cambio en `Contador`:

```java
public synchronized void incrementar() { ... }
```

## Qué enseñar

- `synchronized` = Lock del objeto (acquire al entrar, release al salir).
- Un hilo entra; el otro espera (sección crítica / exclusión mutua).
- La operación queda **atómica**: o toda, o ninguna (desde fuera).
- Comparad la salida con el ejemplo 02: aquí siempre sale **200_000**.

## Siguiente

`04-memoria-compartida-lock` — la misma solución con `ReentrantLock`.
