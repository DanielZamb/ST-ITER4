package uniandes.isis2304.parranderos.negocio;

public class Visitante {
	
	private long id;
	
	private String tipo_identificacion;
	
	private String nombre;
	
	private String correo;
	
	private int telefono;
	
	private String nombre_contacto;
	
	private int telefono_contacto;
	
	private String tipo;
	
	public Visitante(long id, String tipoId, String nombre, String correo, int telefono, String nomC, int telC, String tipoV )
	{
		this.id = id;
		this.tipo_identificacion = tipoId;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.nombre_contacto = nomC;
		this.telefono_contacto = telC;
		this.tipo = tipoV;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo_identificacion() {
		return tipo_identificacion;
	}

	public void setTipo_identificacion(String tipo_identificacion) {
		this.tipo_identificacion = tipo_identificacion;
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

	public String getNombre_contacto() {
		return nombre_contacto;
	}

	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}

	public int getTelefono_contacto() {
		return telefono_contacto;
	}

	public void setTelefono_contacto(int telefono_contacto) {
		this.telefono_contacto = telefono_contacto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Visitante{" +
				"id=" + id +
				", tipo_identificacion='" + tipo_identificacion + '\'' +
				", nombre='" + nombre + '\'' +
				", correo='" + correo + '\'' +
				", telefono=" + telefono +
				", nombre_contacto='" + nombre_contacto + '\'' +
				", telefono_contacto=" + telefono_contacto +
				", tipo='" + tipo + '\'' +
				'}';
	}
}
