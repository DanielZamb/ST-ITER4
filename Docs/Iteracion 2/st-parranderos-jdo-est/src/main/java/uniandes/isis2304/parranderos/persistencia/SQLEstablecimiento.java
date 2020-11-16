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
	
	public long adicionarEstablecimiento (PersistenceManager pm, long idEstablecimiento, double area, String nombre, short cerrado, long idCC  ) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaEstablecimiento () + "(ID,AREA, NOMBRE,CERRADO, ID_CC) values (?, ?, ?, ?, ?)");
        q.setParameters(idEstablecimiento,area,nombre,cerrado,idCC);
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
	
	public List<Establecimiento> darEstablecimientos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaEstablecimiento ());
		q.setResultClass(LectorCarnet.class);
		return (List<Establecimiento>) q.executeList();
	}
	
	public void cerrarEstablecimiento(PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "UPDATE" + pa.darTablaEstablecimiento() +"SET cerrado = 1 WHERE id = ?");
		q.setParameters(id);
	}
	

}
