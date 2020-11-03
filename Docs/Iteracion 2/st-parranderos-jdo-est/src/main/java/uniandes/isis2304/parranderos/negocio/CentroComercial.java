package uniandes.isis2304.parranderos.negocio;

public class CentroComercial extends Espacio implements VOCentroComercial{
	
	private long id;
	
	private String ciudad;
	
	private String direccion;
	
	public CentroComercial()
	{
		this.id =  0;
		this.ciudad = "";
		this.direccion = "";
			
	}
	
	public CentroComercial(long id, String ciudad, String direccion)
	{
		this.id = id;
		this.ciudad = ciudad;
		this.direccion = direccion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "CentroComercial{" +
				"id=" + id +
				", ciudad='" + ciudad + '\'' +
				", direccion='" + direccion + '\'' +
				'}';
	}
}
