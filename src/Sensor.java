public class Sensor {
    private String id;
    private String ubicacion;
    private boolean activo;
    private double ultimaMedicion;

    public Sensor(String id, String ubicacion, double ultimaMedicion) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.activo = true;
        this.ultimaMedicion = ultimaMedicion;
    }

    public String getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getUltimaMedicion() {
        return ultimaMedicion;
    }

    public void actualizarMedicion(double nuevaMedicion) {
        this.ultimaMedicion = nuevaMedicion;
    }

    public String evaluarMedicion() {
        return "Sensor general [" + id + "]: Última lectura = " + ultimaMedicion;
    }
}
