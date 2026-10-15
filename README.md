
Sistema de Invernadero Inteligente POO

Aplicación de consola desarrollada en Java que representa de manera simplificada un sistema de monitoreo ambiental y control de riego para un invernadero inteligente.

`sensor`: atributos generales como:`id`, `ubicacion`, `ultimaMedicion`.(superclase)

`SensorTemperatura:  Evalúa la temperatura del aire.(Subclase)

`SensorHumedad`: Evalúa el porcentaje de humedad ambiental.(Subclase)

`SensorHumedadSuelo`: Evalúa la humedad de la tierra.(Subclase)

`SistemaRiego`: Modifica su estado (activado/desactivado) segun la humedad del suelo.(colaborador)


1. Abrir el proyecto en **IntelliJ IDEA**.
2. Ubicar el archivo `src/Main.java`.
3. Ejecutar la clase haciendo clic en el botón verde `Run`.

Encapsulación: Palabras como `private` en `Sensor` accedidos mediante getters/setters.

Herencia: Uso de `extends Sensor` en las subclases de sensores.

Super: Invocación de `super(...)` en los constructores de subclases para inicializar el estado base.

Sobrescritura: Uso de `@Override` en el método `evaluarMedicion()`.

Polimorfismo: Almacenamiento de distintas subclases en un arreglo `Sensor[]`.

Enlace dinámico: Decisión en tiempo de ejecución de la implementación de `evaluarMedicion()` a invocar.

-`instanceof` y Casting: Comprobación de tipo real y conversión segura para ejecutar `recalibrarUnidad()`.


Se puede consultar el documento detallado en [docs/01-analisis-diseno.md](docs/01-analisis-diseno.md).

El polimorfismo es una herramienta la cual es de gran ayuda dad que esta nos ayuda a simplificar la programacion haciendo que algo que se podria hacer repetitivo deje de serlo si se usa esta herrramienta tan util ademas de ayudar a relacionar clases que se podria decir que estan separadas esta logra unirlas para hacer su uso y concatenacion de ambas.