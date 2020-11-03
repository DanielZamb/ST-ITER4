package uniandes.isis2304.parranderos.negocio;

public interface VOAforoActual {
    public int getNumero_visitantes();
    public String getHora_actual();
    public long getId_espacio();
    @Override
    public String toString();
}
