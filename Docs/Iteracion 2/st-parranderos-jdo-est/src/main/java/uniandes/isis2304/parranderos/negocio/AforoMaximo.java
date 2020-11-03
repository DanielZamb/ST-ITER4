package uniandes.isis2304.parranderos.negocio;

public class AforoMaximo {


	private String tipoEspacio;
	
	private int aforoMaximo;
	
	private long idEspacio;
	
	public String getTipoEspacio() {
		return tipoEspacio;
	}

	public void setTipoEspacio(String tipoEspacio) {
		this.tipoEspacio = tipoEspacio;
	}

	public double getAforoMaximo() {
		return aforoMaximo;
	}

	public void setAforoMaximo(int aforoMaximo) {
		this.aforoMaximo = aforoMaximo;
	}

	public long getIdEspacio() {
		return idEspacio;
	}

	public void setIdEspacio(long idEspacio) {
		this.idEspacio = idEspacio;
	}

	public AforoMaximo()
	{
		
		this.tipoEspacio = "";
		this.aforoMaximo = 0;
		this.idEspacio = 0;
	}
	
	public AforoMaximo( String tipo, int aforo,long id)
	{
		
		this.tipoEspacio = tipo;
		this.aforoMaximo = aforo;
		this.idEspacio = id;
	}
	
	
}
