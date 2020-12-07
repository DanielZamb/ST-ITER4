package uniandes.isis2304.parranderos.negocio;

public class Visitante implements VOVisitante {

	private long id;

	private String tipo_identificacion;

	private Double temperatura;

	private String nombre;

	private String correo;

	private String telefono;

	private String nombre_contacto;

	private String telefono_contacto;

	private String positivo;

	private String color;

	private long tipo;


	public Visitante(){
		this.id = 0;
		this.tipo_identificacion = "CC";
		this.temperatura = 35.6;
		this.nombre = "Pastor Lopez";
		this.correo = "pastorLopez.ElMaestroLirico@gmail.com";
		this.telefono = "3204204575";
		this.nombre_contacto = "Oscar D'Leon";
		this.telefono_contacto = "3184154375";
		this.positivo = "1";
		this.color = "Rojo";
		this.tipo = 1;

	}
	public Visitante(long id, String tipoId, Double temp, String nombre, String correo, String telefono, String nomC, String telC,String positivo, String color, long tipoV)
	{
		this.id = id;
		this.tipo_identificacion = tipoId;
		this.temperatura = temp;
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

	public String getPositivo() {
		return positivo;
	}

	public void setPositivo(String positivo) {
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

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre_contacto() {
		return nombre_contacto;
	}

	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}

	public String getTelefono_contacto() {
		return telefono_contacto;
	}

	public void setTelefono_contacto(String telefono_contacto) {
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
				", temperatura=" + temperatura +
				", nombre='" + nombre + '\'' +
				", correo='" + correo + '\'' +
				", telefono='" + telefono + '\'' +
				", nombre_contacto='" + nombre_contacto + '\'' +
				", telefono_contacto='" + telefono_contacto + '\'' +
				", positivo=" + positivo +
				", color='" + color + '\'' +
				", tipo=" + tipo +
				'}';
	}
}
