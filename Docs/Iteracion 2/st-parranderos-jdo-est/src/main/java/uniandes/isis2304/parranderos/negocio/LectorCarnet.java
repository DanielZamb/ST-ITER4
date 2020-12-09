package uniandes.isis2304.parranderos.negocio;

public class LectorCarnet implements VOLectorCarnet {

	private long id;
	
	private long id_espacio;
	
	public LectorCarnet()
	{
		this.id = 0;
		this.id_espacio = 0;
	}
	
	public LectorCarnet(long id, long espacio)
	{
		this.id = id;
		this.id_espacio = espacio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_espacio() {
		return id_espacio;
	}

	public void setId_espacio(long id_espacio) {
		this.id_espacio = id_espacio;
	}

	@Override
	public String toString() {
		return "LectorCarnet{" +
				"id=" + id +
				", id_espacio=" + id_espacio +
				'}';
	}
}
