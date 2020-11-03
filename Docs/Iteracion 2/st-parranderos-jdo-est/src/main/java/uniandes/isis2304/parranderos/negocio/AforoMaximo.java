package uniandes.isis2304.parranderos.negocio;

public class AforoMaximo implements VOAforoMaximo{
	private String tipo_espacio;
	
	private int aforo_maximo;
	
	private long id_espacio;
	public AforoMaximo()
	{
		
		this.tipo_espacio = "";
		this.aforo_maximo = 0;
		this.id_espacio = 0;
	}
	
	public AforoMaximo( String tipo, int aforo,long id)
	{
		this.tipo_espacio = tipo;
		this.aforo_maximo = aforo;
		this.id_espacio = id;
	}
	public String getTipo_espacio() {
		return tipo_espacio;
	}

	public void setTipo_espacio(String tipo_espacio) {
		this.tipo_espacio = tipo_espacio;
	}

	public double getAforo_maximo() {
		return aforo_maximo;
	}

	public void setAforo_maximo(int aforo_maximo) {
		this.aforo_maximo = aforo_maximo;
	}

	public long getId_espacio() {
		return id_espacio;
	}

	public void setId_espacio(long id_espacio) {
		this.id_espacio = id_espacio;
	}

	@Override
	public String toString() {
		return "AforoMaximo{" +
				"tipo_espacio='" + tipo_espacio + '\'' +
				", aforo_maximo=" + aforo_maximo +
				", id_espacio=" + id_espacio +
				'}';
	}
}
