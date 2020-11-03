package uniandes.isis2304.parranderos.negocio;

public interface VOEstablecimiento {
    public long getId();
    public long getId_cc();
    public Short getCerrado();
    public double getArea();
    public String getNombre();
    @Override
    public String toString();
}
