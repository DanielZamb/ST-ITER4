package uniandes.isis2304.parranderos.negocio;

import oracle.sql.TIMESTAMP;

import java.util.Map;

public class Cvisitas_VIEW implements VOCvisitas_VIEW {
    private Long visitante_id;
    private String tipo_identificacion;
    private Double temperatura;
    private String correo;
    private String telefono;
    private String nombre_contacto;
    private String telefono_contacto;
    private String positivo;
    private String visitante_color;
    private Integer tipo;
    private Long id_lector_carnet;
    private Long id_visitante;
    private TIMESTAMP hora_ingreso;
    private TIMESTAMP hora_salida;
    private Long espacio_id;
    private Integer capacidad_original;
    private String hora_apertura;
    private String hora_cierre;
    private String descripcion;
    private String espacio_color;
    private Long tipo_lugar_id;
    private String tipo_lugar;
    private String cons_aforo;
    private Long establecimiento_id;
    private Double area;
    private String establecimiento_nombre;
    private String cerrado;
    private String tipo_establecimiento;
    private Long id_cc;

    /*public Cvisitas_VIEW() {
        this.visitante_id = Long.valueOf("12312312312312312312");
        this.tipo_identificacion = "TI";
        this.temperatura = 36.5;
        this.correo = "correo";
        this.telefono = "23423040243";
        this.nombre_contacto = "nombre_contacto";
        this.telefono_contacto = "telefono_contacto";
        this.positivo = "positivo";
        this.visitante_color = "visitante_color";
        this.tipo = 1;
        this.id_lector_carnet = Long.valueOf("12311231");
        this.id_visitante = Long.valueOf("123123123");
        this.hora_ingreso = new TIMESTAMP();
        this.hora_salida = new TIMESTAMP();
        this.espacio_id = Long.valueOf("123123120");
        this.capacidad_original = 456;
        this.hora_apertura = "hora_apertura";
        this.hora_cierre = "hora_cierre";
        this.descripcion = "descripcion";
        this.espacio_color = "espacio_color";
        this.tipo_lugar_id = Long.valueOf("123123123");
        this.tipo_lugar = "tipo_lugar";
        this.cons_aforo = "cons_aforo";
        this.establecimiento_id = Long.valueOf("13123123123123");
        this.area = 200.3;
        this.establecimiento_nombre = "establecimiento_nombre";
        this.cerrado = "cerrado";
        this.tipo_establecimiento = "tipo_establecimiento";
        this.id_cc = Long.valueOf("1231231231");
    }/*

    /*public Cvisitas_VIEW(Long visitante_id, String tipo_identificacion, Double temperatura, String correo, String telefono, String nombre_contacto, String telefono_contacto, String positivo, String visitante_color, Integer tipo, Long id_lector_carnet, Long id_visitante, TIMESTAMP hora_ingreso, TIMESTAMP hora_salida, Long espacio_id, Integer capacidad_original, String hora_apertura, String hora_cierre, String descripcion, String espacio_color, Long tipo_lugar_id, String tipo_lugar, String cons_aforo, Long establecimiento_id, Double area, String establecimiento_nombre, String cerrado, String tipo_establecimiento, Long id_cc) {
        this.visitante_id = visitante_id;
        this.tipo_identificacion = tipo_identificacion;
        this.temperatura = temperatura;
        this.correo = correo;
        this.telefono = telefono;
        this.nombre_contacto = nombre_contacto;
        this.telefono_contacto = telefono_contacto;
        this.positivo = positivo;
        this.visitante_color = visitante_color;
        this.tipo = tipo;
        this.id_lector_carnet = id_lector_carnet;
        this.id_visitante = id_visitante;
        this.hora_ingreso = hora_ingreso;
        this.hora_salida = hora_salida;
        this.espacio_id = espacio_id;
        this.capacidad_original = capacidad_original;
        this.hora_apertura = hora_apertura;
        this.hora_cierre = hora_cierre;
        this.descripcion = descripcion;
        this.espacio_color = espacio_color;
        this.tipo_lugar_id = tipo_lugar_id;
        this.tipo_lugar = tipo_lugar;
        this.cons_aforo = cons_aforo;
        this.establecimiento_id = establecimiento_id;
        this.area = area;
        this.establecimiento_nombre = establecimiento_nombre;
        this.cerrado = cerrado;
        this.tipo_establecimiento = tipo_establecimiento;
        this.id_cc = id_cc;
    }*/

