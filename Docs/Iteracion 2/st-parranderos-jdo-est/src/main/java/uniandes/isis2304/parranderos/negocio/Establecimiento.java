package uniandes.isis2304.parranderos.negocio;

public class Establecimiento extends Espacio implements VOEstablecimiento {
    private long id;
    private double area;
    private String nombre;
    private Integer cerrado;
    private String tipo_establecimiento;
    private long id_cc;

    
    public Establecimiento(){
        this.id = 0;
        this.area = 0.0;
        this.nombre = "";
        this.cerrado = 0;
        this.tipo_establecimiento = "CineColombia";
        this.id_cc = 0;
    }
    
    public Establecimiento(long id, long id_cc, double area, String nombre, Integer cerrado, String tipoEst) {
        this.id = id;
        this.area = area;
        this.nombre = nombre;
        this.cerrado = cerrado;
        this.tipo_establecimiento = tipoEst;
        this.id_cc = id_cc;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Integer getCerrado() {
        return cerrado;
    }

    public void setCerrado(Integer cerrado) {
        this.cerrado = cerrado;
    }

    @Override
    public String getTipo_establecimiento() {
        return tipo_establecimiento;
    }

    public void setTipo_establecimiento(String tipo_establecimiento) {
        this.tipo_establecimiento = tipo_establecimiento;
    }

    @Override
    public long getId_cc() {
        return id_cc;
    }

    public void setId_cc(long id_cc) {
        this.id_cc = id_cc;
    }

    @Override
    public String toString() {
        return "Establecimiento{" +
                "id=" + id +
                ", area=" + area +
                ", nombre='" + nombre + '\'' +
                ", cerrado=" + cerrado +
                ", tipo_establecimiento='" + tipo_establecimiento + '\'' +
                ", id_cc=" + id_cc +
                '}';
    }
}
