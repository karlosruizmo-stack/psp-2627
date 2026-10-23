# 11 · Distribuido por archivo

Dos procesos. No comparten memoria. Se hablan por `canal.txt`.

Ese archivo hace de canal. En un sistema de verdad sería Redis, una cola, una base de datos o una llamada entre microservicios. Aquí es un texto para poder leer el mensaje.

## Qué mirar

- `Trabajador` espera. No hace nada hasta que llega una orden.
- `Main` escribe `ejecuta tarea 1`. El trabajador deja `estoy trabajando` en el archivo, espera 5 s y luego escribe `tarea 1 completa`.
- `Main` lee esa respuesta, **guarda el resultado** y también espera 5 s antes de mandar la siguiente. Así cinco veces. Luego escribe `fin`.
- Son 5 tareas, no 1.000: solo para ver el intercambio.

## Cómo ejecutarlo

Hacen falta **dos procesos** (dos terminales o dos Run de IntelliJ).

1. Run `e11.Trabajador`. Se queda esperando.
2. Run `e11.Main`.

Mira las dos consolas. El archivo es `bloque-1/tema-1/ejemplos/11-distribuido-archivo/canal.txt`.
