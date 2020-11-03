package uniandes.isis2304.parranderos.negocio;

public class AforoActual {
	
	private int numeroVisitantes;
	
	private String horaActual;
		
	private long idEspacio;
	
	public AforoActual()
	{
		this.numeroVisitantes = 0;
		this.horaActual = "";
		this.idEspacio = 0;
	}
	
	public AforoActual(int numVisitantes, String hora, double aforo,long id)
	{
		this.numeroVisitantes = numVisitantes;
		this.horaActual = hora;
		this.idEspacio = id;
	}

	public int getNumeroVisitantes() {
		return numeroVisitantes;
	}

	public void setNumeroVisitantes(int numeroVisitantes) {
		this.numeroVisitantes = numeroVisitantes;
	}

	
	public String getHoraActual() {
		return horaActual;
	}

	public void setHoraActual(String horaActual) {
		this.horaActual = horaActual;
	}

	public long getIdEspacio() {
		return idEspacio;
	}

	public void setIdEspacio(long idEspacio) {
		this.idEspacio = idEspacio;
	}
	
	

}
