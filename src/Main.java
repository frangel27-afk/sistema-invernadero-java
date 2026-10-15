public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("  SISTEMA DE INVERNADERO INTELIGENTE POO  ");
        System.out.println("==========================================\n");


        Sensor[] sensores = new Sensor[3];
        sensores[0] = new SensorTemperatura("ST-01", "Invernadero A", 32.5);
        sensores[1] = new SensorHumedad("SH-01", "Invernadero A", 55.0);
        sensores[2] = new SensorHumedadSuelo("SHS-01", "Sector Semillero", 18.0);


        System.out.println("--- 1. PROCESAMIENTO POLIMÓRFICO ---");
        for (Sensor sensor : sensores) {
            System.out.println(sensor.evaluarMedicion());
        }


        System.out.println("\n--- 2. USO DE INSTANCEOF Y CASTING ---");
        for (Sensor sensor : sensores) {
            if (sensor instanceof SensorTemperatura) {
                SensorTemperatura tempSensor = (SensorTemperatura) sensor;
                System.out.println("-> Se identificó SensorTemperatura (" + tempSensor.getId() + ")");
                tempSensor.recalibrarUnidad("°F");
            }
        }

        System.out.println("\n--- 3. INTEGRACIÓN CON SISTEMA DE RIEGO ---");
        SistemaRiego riego = new SistemaRiego("SR-MAIN");

        for (Sensor sensor : sensores) {
            if (sensor instanceof SensorHumedadSuelo) {
                SensorHumedadSuelo suelo = (SensorHumedadSuelo) sensor;
                System.out.println("Evaluando lectura de suelo para el riego...");
                riego.evaluarYRegar(suelo);
            }
        }
    }
}