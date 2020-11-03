package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.LectorCarnet;

public class SQLLectorCarnet {
	
	private final static String SQL = PersistenciaAforo.SQL;
	
	private PersistenciaAforo pa;
	
	public SQLLectorCarnet (PersistenciaAforo pa)
	{
		this.pa = pa;
	}
	
	public long adicionarLector (PersistenceManager pm, long idLector, long idEspacio)
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaLectorCarnet () + "(id, id_espacio) values (?, ?)");
        q.setParameters(idLector,idEspacio);
        return (long) q.executeUnique();
	}
	
	public long eliminarLectorPorId (PersistenceManager pm, long idLector)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaLectorCarnet () + " WHERE id = ?");
        q.setParameters(idLector);
        return (long) q.executeUnique();
	}
	
	public LectorCarnet darLectorPorId (PersistenceManager pm, long idLector) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaLectorCarnet () + " WHERE id = ?");
		q.setResultClass(LectorCarnet.class);
		q.setParameters(idLector);
		return (LectorCarnet) q.executeUnique();
	}
	
	public List<LectorCarnet> darLectores (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaLectorCarnet ());
		q.setResultClass(LectorCarnet.class);
		return (List<LectorCarnet>) q.executeList();
	}
}
