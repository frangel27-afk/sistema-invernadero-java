public class SistemaRiego {
    private String id;
    private boolean encendido;

    public SistemaRiego(String id) {
        this.id = id;
        this.encendido = false;
    }

    public void activarRiego() {
        this.encendido = true;
        System.out.println(">> Sistema de Riego [" + id + "]: ACTIVADO (Regando cultivo...)");
    }

    public void desactivarRiego() {
        this.encendido = false;
        System.out.println(">> Sistema de Riego [" + id + "]: DESACTIVADO (Riego detenido)");
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void evaluarYRegar(SensorHumedadSuelo sensorSuelo) {
        System.out.println("\n--- Evaluación del Sistema de Riego ---");
        if (sensorSuelo.requiereRiego()) {
            System.out.println("Alerta: Humedad del suelo (" + sensorSuelo.getUltimaMedicion() + "%) es insuficiente.");
            activarRiego();
        } else {
            System.out.println("Estado: Humedad del suelo (" + sensorSuelo.getUltimaMedicion() + "%) es adecuada.");
            desactivarRiego();
        }
    }
}