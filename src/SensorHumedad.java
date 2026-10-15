public class SensorHumedad extends Sensor {

    public SensorHumedad(String id, String ubicacion, double ultimaMedicion) {
        super(id, ubicacion, ultimaMedicion);
    }

    @Override
    public String evaluarMedicion() {
        double hum = getUltimaMedicion();
        if (hum < 40.0) {
            return "Humedad Aire [" + hum + "%]: BAJA (Ambiente muy seco)";
        } else if (hum <= 70.0) {
            return "Humedad Aire [" + hum + "%]: ADECUADA";
        } else {
            return "Humedad Aire [" + hum + "%]: ALTA (Riesgo de hongos)";
        }
    }
}