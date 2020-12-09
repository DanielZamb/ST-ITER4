package uniandes.isis2304.parranderos.negocio;

public interface VOEstablecimiento {
    public long getId();
    public double getArea();
    public String getNombre();
    public Integer getCerrado();
    public String getTipo_establecimiento();
    public long getId_cc();

    @Override
    public String toString();
}
