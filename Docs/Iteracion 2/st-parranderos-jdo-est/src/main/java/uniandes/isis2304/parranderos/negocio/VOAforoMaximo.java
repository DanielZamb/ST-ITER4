package uniandes.isis2304.parranderos.negocio;

public interface VOAforoMaximo {
    public long getId_espacio();
    public String getTipo_espacio();
    public double getAforo_maximo();
    @Override
    public String toString();
}
