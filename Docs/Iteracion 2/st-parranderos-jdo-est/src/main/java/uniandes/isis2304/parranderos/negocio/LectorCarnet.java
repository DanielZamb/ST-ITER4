package uniandes.isis2304.parranderos.negocio;

public class LectorCarnet implements VOLectorCarnet {

	private long id_lector;
	
	private long id_espacio;
	
	public LectorCarnet()
	{
		this.id_lector = 0;
		this.id_espacio = 0;
	}
	
	public LectorCarnet(long lector, long espacio)
	{
		this.id_lector = lector;
		this.id_espacio = espacio;
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

	@Override
	public String toString() {
		return "LectorCarnet{" +
				"idLector=" + id_lector +
				", idEspacio=" + id_espacio +
				'}';
	}
}
