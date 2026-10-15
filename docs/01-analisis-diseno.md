# Análisis y diseño
## 1. Descripción del problema
Se representara un sistema de monitoreo y control automatizado para un invernadero inteligente, el objetivo principal es supervisar en tiempo real las condiciones ambientales del cultivo y responder activamente para mantener un entorno óptimo para el desarrollo de las plantas.

## 2. Identificación de objetos

1- sensor de temperatura: es un componente que se encarga de captar la temperatura ambiental, y es de vital importancia  para saber si el ambiente es adecuado para las plantas.

2- sensores de humedad ambiental y de suelo: los debemos de usar dado que se requiere saber si la humedad en el invernadero es adecuada y favorecedora para las plantas, y estos mediran la humedad en el ambiente y en el suelo. 


3- sistema de riego: estara presente para cser el actuador del sensor de humedad, es el que se encargara de humedecer o mojar el suelo.


## 3. Estado y comportamiento
Los sensores compartiran un identificador único (id), una ubicación física en el invernadero (ubicación), estaran en un estado de funcionamiento (activo/inactivo) y una lectura analogica registrada (última medición).

## 4. Características comunes y especialización

Todos estos sensores nos permitiran tener lectura, ver estados, y evaluar rangos.estos solo daran dos tipos de medidas, en grados celcius y en porcentajes, todos los llamaremos sensor pero cada uno tendra su variable y su tipo de variable.

## 5. Relaciones entre objetos

El SistemaRiego va a colaborar directamente con SensorHumedadSuelo para obtener la lectura del sustrato y decidir si debe activarse ya que dependen de si. El SistemaRiego requiere la ultima medicion del SensorHumedadSuelo para verificar si la humedad está por debajo del límite permitido, y asi realizar comparaciones para saber si debe o no debe de comenzar el riego.


| Clase | Atributos propuestos | Tipo de dato | Métodos propuestos | Responsabilidad |
| :--- | :--- | :--- | :--- | :--- |
| `Sensor` | `id`<br>`ubicacion`<br>`activo`<br>`ultimaMedicion` | `String`<br>`String`<br>`boolean`<br>`double` | `getId()`<br>`getUbicacion()`<br>`isActivo()`<br>`getUltimaMedicion()`<br>`actualizarMedicion(double)`<br>`evaluarMedicion()` | Servir como superclase base para almacenar el estado y comportamiento común de cualquier sensor del invernadero. |
| `SensorTemperatura` | `unidadMedida` | `String` | `getUnidadMedida()`<br>`evaluarMedicion()`<br>`recalibrarUnidad(String)` | Especialización para interpretar la temperatura del aire (°C). |
| `SensorHumedad` | `rangoOptimoMin`<br>`rangoOptimoMax` | `double`<br>`double` | `evaluarMedicion()` | Especialización para evaluar el porcentaje de humedad en el aire. |
| `SensorHumedadSuelo` | `nivelCriticoSecado` | `double` | `evaluarMedicion()`<br>`requiereRiego()` | Especialización para evaluar la humedad de la tierra y determinar la necesidad de riego. |
| `SistemaRiego` | `id`<br>`encendido`<br>`caudalLitrosPorMinuto` | `String`<br>`boolean`<br>`double` | `activarRiego()`<br>`desactivarRiego()`<br>`isEncendido()`<br>`evaluarYRegar(SensorHumedadSuelo)` | Actuador que controla la activación/desactivación del flujo de agua. |

## Diagrama UML inicial
![Diagrama UML inicial](uml-inicial.png)

Porque representan de forma modular los componentes fisicos esenciales del sistema de monitoreo y control del invernadero.

El `Sensor` gestiona datos base de medición las subclases interpretan según la variable física `SistemaRiego` ejecuta la acción de riego.

Garantizar el principio de encapsulación y así evitar la modificación directa o inconsistente del estado de los objetos desde clases externas.

Los  datos de identificación inicial (`id`, `ubicación`) configurando limites específicos y la primera medición.

La  super clase se llama `Sensor`.

Las subclases tienen el nombre de:  `SensorTemperatura`, `SensorHumedad`, `SensorHumedadSuelo`.

Proponemos  este porque un `SensorTemperatura` “es un” tipo específico de `Sensor` que comparte operaciones con otros sensores.

Loa atributos y comportamientos son: `id`, `ubicacion`, `activo`, `ultimaMedicion` y los métodos comunes.

La lógica particular de interpretación de `evaluarMedicion()` tendrá  los rangos de tolerancia y métodos específicos como lo es  `recalibrarUnidad()`.

Porque no mide variables, es decir este no es un sensor si no que es un actuador que ejecuta acciones.

Todo el manejo de identificadores y estado de lecturas se abstrajo en la clase base `Sensor`.


No,  los constructores no se heredan almenos no en java.

Orimero se ejecuta el constructor de la superclase y posteriormente el de la subclase.

Se utiliza para delegar a la superclase `Sensor` la inicialización de los atributos comunes (`id`, `ubicacion`, `ultimaMedicion`).

## @Override

Sobreescribi el método `evaluarMedicion()`.

Nos indica que el compilador que se esta reemplazando la implementación de un método de la superclase.

Porque nos permite invocar la misma operación en cualquier tipo de sensor de una manera uniforme.

Este metodo nos permite aplicar el polimorfismo haciendo que el código maestro trate a todos los objetos bajo el tipo común `Sensor`.



