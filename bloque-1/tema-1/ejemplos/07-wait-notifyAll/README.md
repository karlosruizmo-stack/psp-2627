# 07 · wait / notifyAll

Tres **bebés** esperan la comida. Un **cocinero** avisa. Comparad:

1. `notify()` → despierta **solo un** bebé (los otros siguen esperando).
2. `notifyAll()` → despiertan **todos** los bebés.

## Qué mirar

- Misma estructura `synchronized` + `while` + `wait`.
- Cuándo basta `notify` (un solo interesado) y cuándo hace falta `notifyAll` (varios bebés).
