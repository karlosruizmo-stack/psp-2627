# 05 · Tres hilos · orden arbitrario

Parecido al ejemplo 03 (`synchronized`), pero con **tres hilos** y trazas visibles.

Enlaza con las diapos de secuencia: el Lock garantiza el resultado; **quién entra primero lo decide el planificador**.

## Qué mirar

- Cada hilo espera un tiempo **aleatorio** (50–800 ms) y luego pide el Lock.
- Imprime `acquire` → `update` → `release`.
- Al final, `contador` es siempre **3**.
- Ejecutad **varias veces**: el orden (p. ej. 3 → 1 → 2 vs 1 → 2 → 3) cambia.
