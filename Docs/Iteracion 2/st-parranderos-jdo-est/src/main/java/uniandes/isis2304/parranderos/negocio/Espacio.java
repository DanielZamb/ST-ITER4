package uniandes.isis2304.parranderos.negocio;

public class Espacio implements VOEspacio{
	
	private long id;
	
	private int capacidad_original;
	
	private String hora_apertura;
	
	private String hora_cierre;
	
	private String descripcion;
	
	
	
	public Espacio()
	{
		this.id = 0;
		this.capacidad_original = 0;
		this.hora_apertura = "";
		this.hora_cierre = "";
		this.descripcion = "";
		
	}
	
	public Espacio (long id, int capacidad, String apertura, String cierre, String descripcion)
	{
		this.id = id;
		this.capacidad_original = capacidad;
		this.hora_apertura = apertura;
		this.hora_cierre = cierre;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCapacidad_original() {
		return capacidad_original;
	}

	public void setCapacidad_original(int capacidad_original) {
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

	@Override
	public String toString() {
		return "Espacio{" +
				"id=" + id +
				", capacidadOriginal=" + capacidad_original +
				", horaApertura='" + hora_apertura + '\'' +
				", horaCierre='" + hora_cierre + '\'' +
				", descripcion='" + descripcion + '\'' +
				'}';
	}
}
