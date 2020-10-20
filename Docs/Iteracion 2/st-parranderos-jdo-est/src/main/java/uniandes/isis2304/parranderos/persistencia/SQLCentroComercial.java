package uniandes.isis2304.parranderos.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.CentroComercial;


public class SQLCentroComercial {
	
	private final static String SQL = PersistenciaAforo.SQL;
	
	private PersistenciaAforo pa;
	
	public SQLCentroComercial (PersistenciaAforo pa)
	{
		this.pa = pa;
	}
	
	public long adicionarCentroComercial (PersistenceManager pm, long id, String ciudad, String direccion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaCentroComercial () + "(id, ciudad, direccion ) values (?, ?, ?)");
        q.setParameters(id, ciudad, direccion);
        return (long) q.executeUnique();
	}
	
	public long eliminarCentroComercialPorId (PersistenceManager pm, long idCC)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaCentroComercial() + " WHERE id = ?");
        q.setParameters(idCC);
        return (long) q.executeUnique();
	}
	
	public CentroComercial darCentroComercialPorId (PersistenceManager pm, long idCC) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaCentroComercial () + " WHERE id = ?");
		q.setResultClass(CentroComercial.class);
		q.setParameters(idCC);
		return (CentroComercial) q.executeUnique();
	}
	
	public List<CentroComercial> darEspacios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaCentroComercial ());
		q.setResultClass(CentroComercial.class);
		return (List<CentroComercial>) q.executeList();
	}

}
