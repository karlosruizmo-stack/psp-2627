# 09 · sleep

Tres alarmas hacen `Thread.sleep` con tiempos distintos. Cada una **se despierta sola**.

## Qué mirar

- `sleep` ≠ `wait`: no hace falta `notify` para continuar.
- Mientras un hilo duerme, **otros** pueden seguir (incluido `main`).
- `sleep` no libera un Lock si lo tenías: solo pausa el hilo.
