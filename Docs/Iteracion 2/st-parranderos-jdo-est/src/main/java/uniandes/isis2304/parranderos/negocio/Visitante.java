package uniandes.isis2304.parranderos.negocio;

public class Visitante {

	private long id;

	private String tipo_identificacion;

	private String nombre;

	private String correo;

	private int telefono;

	private String nombre_contacto;

	private int telefono_contacto;

	private char positivo;

	private String color;

	private long tipo;



	public Visitante(long id, String tipoId, String nombre, String correo, int telefono, String nomC, int telC,char positivo, String color, long tipoV)
	{
		this.id = id;
		this.tipo_identificacion = tipoId;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.nombre_contacto = nomC;
		this.telefono_contacto = telC;
		this.positivo = positivo;
		this.color = color;
		this.tipo = tipoV;

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getPositivo() {
		return positivo;
	}

	public void setPositivo(char positivo) {
		this.positivo = positivo;
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

	public long getTipo() {
		return tipo;
	}

	public void setTipo(long tipo) {
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
