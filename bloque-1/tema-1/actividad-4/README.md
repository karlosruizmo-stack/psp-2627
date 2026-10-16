# Actividad 4 — "Timbre del recreo": wait, notify y notifyAll

- *Fecha límite de entrega*: Domingo 18/10/2026 a las 23:59
- *RA 1*: Desenvolupa aplicacions compostes per diversos processos reconeixent i aplicant principis de programació paral·lela.

## Contexto

A veces un hilo no solo necesita un Lock: necesita **esperar una condición** (“aún no”) y que otro le diga **“ya está”**.

- `wait()`: suelta el monitor y se queda en la cola.
- `notify()`: despierta a **uno**.
- `notifyAll()`: despierta a **todos**.

No confundáis con `sleep`: el reloj no despierta a quien está en `wait`; hace falta la señal.

## Objetivo

Simular el **recreo**: varios alumnos esperan el timbre; un portero lo toca. Comparar qué pasa con `notify` frente a `notifyAll`.

## Elementos a modelar

Como mínimo:

1. **`Recreo`** (o `Timbre`) — objeto monitor compartido.
   - Condición tipo `boolean sonando` (o similar).
   - Método `esperarTimbre(String alumno)`: mientras no suene, `wait()`.
   - Método `tocarConNotify()`: pone la condición a true y hace `notify()`.
   - Método `tocarConNotifyAll()`: pone la condición a true y hace `notifyAll()`.
2. **`Alumno`** (implementa `Runnable`)
   - Llama a `esperarTimbre` y, al despertar, imprime que sale al recreo.
3. **`Portero`** (implementa `Runnable`, opcional pero recomendable)
   - Tras un pequeño `sleep` (simula que llega al timbre), llama a `tocarConNotify` o `tocarConNotifyAll`.
4. **`Main`**
   - Dos demos (pueden ser dos métodos o dos ejecuciones documentadas):
     1. **3 alumnos** + portero con **`notify`** → solo **uno** debería salir al recreo de inmediato.
     2. **3 alumnos** + portero con **`notifyAll`** → **los tres** salen.

## Requisitos técnicos

- `wait` / `notify` / `notifyAll` **siempre** dentro de un bloque o método `synchronized` sobre el mismo objeto.
- La espera debe ir en un **`while`** (no solo `if`) comprobando la condición.
- En el demo de `notify`, los alumnos que no despierten no pueden quedarse colgando el programa para siempre: tras mostrar que solo despertó uno, podéis hacer una limpieza con `notifyAll` (como en el ejemplo de clase) y documentarlo en un comentario.
- Por consola debe quedar claro cuántos alumnos despertaron en cada demo.

## Entregable

- Código fuente Java en esta carpeta (`actividad-4/`).
- Captura o log de las dos demos (`notify` vs `notifyAll`) con la traza de alumnos y del portero.

## Criterios de evaluación orientativos

| Criterio | Peso |
|---|---|
| Uso correcto de `synchronized` + `while` + `wait` | 30% |
| Demo `notify`: solo un alumno despierta | 25% |
| Demo `notifyAll`: despiertan los tres | 25% |
| Claridad de la traza y calidad del código | 20% |

## Pista

`sleep` no sustituye a `wait`. Si el portero solo hace `sleep` y nadie llama a `notify`/`notifyAll`, los alumnos se quedan esperando aunque pase el tiempo.
