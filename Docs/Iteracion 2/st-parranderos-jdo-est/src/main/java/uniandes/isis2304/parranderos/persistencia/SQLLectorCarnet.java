package uniandes.isis2304.parranderos.persistencia;



import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Establecimiento;
import uniandes.isis2304.parranderos.negocio.LectorCarnet;
import uniandes.isis2304.parranderos.negocio.Visitante;

public class SQLLectorCarnet {
	
	private final static String SQL = PersistenciaAforo.SQL;
	
	private PersistenciaAforo pa;
	
	public SQLLectorCarnet (PersistenciaAforo pa)
	{
		this.pa = pa;
	}
	
	public long adicionarLector (PersistenceManager pm, long idLector, long idEspacio, long idVisitante, String horaIngreso, String horaSalida  ) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaLectorCarnet () + "(idL, idE, idV, ingreso, salida) values (?, ?, ?)");
        q.setParameters(idLector,idEspacio,idVisitante,horaIngreso,horaSalida);
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
	
	public List<Establecimiento> darEstablecimientosVisitados(PersistenceManager pm, long idVisitante)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM"+  pa.darTablaLectorCarnet ()+ "WHERE idvisitante = ?");
		q.setResultClass(Establecimiento.class);
		q.setParameters(idVisitante);
		return (List<Establecimiento>) q.executeList();
	}
	
	public List<Visitante> darEstablecimientosVisitadosHoras(PersistenceManager pm, double inicio, double salida)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM"+  pa.darTablaLectorCarnet ()+ "WHERE HORAINGRESO = ?"+" AND HORASALIDA = ?");
		q.setResultClass(Establecimiento.class);
		q.setParameters(inicio,salida);
		return (List<Visitante>) q.executeList();
	}
	
	

}
