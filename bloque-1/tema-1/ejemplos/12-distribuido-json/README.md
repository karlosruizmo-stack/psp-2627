# 12 · Distribuido con JSON

Igual que el 11: dos procesos. No comparten memoria. Se hablan por `canal.txt`.

La diferencia: el archivo no lleva una frase suelta. Lleva **un objeto JSON**. `Canal` pasa el mensaje a texto y, al leer, lo vuelve a convertir en mensaje. `Main` y `Trabajador` no parsean el String: llaman a `Canal.enviar` y `Canal.recibir`.

## Mensajes

`canal.txt` contiene exactamente uno de estos objetos (una línea, sin espacios):

| Momento | JSON |
|---|---|
| Orden | `{"tipo":"ejecuta","tarea":1}` |
| Trabajando | `{"tipo":"trabajando","tarea":1}` |
| Respuesta | `{"tipo":"completa","tarea":1,"resultado":1}` |
| Cierre | `{"tipo":"fin"}` |

`tarea` y `resultado` son números. El resultado de la tarea N es N×N. Con 5 tareas, main guarda 1, 4, 9, 16 y 25.

## Qué mirar

- `Trabajador` espera. No hace nada hasta que llega `ejecuta`.
- Escribe `trabajando`, espera 5 s y luego escribe `completa`.
- `Main` lee esa respuesta, **guarda el resultado** y también espera 5 s antes de la siguiente. Así cinco veces. Luego escribe `fin`.
- Son 5 tareas, no 1.000: solo para ver el intercambio.

## Cómo ejecutarlo

Hacen falta **dos procesos** (dos terminales o dos Run de IntelliJ).

1. Run `e12.Trabajador`. Se queda esperando.
2. Run `e12.Main`.

Si el trabajador se cierra al momento, borra `canal.txt`: se quedó en `fin` de la vez anterior.

Mira las dos consolas. El archivo es `bloque-1/tema-1/ejemplos/12-distribuido-json/canal.txt`.
