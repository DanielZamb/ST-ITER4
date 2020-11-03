package uniandes.isis2304.parranderos.negocio;

public class Espacio {
	
	private long id;
	
	private int capacidadOriginal;
	
	private String horaApertura;
	
	private String horaCierre;
	
	private String descripcion;
	
	
	
	public Espacio()
	{
		this.id = 0;
		this.capacidadOriginal = 0;
		this.horaApertura = "";
		this.horaCierre = "";
		this.descripcion = "";
		
	}
	
	public Espacio (long id, int capacidad, String apertura, String cierre, String descripcion)
	{
		this.id = id;
		this.capacidadOriginal = capacidad;
		this.horaApertura = apertura;
		this.horaCierre = cierre;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCapacidadOriginal() {
		return capacidadOriginal;
	}

	public void setCapacidadOriginal(int capacidadOriginal) {
		this.capacidadOriginal = capacidadOriginal;
	}

	public String getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(String horaApertura) {
		this.horaApertura = horaApertura;
	}

	public String getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(String horaCierre) {
		this.horaCierre = horaCierre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
