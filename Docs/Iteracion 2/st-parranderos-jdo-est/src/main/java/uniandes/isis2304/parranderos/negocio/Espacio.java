package uniandes.isis2304.parranderos.negocio;

public class Espacio implements VOEspacio{
	
	private long id;
	
	private int capacidad_original;
	
	private String hora_apertura;
	
	private String hora_cierre;
	
	private String descripcion;

	private long tipo_lugar;

	public Espacio()
	{
		this.id = 0;
		this.capacidad_original = 0;
		this.hora_apertura = "";
		this.hora_cierre = "";
		this.descripcion = "";
		this.tipo_lugar = 0;
	}
	
	public Espacio (long id, int capacidad, String apertura, String cierre, String descripcion,long tipo_lugar)
	{
		this.id = id;
		this.capacidad_original = capacidad;
		this.hora_apertura = apertura;
		this.hora_cierre = cierre;
		this.descripcion = descripcion;
		this.tipo_lugar = tipo_lugar;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTipo_lugar() {
		return tipo_lugar;
	}

	public void setTipo_lugar(long tipo_lugar) {
		this.tipo_lugar = tipo_lugar;
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
				", capacidad_original=" + capacidad_original +
				", hora_apertura='" + hora_apertura + '\'' +
				", hora_cierre='" + hora_cierre + '\'' +
				", descripcion='" + descripcion + '\'' +
				'}';
	}
}
