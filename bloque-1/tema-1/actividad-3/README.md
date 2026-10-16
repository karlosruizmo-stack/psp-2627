# Actividad 3 — "Aforo de la sala": memoria compartida y sincronización

- *Fecha límite de entrega*: Domingo 18/10/2026 a las 23:59
- *RA 1*: Desenvolupa aplicacions compostes per diversos processos reconeixent i aplicant principis de programació paral·lela.

## Contexto

Varios hilos pueden **pisar la misma variable** a la vez. Sin protección, el resultado es incorrecto (condición de carrera). Con un Lock o `synchronized`, solo un hilo actualiza a la vez.

Vas a simular el **aforo** de una sala: varias personas entran muchas veces y todas suman al mismo contador.

## Objetivo

1. Reproducir el problema: varios hilos incrementan un contador compartido **sin** sincronización → el total suele ser menor del esperado.
2. Corregirlo con **exclusión mutua** (`synchronized` **o** `ReentrantLock`) → el total es siempre el correcto.

## Elementos a modelar

Como mínimo:

1. **`Aforo`** (o `Contador`)
   - Variable compartida (por ejemplo `int entradas`).
   - Método `entrar()` que suma 1.
   - Método `getTotal()`.
2. **`Visitante`** (implementa `Runnable`)
   - Recibe el `Aforo` compartido.
   - En `run()`, llama a `entrar()` un número fijo de veces (p. ej. 1000).
3. **`Main`**
   - Crea **4** visitantes (hilos) sobre el mismo `Aforo`.
   - Cada uno hace 1000 entradas → total esperado: **4000**.
   - Arranca, hace `join`, imprime el total.

## Requisitos técnicos

- Entregad **dos versiones** (pueden ser dos paquetes, dos carpetas o un flag en `main` bien documentado):
  1. **Sin sincronización** — para demostrar el fallo.
  2. **Con sincronización** — `synchronized` en el método/bloque crítico **o** `ReentrantLock` con `lock` / `unlock` en `finally`.
- En la versión correcta, el total debe ser **siempre 4000** (ejecutad varias veces).
- No hace falta `wait`/`notify` en esta actividad: solo exclusión mutua.

## Entregable

- Código fuente Java en esta carpeta (`actividad-3/`).
- Capturas o logs: al menos una ejecución **incorrecta** (sin sync) y una **correcta** (con sync), con el total impreso.

## Criterios de evaluación orientativos

| Criterio | Peso |
|---|---|
| Demostración clara del problema sin sincronización | 25% |
| Solución correcta con `synchronized` o `Lock` (total = 4000) | 40% |
| Varios hilos + `join` + contador compartido bien modelado | 20% |
| Calidad del código | 15% |

## Pista

El incremento `entradas++` no es atómico: leer + sumar + escribir. Dos hilos pueden leer el mismo valor y pisarse. La sección crítica es exactamente ese incremento (y, si usáis Lock, no olvidéis el `unlock` en `finally`).
