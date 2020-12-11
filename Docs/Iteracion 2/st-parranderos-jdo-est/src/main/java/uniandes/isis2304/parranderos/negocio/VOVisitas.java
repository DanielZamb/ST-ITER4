package uniandes.isis2304.parranderos.negocio;

import oracle.sql.TIMESTAMP;

public interface VOVisitas {
    public long getId_lector_carnet();
    public long getId_visitante();
    public TIMESTAMP getHora_ingreso();
    public TIMESTAMP getHora_salida();
    @Override
    public String toString();
}
