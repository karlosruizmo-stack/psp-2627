# 10 · Secuencial y paralelo

El mismo trabajo, dos veces. 1.000 tareas. Cada una tarda 20 ms.

## Qué mirar

- `Secuencial`: solo el hilo `main`. 1.000 × 20 ms ≈ 20 s. `main` guarda cada resultado en su array.
- `Paralelo`: 10 hilos, 100 tareas cada uno. El reloj baja a unos 2 s. Cada hilo calcula su tramo; después del `join`, **main copia** todos los resultados a su array.
- Cada tarea suma 1. El resultado final tiene que ser **1000** en los dos. Mismo trabajo, distinto tiempo.

## Cómo ejecutarlo

1. Run `e10.Secuencial` (tarda ~20 s).
2. Run `e10.Paralelo`.
