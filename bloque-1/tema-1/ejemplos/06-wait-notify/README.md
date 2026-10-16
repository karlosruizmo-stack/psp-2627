# 06 · wait / notify

El **bebé** espera a que la comida esté en el plato. El **cocinero** la sirve y avisa.

- Si el plato está vacío → el bebé hace `wait()`.
- Cuando el cocinero sirve → `notify()` despierta a **uno** (el bebé).

## Qué mirar

- `wait` / `notify` siempre dentro de `synchronized`.
- Condición en `while` (no en `if`): el bebé comprueba otra vez al despertar.
- Un solo plato: el cocinero también espera si aún no han vaciado el anterior.
