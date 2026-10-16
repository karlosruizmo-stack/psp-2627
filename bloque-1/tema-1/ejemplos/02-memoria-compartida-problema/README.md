# 02 · Memoria compartida — el problema

Dos hilos ven las mismas variables. Barato. Y peligroso.

## Idea

Dos hilos incrementan el **mismo** `Contador` 100_000 veces cada uno.

- Esperado: **200_000**
- Sin Lock: el resultado suele ser **menor** (condiciones de carrera)

`incrementar()` hace leer → sumar → escribir. Si A y B leen el mismo valor a la vez, uno de los dos `+1` se pierde.

Ejecutadlo varias veces: el número cambia. Eso es el bug.

## Siguiente

`03-memoria-compartida-solucion` — el mismo código con `synchronized`.
