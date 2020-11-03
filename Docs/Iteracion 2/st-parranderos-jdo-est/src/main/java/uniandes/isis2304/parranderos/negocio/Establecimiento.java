package uniandes.isis2304.parranderos.negocio;

public class Establecimiento extends Espacio implements VOEstablecimiento {
    private long id;
    private long id_cc;
    private double area;
    private String nombre;

    public Establecimiento(){
        this.id = 0;
        this.id_cc = 0;
        this.area = 0.0;
        this.nombre = "";
    }
    public Establecimiento(long id, long id_cc, double area, String nombre) {
        this.id = id;
        this.id_cc = id_cc;
        this.area = area;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_cc() {
        return id_cc;
    }

    public void setId_cc(long id_cc) {
        this.id_cc = id_cc;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Establecimiento{" +
                "id=" + id +
                ", id_cc=" + id_cc +
                ", area=" + area +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
