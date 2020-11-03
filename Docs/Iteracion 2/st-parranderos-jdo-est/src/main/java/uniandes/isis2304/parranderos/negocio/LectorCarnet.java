package uniandes.isis2304.parranderos.negocio;

public class LectorCarnet implements VOLectorCarnet {

	private long id_lector;
	
	private long id_espacio;
	
	private long id_visitante;
	
	private String hora_ingreso;
	
	private String hora_salida;
	
	public LectorCarnet()
	{
		this.id_lector = 0;
		this.id_espacio = 0;
		this.id_visitante = 0;
		this.hora_ingreso = "";
		this.hora_salida = "";
	}
	
	public LectorCarnet(long lector, long espacio, long visitante, String ingreso, String salida)
	{
		this.id_lector = lector;
		this.id_espacio = espacio;
		this.id_visitante = visitante;
		this.hora_ingreso = ingreso;
		this.hora_salida = salida;
	}

	public long getId_lector() {
		return id_lector;
	}

	public void setId_lector(long id_lector) {
		this.id_lector = id_lector;
	}

	public long getId_espacio() {
		return id_espacio;
	}

	public void setId_espacio(long id_espacio) {
		this.id_espacio = id_espacio;
	}

	public long getId_visitante() {
		return id_visitante;
	}

	public void setId_visitante(long id_visitante) {
		this.id_visitante = id_visitante;
	}

	public String getHora_ingreso() {
		return hora_ingreso;
	}

	public void setHora_ingreso(String hora_ingreso) {
		this.hora_ingreso = hora_ingreso;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	@Override
	public String toString() {
		return "LectorCarnet{" +
				"idLector=" + id_lector +
				", idEspacio=" + id_espacio +
				", idVisitante=" + id_visitante +
				", horaIngreso='" + hora_ingreso + '\'' +
				", horaSalida='" + hora_salida + '\'' +
				'}';
	}
}
