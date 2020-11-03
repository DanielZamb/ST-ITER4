package uniandes.isis2304.parranderos.negocio;

public interface VOLectorCarnet {
    public long getId_lector();
    public long getId_espacio();
    public long getId_visitante();
    public String getHora_ingreso();
    public String getHora_salida();
    @Override
    public String toString();
}
