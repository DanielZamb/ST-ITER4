package uniandes.isis2304.parranderos.persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.*;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.parranderos.negocio.LectorCarnet;
import uniandes.isis2304.parranderos.negocio.Visitas;

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
	
	private SQLVisitante sqlVisitante;

	private SQLTipoVisitante sqlTipoVisitante;
	
	private SQLVisitas sqlVisitas;

	private SQLTipoLugar sqlTipoLugar;
	
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
		tablas.add("VISITANTE");
		tablas.add("VISITAS");
		tablas.add("TIPO_VISITANTE");
		tablas.add("TIPO_LUGAR");
		
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
		sqlVisitante = new SQLVisitante(this);
		sqlVisitas = new SQLVisitas(this);
		sqlTipoVisitante = new SQLTipoVisitante(this);
		sqlTipoLugar = new SQLTipoLugar(this);
	}
	
	public String darSeqAforo() {
		return tablas.get (0);
	}
	
	public String darTablaEspacio() {
		return tablas.get (1);
	}
	
	public String darTablaAforoActual()
	{
		return tablas.get (2);
	}
	
	public String darTablaAforoMaximo()
	{
		return tablas.get (3);
	}
	
	public String darTablaLectorCarnet()
	{
		return tablas.get (4);
	}
	
	public String darTablaCentroComercial()
	{
		return tablas.get (5);
	}
	
	public String darTablaEstablecimiento()
	{
		return tablas.get (6);
	}
	
	public String darTablaVisitante()
	{
		return tablas.get (7);
	}
	
	public String darTablaVisitas()
	{
		return tablas.get(8);
	}

	public String darTablaTipoVisitante()
	{
		return tablas.get (9);
	}

	public String darTablaTipoLugar()
	{
		return tablas.get (10);
	}
	
	
	private long nextval()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	public long [] limpiarAforo ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long [] resp = sqlUtil.limpiarAforo (pm);
			tx.commit ();
			log.info ("Borrada la base de datos");
			return resp;
		}
		catch (Exception e)
		{
//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return new long[] {-1, -1, -1, -1, -1, -1, -1};
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}

	}
	
	public Visitas visitantesAtendidosPorEstablecimiento(long idEstablecimiento, String ingreso, String Salida)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			
			LectorCarnet buscado = sqlLectorCarnet.darLectorPorIdEspacio(pm, idEstablecimiento);
			Visitas resp = sqlVisitas.darVisitasPorIdLector(pm, buscado.getId_lector());
		}
		catch (Exception e)
		{
			
		}
	}
	
	
	
	

	
}
