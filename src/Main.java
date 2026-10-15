public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("  SISTEMA DE INVERNADERO INTELIGENTE POO  ");
        System.out.println("==========================================\n");

        // 1. COLECCIÓN DE SENSORES (Tipo de referencia: Sensor)
        Sensor[] sensores = new Sensor[3];
        sensores[0] = new SensorTemperatura("ST-01", "Zona Norte", 32.5);
        sensores[1] = new SensorHumedad("SH-01", "Zona Norte", 55.0);
        sensores[2] = new SensorHumedadSuelo("SHS-01", "Sector Semillero", 22.0);

        // 2. PROCESAMIENTO POLIMÓRFICO
        System.out.println("--- Evaluando mediciones de forma polimórfica ---");
        for (Sensor sensor : sensores) {
            // Java invoca el evaluarMedicion() correspondiente al tipo real del objeto
            System.out.println(sensor.evaluarMedicion());
        }
    }
}