| Tipo de referencia | Tipo real del objeto  | Método que se ejecuta |
| :--- |:----------------------| :--- |
| `Sensor` | `SensorTemperatura`   | `SensorTemperatura.evaluarMedicion()` |
| `Sensor` | `SensorHumedad`       | `SensorHumedad.evaluarMedicion()` |
| `Sensor` | `SensorHumedadSuelo`  | `SensorHumedadSuelo.evaluarMedicion()` |



Porque existe una relación de herencia entre `SensorTemperatura` y `Sensor`.

No lo puede hace directo ya que requiere un casting para hacer una comprobación porque no todo `Sensor` es de temperatura.


Se ejecuta la versión correspondiente al  objeto instanciado en el tiempo de ejecución.

Lo hace mediante un enlace dinámico, consultando la tabla de métodos virtuales del objeto en tiempo real.

Se puede observar en el bucle (for) porue este produce comportamientos distintos segun sea el objeto.

Lo podemos observar en el momento que se ejecuta el programa.


El casting fue necesario porque la referencia `Sensor` no da acceso a métodos específicos definidos solamente en las subclases.

Nos ayuda a verificar si el objeto referenciado es una instancia real  o de sus subclases.

sucede una excepción en el tiempo de ejecución `ClassCastException`.

Pues basicamente porque nos acopla el código a tipos concretos y rompe la extensibilidad ademas de que viola el principio .


Porque la referencia del `Sensor` no posee los métodos específicos en las subclases.

Nos ayuda a verifica el tiempo en que se ejecuta y si el objeto apuntado esta en una instancia real de una clase determinada.

El programa interrumpirá la ejecución.

Porque nos obligaría a escribir cadenas de if/else cada vez que se agregue una nueva subclaseteniendo que hacer mas trabajo y perdiendo la simplicidad del polimorfismo.

El `SistemaRiego` no se considera como sensor pero se utiliza información de `SensorHumedadSuelo`-


| Caso de prueba | Escenario / Entrada | Resultado esperado | Resultado obtenido |
| :--- | :--- | :--- | :--- |
| Crear sensores | Instanciar subclases | Conservan su estado inicial | Conservado correctamente |
| Evaluar Temperatura | Lectura de 32.5 °C | Notifica "CRÍTICA ALTA" | Cumplido |
| Evaluar Humedad Aire | Lectura de 55.0% | Notifica "ADECUADA" | Cumplido |
| Evaluar Humedad Suelo| Lectura de 18.0% | Notifica "SUELO SECO" | Cumplido |
| Arreglo de referencias `Sensor`| Matriz `Sensor[]` | Permite almacenar subclases | Almacenado correctamente |
| Recorrer colección | Bucle `for` invocando `evaluarMedicion()` | Llama al método de cada subclase | Enlace dinámico verificado |
| Comprobar con `instanceof`| `sensor instanceof SensorTemperatura` | Retorna `true` solo para temperatura | Identificación correcta |
| Realizar Casting | `(SensorTemperatura) sensor` | Permite llamar `recalibrarUnidad()` | Ejecutado sin errores |
| Humedad Suelo baja | Lectura de 18% (<30%) | Activa el sistema de riego | Riego ACTIVADO |

## Cambios realizados al diseño
Se elimino en el diagrama SistemaRiego() y se dejaron los métodos activarRiego(), desactivarRiego() e isEncendido() para reflejar con precisión el cumplimiento de la encapsulación y el control manual del estado del actuador.

## Diagrama UML final
![Diagrama UML final](uml-final.png)




## Reflexión final

¿Cuál es la superclase de tu sistema y cuáles son sus subclases?
La super clase es: Sensor. Y las subclases son: SensorTemperatura, SensorHumedad y SensorHumedadSuelo.

¿Por qué existe una relación de herencia entre ellas?
Existe porque los tres tipos de sensores comparten atributos y comportamientos comunes.

¿Qué atributos o comportamientos decidiste colocar en la superclase y por qué?
Coloqué los atributos id, ubicacion, activo y ultimaMedicion y el método base evaluarMedicion(). Los ubique ahí para no duplicar código en las subclases porque todos los sensores del invernadero requiere identificarse y almacenar sus lecturas.


¿Para qué utilizaste super?
Utilicé super para: id, ubicacion, ultimaMedicion.

¿Qué método sobrescribiste?
Sobrescribi el método evaluarMedicion() en las tres subclases utilizando la anotacion @Override.

¿Dónde puedes observar polimorfismo en tu programa?
Se observa en Main.java en el bucle for (Sensor sensor : sensores).

¿Dónde puedes observar enlace dinámico?
Se observa dentro del bucle al ejecutar sensor.evaluarMedicion().

¿Para qué utilizaste instanceof y casting?
Utilicé instanceof para verificar de una forma segura si algun objeto de Sensor era en realidad un de SensorTemperatura o un SensorHumedadSuelo. El casting (SensorTemperatura) sensor me permitió convertir la referencia para llamar a métodos específicos no declarados en la superclase, como recalibrarUnidad().

¿Qué cambio realizaste entre tu UML inicial y tu UML final?
Elimine el SistemaRiego().

Si tuvieras que agregar un SensorLuminosidad, ¿qué partes del programa tendrías que modificar?
tendia que crear una nueva clase para el SensorLuminosidad, y posteriormente agregar o codificar su parte en el main.java.

