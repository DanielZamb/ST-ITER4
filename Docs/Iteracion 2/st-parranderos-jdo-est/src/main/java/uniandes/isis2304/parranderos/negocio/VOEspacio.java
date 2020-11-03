package uniandes.isis2304.parranderos.negocio;

public interface VOEspacio {
    public long getId();
    public long getTipo_lugar();
    public int getCapacidad_original();
    public String getHora_apertura();
    public String getHora_cierre();
    public String getDescripcion();
    @Override
    public String toString();
}
