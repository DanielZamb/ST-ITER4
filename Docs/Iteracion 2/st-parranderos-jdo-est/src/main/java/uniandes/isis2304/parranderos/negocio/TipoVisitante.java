package uniandes.isis2304.parranderos.negocio;

public class TipoVisitante implements VOTipoVisitante{
	private long id;
    private String tipo_visitante;
    private String horario;

    public TipoVisitante() {
    	this.id = 0;
        this.tipo_visitante = "";
        this.horario = "";
    }
    public TipoVisitante(long id,String tipo_lugar, String horario) {
    	this.id = id;
        this.tipo_visitante = tipo_lugar;
        this.horario = horario;
    }

    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
