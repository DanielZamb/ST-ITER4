package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Establecimiento;
import uniandes.isis2304.parranderos.negocio.LectorCarnet;

public class SQLEstablecimiento {
	
	private final static String SQL = PersistenciaAforo.SQL;
	
	private PersistenciaAforo pa;
	
	public SQLEstablecimiento (PersistenciaAforo pa)
	{
		this.pa = pa;
	}
	
	public long adicionarEstablecimiento (PersistenceManager pm, long idEstablecimiento, double area, String nombre, long idCC  ) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaEstablecimiento () + "(idE,area, nombre, idCC) values (?, ?, ?,?)");
        q.setParameters(idEstablecimiento,area,nombre,idCC);
        return (long) q.executeUnique();
	}
	
	public long eliminarEstablecimientoPorId (PersistenceManager pm, long idEstablecimiento)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaEstablecimiento () + " WHERE id = ?");
        q.setParameters(idEstablecimiento);
        return (long) q.executeUnique();
	}
	
	public Establecimiento darEstablecimientoPorId (PersistenceManager pm, long idEstablecimiento) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaEstablecimiento () + " WHERE id = ?");
		q.setResultClass(Establecimiento.class);
		q.setParameters(idEstablecimiento);
		return (Establecimiento) q.executeUnique();
	}
	
	public List<Establecimiento> darEspacios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaEstablecimiento ());
		q.setResultClass(LectorCarnet.class);
		return (List<Establecimiento>) q.executeList();
	}
	

}
