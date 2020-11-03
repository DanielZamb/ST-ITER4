package uniandes.isis2304.parranderos.negocio;

public class LectorCarnet {

	private long idLector;
	
	private long idEspacio;
	
	private long idVisitante;
	
	private String horaIngreso;
	
	private String horaSalida;
	
	public LectorCarnet()
	{
		this.idLector = 0;
		this.idEspacio = 0;
		this.idVisitante = 0;
		this.horaIngreso = "";
		this.horaSalida = "";	
	}
	
	public LectorCarnet(long lector, long espacio, long visitante, String ingreso, String salida)
	{
		this.idLector = lector;
		this.idEspacio = espacio;
		this.idVisitante = visitante;
		this.horaIngreso = ingreso;
		this.horaSalida = salida;	
	}

	public long getIdLector() {
		return idLector;
	}

	public void setIdLector(long idLector) {
		this.idLector = idLector;
	}

	public long getIdEspacio() {
		return idEspacio;
	}

	public void setIdEspacio(long idEspacio) {
		this.idEspacio = idEspacio;
	}

	public long getIdVisitante() {
		return idVisitante;
	}

	public void setIdVisitante(long idVisitante) {
		this.idVisitante = idVisitante;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	
	
	
}
