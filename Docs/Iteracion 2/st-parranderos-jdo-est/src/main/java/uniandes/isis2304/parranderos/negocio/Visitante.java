package uniandes.isis2304.parranderos.negocio;

public class Visitante {
	
	private long id;
	
	private String tipoId;
	
	private String nombre;
	
	private String correo;
	
	private int telefono;
	
	private String nombreContacto;
	
	private int telefonoContacto;
	
	private String tipoVisitante;
	
	public Visitante(long id, String tipoId, String nombre, String correo, int telefono, String nomC, int telC, String tipoV )
	{
		this.id = id;
		this.tipoId = tipoId;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.nombreContacto = nomC;
		this.telefonoContacto = telC;
		this.tipoVisitante = tipoV;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public int getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(int telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getTipoVisitante() {
		return tipoVisitante;
	}

	public void setTipoVisitante(String tipoVisitante) {
		this.tipoVisitante = tipoVisitante;
	}
	
	
	
}
