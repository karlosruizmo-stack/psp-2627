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

Orden en clase: **01 → 02 → … → 09**.
