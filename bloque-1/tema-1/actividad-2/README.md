# Actividad 2 — "Open Office": tres hilos, tres tareas

- *Fecha límite de entrega*: Domingo 18/10/2026 a las 23:59
- *RA 1*: Desenvolupa aplicacions compostes per diversos processos reconeixent i aplicant principis de programació paral·lela.

## Contexto

En la Actividad 1 todo corría en el hilo `main`, paso a paso. Ahora vas a **crear hilos** y ver cómo se intercalan.

Simularás una oficina con tres trabajadores que hacen su tarea a la vez: imprimir, revisar el correo y hacer backup. Cada uno es un hilo. El `main` los lanza y espera a que terminen antes de cerrar la oficina.

## Objetivo

Implementar un programa Java con **al menos tres hilos** (además de `main`) que trabajen de forma concurrente, usen `sleep` para simular tiempo de trabajo, y acaben de forma ordenada con `join`.

## Elementos a modelar

Como mínimo:

1. **`Impresora`** (o nombre equivalente) — implementa `Runnable` o hereda `Thread`.
   - Imprime varios mensajes (por ejemplo 5 páginas), con `Thread.sleep` entre cada una.
2. **`Correo`**
   - Revisa varios mensajes, con `sleep` entre cada uno.
3. **`Backup`**
   - Copia varios ficheros (simulados por mensajes), con `sleep`.
4. **`Main`**
   - Crea los tres hilos, los arranca con `start()`, espera con `join()` y muestra “oficina cerrada”.

Podéis usar tres clases distintas o una sola clase parametrizada (nombre + mensajes). Lo importante es que haya **tres hilos concurrentes**.

## Requisitos técnicos

- Al menos un hilo creado heredando `Thread` **o** implementando `Runnable` (mejor si practicáis las dos formas, como en los ejemplos de clase).
- Usad `start()`, **nunca** llaméis a `run()` a mano para lanzar el hilo.
- Cada trabajador debe hacer varias iteraciones con `Thread.sleep` (duraciones distintas ayudan a ver el entrelazado).
- `main` debe hacer `join` de los tres y solo entonces imprimir el mensaje final.
- Por consola debe verse claramente el **nombre del hilo** (`Thread.currentThread().getName()` o el que le hayáis puesto).

## Entregable

- Código fuente Java en esta carpeta (`actividad-2/`), organizado en clases.
- Una captura o log de la ejecución donde se vea el entrelazado de mensajes y el cierre de la oficina al final.

## Criterios de evaluación orientativos

| Criterio | Peso |
|---|---|
| Creación correcta de al menos 3 hilos (`start`, no `run`) | 35% |
| Uso de `join` para que `main` espere el final | 25% |
| Uso de `sleep` y salida clara por consola (nombres de hilo) | 20% |
| Calidad del código (clases, nombres, organización) | 20% |

## Pista

Mientras un hilo hace `sleep`, los otros pueden seguir. Si la traza sale “todo de uno y luego todo de otro”, bajad un poco los tiempos de `sleep` o aumentad el número de iteraciones para notar el intercalado.
