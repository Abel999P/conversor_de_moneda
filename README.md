## Primeros pasos

Bienvenido a la guía del convertidor de divisas. En este documento, aprenderá a crear y utilizar una aplicación de conversión de divisas sencilla.

## Estructura de carpetas

El espacio de trabajo debe contener la siguiente estructura:

- `src`: esta carpeta contendrá el código fuente del convertidor de divisas.
- `lib`: aquí se colocarán todas las bibliotecas externas necesarias para las API o utilidades de conversión de divisas.

Los archivos de salida (código compilado) se generarán en la carpeta `bin` de forma predeterminada.

> Si desea personalizar la estructura de carpetas, puede abrir `.vscode/settings.json` y actualizar la configuración relacionada en consecuencia.

## Creación de un convertidor de divisas

En este proyecto, crearemos un convertidor de divisas sencillo basado en Java que convierte una cantidad de una divisa a otra utilizando tipos de cambio predefinidos o mediante la integración de API en tiempo real.

### Pasos para implementar

1. **Definir las monedas**: Deberá definir las monedas entre las que desea convertir, como USD, EUR, GBP, etc.
2. **Configurar los tipos de cambio**: Utilice valores estáticos o integre con una API para obtener los tipos de cambio más recientes.
3. **Entrada del usuario**: El convertidor debe permitir al usuario ingresar el monto que desea convertir y seleccionar las monedas de origen y destino.
4. **Realizar la conversión**: Según la entrada y los tipos de cambio, calcule el monto convertido.
5. **Mostrar los resultados**: Muestre al usuario el monto convertido final.
