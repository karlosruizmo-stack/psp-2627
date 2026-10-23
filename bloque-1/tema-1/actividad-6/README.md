# Actividad 6 — "El taller": dos procesos y JSON

- *Fecha límite de entrega*: Viernes 6/11/2026 a las 23:59
- *RA 1*: Desenvolupa aplicacions compostes per diversos processos reconeixent i aplicant principis de programació paral·lela.

## Contexto

El ejemplo 12 ya enseña dos procesos que no comparten memoria y se hablan por `canal.txt`. El archivo lleva **un objeto JSON**. El `Canal` es quien lo convierte a texto y lo vuelve a leer.

En el taller el trabajo es otro: no son 5 cuadrados. Son **8 encargos**. El resultado del encargo N es **N × 3**.

## Código de partida

En `actividad6/` ya están `Canal` y `Mensaje`. No están `Main` ni `Trabajador`: los escribes tú.

El `Canal` escribe en `bloque-1/tema-1/actividad-6/canal.txt`.

## Objetivo

Dos procesos:

1. **`Main`** manda el trabajo. No calcula los encargos: envía la orden, espera la respuesta y **guarda** el resultado.
2. **`Trabajador`** es el otro proceso. Espera la orden, avisa de que está trabajando, calcula y deja la respuesta.

Hacen falta los dos a la vez (dos terminales o dos Run). Primero el trabajador, luego main.

## Mensajes

El formato es el del ejemplo 12. El archivo contiene exactamente uno de estos objetos:

| Momento | JSON |
|---|---|
| Orden | `{"tipo":"ejecuta","tarea":1}` |
| Trabajando | `{"tipo":"trabajando","tarea":1}` |
| Respuesta | `{"tipo":"completa","tarea":1,"resultado":1}` |
| Cierre | `{"tipo":"fin"}` |

`tarea` y `resultado` son números. Las claves son esas y no otras. En el ejemplo, la tarea 1 responde `"resultado":1` porque allí el trabajo es el cuadrado. Aquí el mismo campo vale N × 3, así que el encargo 1 se contesta `{"tipo":"completa","tarea":1,"resultado":3}`.

## Qué tiene que pasar

Para N desde 1 hasta **8**:

1. `Main` envía `ejecuta` de esa tarea.
2. `Trabajador` lo lee, imprime que está trabajando y envía `trabajando`.
3. Espera `Canal.ANTES_DE_CONTESTAR_MS` (5 s), calcula **N × 3** y envía `completa` con ese resultado.
4. `Main` guarda el resultado. Espera otros 5 s antes del siguiente encargo.
5. Después del octavo, `Main` envía `fin` y el trabajador cierra.

`Main` imprime los 8 resultados y la suma. Tienen que salir estos números:

| Tarea | Resultado |
|---|---|
| 1 | 3 |
| 2 | 6 |
| 3 | 9 |
| 4 | 12 |
| 5 | 15 |
| 6 | 18 |
| 7 | 21 |
| 8 | 24 |
| **Suma** | **108** |

No cambiéis la pausa de 5 s: así se puede abrir `canal.txt` y leer el mensaje.

## Requisitos técnicos

- Sin memoria compartida. Solo el archivo.
- `Main` y `Trabajador` no parsean el JSON a mano: llaman a `Canal.enviar` y `Canal.recibir`.
- El resultado que viaja es N × 3, no el cuadrado del ejemplo.

## Entregable

- Entregad `Main` y `Trabajador` en `actividad-6/actividad6/` (package `actividad6`), junto al enunciado. Sin carpeta `/solución`.
- Podéis incluir el `Canal`. El `Canal` es el que entiende el JSON (no lo reimplementéis ni cambiéis el formato). `Mensaje` va con él.
- Un log de las dos consolas donde se vean los 8 resultados y la suma **108**.

## Criterios de evaluación orientativos

| Criterio | Peso |
|---|---|
| Usan el `Canal` y no cambian el formato JSON | 25% |
| El trabajador envía `trabajando` y luego `completa` con N × 3 | 25% |
| `Main` guarda los 8 resultados y la suma es **108** | 30% |
| Son dos procesos, y `fin` cierra al trabajador | 10% |
| Se mantiene la pausa de 5 s y la traza se entiende | 10% |

## Pista

Mirad el ejemplo 12 para ver el ida y vuelta. Si copiáis sus 5 tareas y el cuadrado, la suma sale 55 y no vale: aquí son 8 encargos y cada uno vale el triple de su número. El canal y los cuatro mensajes se quedan igual.
