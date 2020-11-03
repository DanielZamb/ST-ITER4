package uniandes.isis2304.parranderos.negocio;

public class AforoActual implements VOAforoActual{
	
	private int numero_visitantes;
	
	private String hora_actual;
		
	private long id_espacio;
	
	public AforoActual()
	{
		this.numero_visitantes = 0;
		this.hora_actual = "";
		this.id_espacio = 0;
	}
	
	public AforoActual(int numVisitantes, String hora, double aforo,long id)
	{
		this.numero_visitantes = numVisitantes;
		this.hora_actual = hora;
		this.id_espacio = id;
	}

	public int getNumero_visitantes() {
		return numero_visitantes;
	}

	public void setNumero_visitantes(int numero_visitantes) {
		this.numero_visitantes = numero_visitantes;
	}

	
	public String getHora_actual() {
		return hora_actual;
	}

	public void setHora_actual(String hora_actual) {
		this.hora_actual = hora_actual;
	}

	public long getId_espacio() {
		return id_espacio;
	}

	public void setId_espacio(long id_espacio) {
		this.id_espacio = id_espacio;
	}

	@Override
	public String toString() {
		return "AforoActual{" +
				"numero_visitantes=" + numero_visitantes +
				", hora_actual='" + hora_actual + '\'' +
				", id_espacio=" + id_espacio +
				'}';
	}
}
