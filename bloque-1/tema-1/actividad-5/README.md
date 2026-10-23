# Actividad 5 — "Pedidos del almacén": secuencial y paralelo

- *Fecha límite de entrega*: Viernes 6/11/2026 a las 23:59
- *RA 1*: Desenvolupa aplicacions compostes per diversos processos reconeixent i aplicant principis de programació paral·lela.

## Contexto

Un almacén tiene que preparar **800 pedidos**. Cada pedido es igual, no depende de otro y tarda **25 ms** (`Thread.sleep`). Preparar un pedido aporta **1**.

El mismo trabajo se hace dos veces: primero todo seguido, después partido en trozos que caben a la vez.

## Objetivo

Entregar **dos programas** en el package `actividad5`:

1. **`Secuencial`** — solo el hilo `main`. Prepara los 800 pedidos uno detrás de otro y guarda cada 1.
2. **`Paralelo`** — **8 hilos**. Cada hilo prepara **100 pedidos** de un tramo que no se pisa con los demás:
   - hilo 1: pedidos 1 a 100
   - hilo 2: 101 a 200
   - hilo 3: 201 a 300
   - hilo 4: 301 a 400
   - hilo 5: 401 a 500
   - hilo 6: 501 a 600
   - hilo 7: 601 a 700
   - hilo 8: 701 a 800

En los dos, el resultado final tiene que ser **800**.

## Requisitos técnicos

- Cada pedido espera 25 ms y devuelve 1. El número de pedido solo sirve para saber qué tramo es.
- En el paralelo, cada hilo escribe **solo en su tramo** (un array suyo). Los trozos no se solapan y entre todos cubren del 1 al 800.
- No hace falta sincronizar el cálculo: los pedidos son independientes y ningún hilo incrementa un contador compartido.
- `main` arranca los hilos con `start()` y espera con `join()`. **Después del join**, `main` copia los tramos, guarda el resultado de todas las tareas e imprime el total.
- En el secuencial es el propio `main` quien guarda cada resultado.
- Los dos programas imprimen el total. Tiene que salir **800**.
- El secuencial tarda unos **20 s** (800 × 25 ms). El paralelo, unos **2,5 s** (100 × 25 ms). Si el paralelo tarda casi lo mismo que el secuencial, los hilos no están trabajando a la vez.

## Entregable

- `Secuencial` y `Paralelo` en `actividad-5/actividad5/` (package `actividad5`). Junto al enunciado.
- Un log de cada programa con el total **800** y el tiempo.

## Criterios de evaluación orientativos

| Criterio | Peso |
|---|---|
| Los dos programas acaban en **800** | 30% |
| 8 hilos y tramos disjuntos (1–100 … 701–800), sin pisarse | 25% |
| El cálculo no usa un contador compartido: no hace falta sincronizarlo | 20% |
| `main` guarda los resultados después del `join` e imprime el total | 15% |
| El paralelo tarda mucho menos que el secuencial | 10% |

## Pista

Si todos los hilos hacen `contador++` sobre la misma variable, eso ya no es “trozos independientes”: es el problema de la memoria compartida. Aquí cada hilo solo rellena su array. Quien junta el total es `main`, cuando los demás ya han terminado.
