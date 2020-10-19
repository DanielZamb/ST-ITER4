package uniandes.isis2304.parranderos.persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PersistenciaAforo {

	private static Logger log = Logger.getLogger(PersistenciaAforo.class.getName());
	
	public final static String SQL = "javax.jdo.query.SQL";
	
	private static PersistenciaAforo instance;
	
	private PersistenceManagerFactory pmf;
	
	private List <String> tablas;
	
	private SQLUtil sqlUtil;
	
	private SQLEspacio sqlEspacio;
	
	private SQLAforoActual sqlAforoActual;
	
	private SQLAforoMaximo sqlAforoMaximo;
	
	private SQLLectorCarnet sqlLectorCarnet;
	
	private SQLCentroComercial sqlCentroComercial;
	
	private SQLEstablecimiento sqlEstablecimiento;
	
	private SQLParqueadero sqlParqueadero;
	
	private SQLAscensor sqlAscensor;
	
	private SQLPasillo sqlPasillo;
	
	private SQLBaño sqlBaño;
	
	private SQLVisitante sqlVisitante;
	
	private SQLEmpleado sqlEmpleado;
	
	private SQLCliente sqlCliente;
	
	private SQLDomiciliario sqlDomiciliario;
	
	
	public PersistenciaAforo()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("Aforo");		
		crearClasesSQL ();
		
		tablas = new LinkedList<String> ();
		tablas.add("aforo_sequence");
		tablas.add("ESPACIO");
		tablas.add("AFOROACTUAL");
		tablas.add("AFOROMAXIMO");
		tablas.add("LECTORCARNET");
		tablas.add("CENTROCOMERCIAL");
		tablas.add("ESTABLECIMIENTO");
		tablas.add("PARQUEADERO");
		tablas.add("ASCENSOR");
		tablas.add("PASILLO");
		tablas.add("BAÑO");
		tablas.add("VISITANTE");
		tablas.add("EMPLEADO");
		tablas.add("CLIENTE");
		tablas.add("DOMICILIARIO");
		
	}
	
	private PersistenciaAforo (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}
	
	public static PersistenciaAforo getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaAforo ();
		}
		return instance;
	}
	
	public static PersistenciaAforo getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaAforo (tableConfig);
		}
		return instance;
	}
	
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	private void crearClasesSQL()
	{
		sqlEspacio = new SQLEspacio(this);
		sqlAforoActual = new SQLAforoActual(this);
		sqlAforoMaximo = new SQLAforoMaximo(this);
		sqlLectorCarnet = new SQLLectorCarnet(this);
		sqlCentroComercial = new SQLCentroComercial(this);
		sqlEstablecimiento = new SQLEstablecimiento(this);
		sqlParqueadero = new SQLParqueadero(this);
		sqlAscensor = new SQLAscensor(this);
		sqlPasillo = new SQLPasillo(this);
		sqlBaño = new SQLBaño(this);
		sqlVisitante = new SQLVisitante(this);
		sqlEmpleado = new SQLEmpleado(this);
		sqlCliente = new SQLCliente(this);
		sqlDomiciliario = new SQLDomiciliario(this);
		
		
	}
	
}
