package uniandes.isis2304.parranderos.negocio;

public class Visitas implements VOVisitas{
    private long id_lector_carnet;
    private long id_visitante;
    private String hora_ingreso;
    private String hora_salida;

    public Visitas() {
        this.id_lector_carnet = 0;
        this.id_visitante = 0;
        this.hora_ingreso = "";
        this.hora_salida = "";
    }

    public Visitas(long id_lector_carnet, long id_visitante, String hora_ingreso, String hora_salida) {
        this.id_lector_carnet = id_lector_carnet;
        this.id_visitante = id_visitante;
        this.hora_ingreso = hora_ingreso;
        this.hora_salida = hora_salida;
    }

    public long getId_lector_carnet() {
        return id_lector_carnet;
    }

    public void setId_lector_carnet(long id_lector_carnet) {
        this.id_lector_carnet = id_lector_carnet;
    }

    public long getId_visitante() {
        return id_visitante;
    }

    public void setId_visitante(long id_visitante) {
        this.id_visitante = id_visitante;
    }

    public String getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(String hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    @Override
    public String toString() {
        return "Visitas{" +
                "id_lector_carnet=" + id_lector_carnet +
                ", id_visitante=" + id_visitante +
                ", hora_ingreso='" + hora_ingreso + '\'' +
                ", hora_salida='" + hora_salida + '\'' +
                '}';
    }
}
