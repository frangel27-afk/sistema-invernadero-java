public class SensorTemperatura extends Sensor {
    private String unidadMedida;

    public SensorTemperatura(String id, String ubicacion, double ultimaMedicion) {
        super(id, ubicacion, ultimaMedicion);
        this.unidadMedida = "°C";
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    // Comportamiento específico
    public void recalibrarUnidad(String nuevaUnidad) {
        this.unidadMedida = nuevaUnidad;
        System.out.println("Sensor [" + getId() + "] recalibrado a unidad: " + nuevaUnidad);
    }

    @Override
    public String evaluarMedicion() {
        double temp = getUltimaMedicion();
        if (temp < 15.0) {
            return "Temperatura [" + temp + unidadMedida + "]: CRÍTICA BAJA (Riesgo de helada)";
        } else if (temp <= 28.0) {
            return "Temperatura [" + temp + unidadMedida + "]: ÓPTIMA";
        } else {
            return "Temperatura [" + temp + unidadMedida + "]: CRÍTICA ALTA (Requiere ventilación)";
        }
    }
}