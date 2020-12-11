package uniandes.isis2304.parranderos.negocio;

import oracle.sql.TIMESTAMP;

public interface VOCvisitas_VIEW {
    public Long getVisitante_id();
    public String getTipo_identificacion();
    public Double getTemperatura();
    public String getCorreo();
    public String getTelefono();
    public String getNombre_contacto();
    public String getTelefono_contacto();
    public String getPositivo();
    public String getVisitante_color();
    public Integer getTipo();
    public Long getId_lector_carnet();
    public Long getId_visitante();
    public TIMESTAMP getHora_ingreso();
    public TIMESTAMP getHora_salida();
    public Long getEspacio_id();
    public Integer getCapacidad_original();
    public String getHora_apertura();
    public String getHora_cierre();
    public String getDescripcion();
    public String getEspacio_color();
    public Long getTipo_lugar_id();
    public String getTipo_lugar();
    public String getCons_aforo();
    public Long getEstablecimiento_id();
    public Double getArea();
    public String getEstablecimiento_nombre();
    public String getCerrado();
    public String getTipo_establecimiento();
    public Long getId_cc();
    public String toString();
}
