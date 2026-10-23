# 08 · Deadlock

Dos hilos, dos Locks, **orden distinto**:

- Hilo 1: acquire A → pide B
- Hilo 2: acquire B → pide A

Nadie hace release. El programa se queda colgado.

## Qué mirar

- La traza se para en “intenta acquire…”.
- En IntelliJ: Stop para salir.
- Prevención típica: **mismo orden** de acquire en todos los hilos.