    public Long getVisitante_id() {
        return visitante_id;
    }

    public void setVisitante_id(Long visitante_id) {
        this.visitante_id = visitante_id;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public String getPositivo() {
        return positivo;
    }

    public void setPositivo(String positivo) {
        this.positivo = positivo;
    }

    public String getVisitante_color() {
        return visitante_color;
    }

    public void setVisitante_color(String visitante_color) {
        this.visitante_color = visitante_color;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Long getId_lector_carnet() {
        return id_lector_carnet;
    }

    public void setId_lector_carnet(Long id_lector_carnet) {
        this.id_lector_carnet = id_lector_carnet;
    }

    public Long getId_visitante() {
        return id_visitante;
    }

    public void setId_visitante(Long id_visitante) {
        this.id_visitante = id_visitante;
    }

    public TIMESTAMP getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(TIMESTAMP hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public TIMESTAMP getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(TIMESTAMP hora_salida) {
        this.hora_salida = hora_salida;
    }

    public Long getEspacio_id() {
        return espacio_id;
    }

    public void setEspacio_id(Long espacio_id) {
        this.espacio_id = espacio_id;
    }

    public Integer getCapacidad_original() {
        return capacidad_original;
    }

    public void setCapacidad_original(Integer capacidad_original) {
        this.capacidad_original = capacidad_original;
    }

    public String getHora_apertura() {
        return hora_apertura;
    }

    public void setHora_apertura(String hora_apertura) {
        this.hora_apertura = hora_apertura;
    }

    public String getHora_cierre() {
        return hora_cierre;
    }

    public void setHora_cierre(String hora_cierre) {
        this.hora_cierre = hora_cierre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEspacio_color() {
        return espacio_color;
    }

    public void setEspacio_color(String espacio_color) {
        this.espacio_color = espacio_color;
    }

    public Long getTipo_lugar_id() {
        return tipo_lugar_id;
    }

    public void setTipo_lugar_id(Long tipo_lugar_id) {
        this.tipo_lugar_id = tipo_lugar_id;
    }

    public String getTipo_lugar() {
        return tipo_lugar;
    }

    public void setTipo_lugar(String tipo_lugar) {
        this.tipo_lugar = tipo_lugar;
    }

    public String getCons_aforo() {
        return cons_aforo;
    }

    public void setCons_aforo(String cons_aforo) {
        this.cons_aforo = cons_aforo;
    }

    public Long getEstablecimiento_id() {
        return establecimiento_id;
    }

    public void setEstablecimiento_id(Long establecimiento_id) {
        this.establecimiento_id = establecimiento_id;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getEstablecimiento_nombre() {
        return establecimiento_nombre;
    }

    public void setEstablecimiento_nombre(String establecimiento_nombre) {
        this.establecimiento_nombre = establecimiento_nombre;
    }

    public String getCerrado() {
        return cerrado;
    }

    public void setCerrado(String cerrado) {
        this.cerrado = cerrado;
    }

    public String getTipo_establecimiento() {
        return tipo_establecimiento;
    }

    public void setTipo_establecimiento(String tipo_establecimiento) {
        this.tipo_establecimiento = tipo_establecimiento;
    }

    public Long getId_cc() {
        return id_cc;
    }

    public void setId_cc(Long id_cc) {
        this.id_cc = id_cc;
    }

    @Override
    public String toString() {
        return "Cvisitas_VIEW{" +
                "visitante_id=" + visitante_id +
                ", tipo_identificacion='" + tipo_identificacion + '\'' +
                ", temperatura=" + temperatura +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nombre_contacto='" + nombre_contacto + '\'' +
                ", telefono_contacto='" + telefono_contacto + '\'' +
                ", positivo='" + positivo + '\'' +
                ", visitante_color='" + visitante_color + '\'' +
                ", tipo=" + tipo +
                ", id_lector_carnet=" + id_lector_carnet +
                ", id_visitante=" + id_visitante +
                ", hora_ingreso=" + hora_ingreso +
                ", hora_salida=" + hora_salida +
                ", espacio_id=" + espacio_id +
                ", capacidad_original=" + capacidad_original +
                ", hora_apertura='" + hora_apertura + '\'' +
                ", hora_cierre='" + hora_cierre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", espacio_color='" + espacio_color + '\'' +
                ", tipo_lugar_id=" + tipo_lugar_id +
                ", tipo_lugar='" + tipo_lugar + '\'' +
                ", cons_aforo='" + cons_aforo + '\'' +
                ", establecimiento_id=" + establecimiento_id +
                ", area=" + area +
                ", establecimiento_nombre='" + establecimiento_nombre + '\'' +
                ", cerrado='" + cerrado + '\'' +
                ", tipo_establecimiento='" + tipo_establecimiento + '\'' +
                ", id_cc=" + id_cc +
                '}';
    }
    public String toStringVariable() {
        StringBuilder s = new StringBuilder();
        s.append("Cvisitas_VIEW{");
        if (visitante_id!=null) s.append("visitante_id=" + visitante_id);
        if (tipo_identificacion!=null) s.append(", tipo_identificacion=\'").append(tipo_identificacion).append("\'");
        if (temperatura!=null) s.append(", temperatura=").append(temperatura);;
        if (correo!=null) s.append(", correo='").append(correo).append("\'");
        if(telefono!=null) s.append(", telefono='").append(telefono).append("\'");
        if(nombre_contacto!=null) s.append(", nombre_contacto='").append(nombre_contacto).append("\'");
        if(telefono_contacto!=null) s.append(", telefono_contacto='").append(telefono_contacto).append("\'");
        if(positivo!=null) s.append(", positivo='").append(positivo).append("\'");
        if(visitante_color!=null) s.append(", visitante_color='").append(visitante_color).append("\'");
        if(tipo!=null) s.append(", tipo=").append(tipo);
        if(id_lector_carnet!=null)s.append(", id_lector_carnet=").append(id_lector_carnet);
        if(id_visitante!=null)s.append(", id_visitante=").append(id_visitante);
        if(hora_ingreso!=null)s.append(", hora_ingreso=").append(hora_ingreso);
        if(hora_salida!=null)s.append(", hora_salida=").append(hora_salida);
        if(espacio_id!=null)s.append(", espacio_id=").append(espacio_id);
        if(capacidad_original!=null)s.append(", capacidad_original=").append(capacidad_original);
        if(hora_apertura!=null)s.append(", hora_apertura='").append(hora_apertura).append("\'");
        if(hora_cierre!=null)s.append(", hora_cierre='").append(hora_cierre).append("\'");
        if(descripcion!=null)s.append(", descripcion='").append(descripcion).append("\'");
        if(espacio_color!=null)s.append(", espacio_color='").append(espacio_color).append("\'");
        if(tipo_lugar_id!=null)s.append(", tipo_lugar_id=").append(tipo_lugar_id);
        if(tipo_lugar!=null)s.append(", tipo_lugar=").append(tipo_lugar).append("\'");
        if(cons_aforo!=null)s.append(", cons_aforo='").append(cons_aforo).append("\'");
        if(establecimiento_id!=null)s.append(", establecimiento_id=").append(establecimiento_id);
        if(area!=null)s.append(", area=").append(area);
        if(establecimiento_nombre!=null)s.append(", establecimiento_nombre='").append(establecimiento_nombre).append("\'");
        if(cerrado!=null)s.append(", cerrado='").append(cerrado).append("\'");
        if(tipo_establecimiento!=null)s.append(", tipo_establecimiento='").append(tipo_establecimiento).append("\'");
        if(id_cc!=null)s.append(", id_cc=").append(id_cc);
        s.append('}');
        return s.toString();
    }
}
