package uniandes.isis2304.parranderos.persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.*;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.parranderos.negocio.AforoActual;
import uniandes.isis2304.parranderos.negocio.AforoMaximo;
import uniandes.isis2304.parranderos.negocio.CentroComercial;
import uniandes.isis2304.parranderos.negocio.Espacio;
import uniandes.isis2304.parranderos.negocio.Establecimiento;
import uniandes.isis2304.parranderos.negocio.LectorCarnet;
import uniandes.isis2304.parranderos.negocio.Visitante;
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
		pmf = JDOHelper.getPersistenceManagerFactory("Parranderos");
		crearClasesSQL ();
		
		tablas = new LinkedList<String> ();
		tablas.add("AFORO_SEQUENCE");
		tablas.add("A_ESPACIO");
		tablas.add("A_AFORO_ACTUAL");
		tablas.add("A_AFORO_MAXIMO");
		tablas.add("A_LECTOR_CARNET");
		tablas.add("A_CENTRO_COMERCIAL");
		tablas.add("A_ESTABLECIMIENTO");
		tablas.add("A_VISITANTE");
		tablas.add("A_TIPO_VISITANTE");
		tablas.add("A_VISITAS");
		tablas.add("A_TIPO_LUGAR");
			
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
		sqlTipoVisitante = new SQLTipoVisitante(this);
		sqlVisitas = new SQLVisitas(this);
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
	
	public String darTablaTipoVisitante()
	{
		return tablas.get (8);
	}
	
	public String darTablaVisitas()
	{
		return tablas.get(9);
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
	public List<Visitante> darVisitantes(){
		PersistenceManager pm =  pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Visitante> rta = new ArrayList<>();
		try{
			tx.begin();
			rta = sqlVisitante.darVisitantes(pm);
		}
		catch (Exception e){
			if(tx.isActive())
				tx.rollback();
			pm.close();
		}
		return rta;
	}
	
	public List<Visitas> darVisitas(){
		PersistenceManager pm =  pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Visitas> rta = new ArrayList<>();
		try{
			tx.begin();
			rta = sqlVisitas.darTodasLasVisitas(pm);
		}
		catch (Exception e){
			if(tx.isActive())
				tx.rollback();
			pm.close();
		}
		return rta;
	}
	
	public List<LectorCarnet> darLectores(){
		PersistenceManager pm =  pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<LectorCarnet> rta = new ArrayList<>();
		try{
			tx.begin();
			rta = sqlLectorCarnet.darLectores(pm);
		}
		catch (Exception e){
			if(tx.isActive())
				tx.rollback();
			pm.close();
		}
		return rta;
	}
	
	public List<AforoActual> darAforoAct(){
		PersistenceManager pm =  pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<AforoActual> rta = new ArrayList<>();
		try{
			tx.begin();
			rta = sqlAforoActual.darAforosActuales(pm);
		}
		catch (Exception e){
			if(tx.isActive())
				tx.rollback();
			pm.close();
		}
		return rta;
	}
	
	public List<AforoMaximo> darAforoMax(){
		PersistenceManager pm =  pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<AforoMaximo> rta = new ArrayList<>();
		try{
			tx.begin();
			rta = sqlAforoMaximo.darAforosMaximos(pm);
		}
		catch (Exception e){
			if(tx.isActive())
				tx.rollback();
			pm.close();
		}
		return rta;
	}
	
	public List<Espacio> darEspacio(){
		PersistenceManager pm =  pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Espacio> rta = new ArrayList<>();
		try{
			tx.begin();
			rta = sqlEspacio.darEspacios(pm);
		}
		catch (Exception e){
			if(tx.isActive())
				tx.rollback();
			pm.close();
		}
		return rta;
	}
	
	public List<Establecimiento> darEstablecimiento(){
		PersistenceManager pm =  pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Establecimiento> rta = new ArrayList<>();
		try{
			tx.begin();
			rta = sqlEstablecimiento.darEstablecimientos(pm);
		}
		catch (Exception e){
			if(tx.isActive())
				tx.rollback();
			pm.close();
		}
		return rta;
	}
	
	

	public double mostrarIndiceAforoCC(long idEspacio)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		double indice = 0;
		
		try
		{
			tx.begin();
			
			int actual = sqlAforoActual.darAforoActual(pm, idEspacio);
			int maximo = sqlAforoMaximo.darAforoMaximo(pm, idEspacio);
			
			indice = (actual/maximo);		
		}
		catch(Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return indice;
	}
	//--------------------------------------------------//
	//----- CONSULTAS ITERACION 3 ----------------------//
	//--------------------------------------------------//
	public List<Visitante> visitantesAtendidosPorEstablecimiento(long idEstablecimiento, String inStart, String inEnd)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		List<Visitante> visitantes= new ArrayList();

		try
		{
			tx.begin();

			long buscado = sqlLectorCarnet.darIdLectorPorIdEspacio(pm, idEstablecimiento);
			List<Long> resp = sqlVisitas.darIdVisitanteVisitasRangoTiempoLectorCarnet(pm, buscado, inStart, inEnd);
			for (Long e : resp)
			{
				visitantes.add(sqlVisitante.darVisitantePorId(pm, e));
			}


		}
		catch (Exception e)
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
			e.printStackTrace();
		}

		return visitantes;
	}
	// formato DD/MM/HHHH HH24:MM:SS
	public List<Visitante> visitantesQueEstuvieronEnElMismoLugarQue (Long idVisitante, String inEnd){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Visitante> visitantes = new ArrayList();
		try{
			tx.begin();
			String[] fechaHora = inEnd.split(" ");
			String[] fecha = fechaHora[0].split("/");
			Calendar c = Calendar.getInstance();
			c.set(Integer.parseInt(fecha[2]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[0]));
			c.add(Calendar.DATE,-10);
			String inStart = c.get(Calendar.DATE) + "/" + c.get(Calendar.MONTH)+ "/" + c.get(Calendar.YEAR) +" "+ fechaHora[1];
			List<Visitas> list = sqlVisitas.darVisitasRangoTiempoIdVisitante(pm,idVisitante,inStart,inEnd);
			List<Long> ids = new ArrayList<>();
			for (Visitas v: list) {
				ids.addAll(sqlVisitas.darIdVisitanteVisitasRangoTiempoLectorCarnet(pm,v.getId_lector_carnet(),v.getHora_ingreso(),v.getHora_salida()));
			}
			for (Long idV: ids){
				visitantes.add(sqlVisitante.darVisitantePorId(pm,idV));
			}
		}catch(Exception e){
			if (tx.isActive())
				tx.rollback();
			pm.close();
			e.printStackTrace();
		}
		return visitantes;
	}

	public List<Visitante> ClientesFrecuentesEstablecimiento(Long idEstablecimiento){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Visitante> visitantes = new ArrayList();
		try{
			tx.begin();
			List<Visitas> visitasList = sqlVisitas.darVisitasClientesEsablecimientoPorIdEspacio(pm,idEstablecimiento);
			List<Long> visitantesId = new ArrayList<>();
			List<Long> lectoresId = new ArrayList<>();
			Long idRef = visitasList.get(0).getId_visitante();
			Long lector = visitasList.get(0).getId_lector_carnet();
			int cont = 0;
			for(Visitas v : visitasList) {
				if (idRef == v.getId_visitante()) cont++;
				else {
					if (cont >= 3) {
						visitantesId.add(idRef);
						lectoresId.add(lector);
					}
					else cont = 0;
					idRef = v.getId_visitante();
					lector = v.getId_lector_carnet();
				}
			}
			for (int i=0;i<visitantesId.size();i++) {
				List<Visitas> visitasAlMismoLocal = sqlVisitas.darVisitaPorIdVisitanteIdLector(pm,visitantesId.get(i),lectoresId.get(i));
				String fechaHora[] = visitasAlMismoLocal.get(0).getHora_ingreso().split(" ");
				String mes = fechaHora[0].split("/")[1];
				int cont2 = 0;
				for (Visitas v : visitasAlMismoLocal ){
					if (mes == v.getHora_ingreso().split(" ")[0].split("/")[1]) cont++;
					else {
						if (cont>=3){
							visitantes.add(sqlVisitante.darVisitantePorId(pm,v.getId_visitante()));
						}
						else cont = 0;
						mes = v.getHora_ingreso().split(" ")[0].split("/")[1];
					}
				}
			}
		}catch (Exception e){
			if (tx.isActive())
				tx.rollback();
			pm.close();
			e.printStackTrace();
		}
		return visitantes;
	}
	public List<Long> espaciosVisitadosPorPositivo(String factual)
	{
		PersistenceManager pm = pmf.getPersistenceManager();

		String[] fechaHora = factual.split(" ");
		String[] fecha = fechaHora[0].split("/");
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(fecha[2]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[0]));
		c.add(Calendar.DATE,-2);
		String inStart = c.get(Calendar.DATE) + "/" + c.get(Calendar.MONTH)+ "/" + c.get(Calendar.YEAR) +" "+ fechaHora[1];

		String sql1 = "SELECT a_lector_carnet.id_espacio FROM"+darTablaVisitante()+","+darTablaVisitas()+","+darTablaLectorCarnet();
		String sql2 = sql1+"WHERE a_visitante.positivo = 1 AND a_visitante.id = a_visitas.id_visitante AND a_visitas.id_lector_carnet = a_lector_carnet.id AND hora_ingreso AND (hora_ingreso > TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) AND (hora_salida < TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')";

		Query q = pm.newQuery(SQL, sql2);
		q.setResultClass(Long.class);
		q.setParameters(inStart,factual);

		return (List<Long>) q.executeList();
	}

	public void cambiarEspacioARojo(String fecha_actual)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		String color = "Rojo";
		for(Long e: espaciosVisitadosPorPositivo(fecha_actual))
		{
			sqlEspacio.cambiarColor(pm, e, color);
		}
	}

	public void deshabilitarEstablecimiento(String tipoEstablecimiento){
		PersistenceManager pm = pmf.getPersistenceManager();
		List<Long> list = sqlEstablecimiento.darEstablecimientoEspacioPorIdTipo(pm,tipoEstablecimiento);
		for(Long e: list){
			sqlEstablecimiento.cerrarEstablecimiento(pm,e,tipoEstablecimiento);
			sqlEspacio.cambiarColor(pm,e,"Rojo");
		}
	}

	public void rehabilitarEstablecimiento(String tipoEstablecimiento){
		PersistenceManager pm = pmf.getPersistenceManager();
		List<Long> list = sqlEstablecimiento.darEstablecimientoEspacioPorIdTipo(pm,tipoEstablecimiento);
		for(Long e: list){
			sqlEstablecimiento.rehabilitarEstablecimiento(pm,e,tipoEstablecimiento);
			sqlEspacio.cambiarColor(pm,e,"Verde");
		}
	}
}
