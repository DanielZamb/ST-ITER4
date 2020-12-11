package uniandes.isis2304.parranderos.negocio;

import oracle.sql.TIMESTAMP;

public class Visitas implements VOVisitas{
    private long id_lector_carnet;
    private long id_visitante;
    private TIMESTAMP hora_ingreso;
    private TIMESTAMP hora_salida;

    public Visitas() {
        this.id_lector_carnet = 0;
        this.id_visitante = 0;
        this.hora_ingreso = new TIMESTAMP();
        this.hora_salida = new TIMESTAMP();
    }

    public Visitas(long id_lector_carnet, long id_visitante, TIMESTAMP hora_ingreso, TIMESTAMP hora_salida) {
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

    public TIMESTAMP getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(TIMESTAMP hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public TIMESTAMP getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(TIMESTAMP hora_salida) {
        this.hora_salida = hora_salida;
    }

    @Override
    public String toString() {
        return "Visitas{" +
                "id_lector_carnet=" + id_lector_carnet +
                ", id_visitante=" + id_visitante +
                ", hora_ingreso='" + hora_ingreso.toString() + '\'' +
                ", hora_salida='" + hora_salida.toString() + '\'' +
                '}';
    }
}
