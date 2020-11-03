package uniandes.isis2304.parranderos.persistencia;

import java.sql.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.AforoActual;
import uniandes.isis2304.parranderos.negocio.Espacio;


public class SQLAforoActual {
	
	private final static String SQL = PersistenciaAforo.SQL;
	
	private PersistenciaAforo pa;
	
	public SQLAforoActual (PersistenciaAforo pa)
	{
		this.pa = pa;
	}
	
	public long adicionarAforoActual (PersistenceManager pm, int numVisitantes, String tipo, double aforoActual, long idEspacio ) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaAforoActual () + "(NUMERO_VISITANTES,TIPO,AFORO_ACTUAL,ID_ESPACIO) values (?, ?, ?, ?)");
        q.setParameters(numVisitantes, tipo, aforoActual, idEspacio);
        return (long) q.executeUnique();
	}
	
	public long eliminarAforoPorId (PersistenceManager pm, long idAforo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaAforoActual () + " WHERE id = ?");
        q.setParameters(idAforo);
        return (long) q.executeUnique();
	}
	
	public AforoActual darAforoPorId (PersistenceManager pm, long idAforo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaAforoActual () + " WHERE id = ?");
		q.setResultClass(AforoActual.class);
		q.setParameters(idAforo);
		return (AforoActual) q.executeUnique();
	}
	
	public List<AforoActual> darAforosActuales (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaAforoActual ());
		q.setResultClass(Espacio.class);
		return (List<AforoActual>) q.executeList();
	}
	

}
