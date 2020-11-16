package uniandes.isis2304.parranderos.negocio;

public class Establecimiento extends Espacio implements VOEstablecimiento {
    private long id;
    private long id_cc;
    private double area;
    private String nombre;
    private Short cerrado;
    
    public Establecimiento(){
        this.id = 0;
        this.id_cc = 0;
        this.area = 0.0;
        this.nombre = "";
        this.cerrado = 0;
    }
    
    public Establecimiento(long id, long id_cc, double area, String nombre, Short cerrado) {
        this.id = id;
        this.id_cc = id_cc;
        this.area = area;
        this.nombre = nombre;
        this.cerrado = cerrado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Short getCerrado() {
        return cerrado;
    }

    public void setCerrado(Short cerrado) {
        this.cerrado = cerrado;
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
                ", cerrado=" + cerrado +
                '}';
    }
}
