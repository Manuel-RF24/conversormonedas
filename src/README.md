# Conversor de Monedas

## Descripción

Este proyecto es un **Conversor de Monedas** desarrollado en Java, que permite realizar conversiones entre diversas monedas utilizando las tasas de cambio obtenidas a través de la **API de ExchangeRate**. El programa permite al usuario ingresar una cantidad en USD y convertirla a monedas como el **Peso Argentino (ARS)**, **Boliviano (BOB)**, **Real Brasileño (BRL)**, **Peso Chileno (CLP)**, **Peso Colombiano (COP)**, entre otras.

## Funcionalidades

- **Consulta de tasas de cambio**: Obtiene las tasas de cambio más recientes desde la API.
- **Conversión de monedas**: Permite al usuario convertir una cantidad de USD a una moneda seleccionada.
- **Interfaz de usuario en consola**: Proporciona un menú interactivo donde el usuario puede elegir la opción de conversión o salir del programa.

## Requisitos

- Java 11 o superior.
- Dependencia de la biblioteca **Gson** para el análisis de la respuesta JSON de la API.

## Instalación

### 1. Clonar el repositorio

```bash
git clone [https://github.com](https://github.com/Manuel-RF24/conversormonedas.git)

```
## Ejemplo de ejecución

Menú de Conversión de Monedas
1. Convertir USD a Moneda
2. Salir
   Seleccione una opción (1 o 2): 1
   Ingrese la cantidad en USD: 100
   Ingrese el código de la moneda de destino (ejemplo: ARS, BOB, BRL, CLP, COP): ARS
   Resultado de la conversión: 100.00 USD = 5000.00 ARS

Menú de Conversión de Monedas
1. Convertir USD a Moneda
2. Salir
   Seleccione una opción (1 o 2): 2
   Gracias por usar el Conversor de Monedas. ¡Hasta pronto!
