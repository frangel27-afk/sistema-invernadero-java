public class SensorHumedadSuelo extends Sensor {

    public SensorHumedadSuelo(String id, String ubicacion, double ultimaMedicion) {
        super(id, ubicacion, ultimaMedicion);
    }

    public boolean requiereRiego() {
        return getUltimaMedicion() < 30.0;
    }

    @Override
    public String evaluarMedicion() {
        double humSuelo = getUltimaMedicion();
        if (humSuelo < 30.0) {
            return "Humedad Suelo [" + humSuelo + "%]: SUELO SECO (Requiere riego urgente)";
        } else if (humSuelo <= 60.0) {
            return "Humedad Suelo [" + humSuelo + "%]: SUELO HÚMEDO (Condición idónea)";
        } else {
            return "Humedad Suelo [" + humSuelo + "%]: SUELO SATURADO (Exceso de agua)";
        }
    }
}