package uniandes.isis2304.parranderos.negocio;

public interface VOVisitas {
    public long getId_lector_carnet();
    public long getId_visitante();
    public String getHora_ingreso();
    public String getHora_salida();
    @Override
    public String toString();
}
