# Ejemplos · Tema 1 · Hilos

Mini-proyectos para proyectar en clase. Cada carpeta es un ejemplo independiente.

| # | Carpeta | Qué enseña | Después de la diapositiva |
|---|---------|------------|---------------------------|
| 01 | `01-crear-hilos` | El hilo `main` crea otros. Dos caminos: heredar `Thread` o implementar `Runnable`. | 17 |
| 02 | `02-memoria-compartida-problema` | Dos hilos pisan el mismo contador sin Lock → resultado incorrecto. | Comparten casa |
| 03 | `03-memoria-compartida-solucion` | El mismo ejemplo con `synchronized` → siempre 200_000. | Solución 1 · synchronized |
| 04 | `04-memoria-compartida-lock` | Misma solución con `ReentrantLock` (`lock` / `unlock`). | Solución 2 · Lock explícito |
| 05 | `05-tres-hilos-orden-arbitrario` | Tres hilos + Lock: contador siempre 3; el orden de acquire cambia. | Secuencia Lock |
| 06 | `06-wait-notify` | Bebé espera la comida: `wait` + `notify`. | wait, notify |
| 07 | `07-wait-notifyAll` | Varios bebés, un cocinero: `notify` vs `notifyAll`. | wait, notify |
| 08 | `08-deadlock` | Dos Locks en orden distinto → deadlock. | Interbloqueo |
| 09 | `09-sleep` | `Thread.sleep`: se para un rato y sigue solo (sin notify). | sleep |
| 10 | `10-secuencial-y-paralelo` | 1.000 tareas de 20 ms: primero en `main`, luego en 10 hilos. `main` guarda todos los resultados. | Paralela |
| 11 | `11-distribuido-archivo` | Dos procesos se pasan 5 tareas por `canal.txt`. Sin memoria compartida. | Distribuida |
| 12 | `12-distribuido-json` | Lo mismo que el 11, pero el canal lleva un objeto JSON. `Canal` lo escribe y lo lee. | Distribuida |

Orden en clase: **01 → 02 → … → 12**.
