# 01 · Crear hilos

## Idea

Un proceso Java arranca con un solo hilo: el del `main`. Si hace falta más trabajo a la vez, **él crea** el resto y llama a `start()`.

Simulamos un editor de texto con tres hilos, como en el diagrama de la diapo 17:

1. **Teclado / UI** — hereda de `Thread` (opción A)
2. **Ortografía** — implementa `Runnable` (opción B, la habitual)
3. **Autoguardado** — también `Runnable`

## Qué mirar en la salida

- El nombre del hilo (`Thread.currentThread().getName()`).
- Que `main` lanza los tres con `start()` y luego espera con `join()` → **main es el último en morir**.
- Que las tareas se intercalan (no salen siempre en el mismo orden).
