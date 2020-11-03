package uniandes.isis2304.parranderos.negocio;

public class TipoVisitante implements VOTipoVisitante{
    private String tipo_visitante;
    private String horario;

    public TipoVisitante() {
        this.tipo_visitante = "";
        this.horario = "";
    }
    public TipoVisitante(String tipo_lugar, String horario) {
        this.tipo_visitante = tipo_lugar;
        this.horario = horario;
    }

    public String getTipo_visitante() {
        return tipo_visitante;
    }

    public void setTipo_visitante(String tipo_visitante) {
        this.tipo_visitante = tipo_visitante;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "TipoVisitante{" +
                "tipo_lugar='" + tipo_visitante + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }
}
