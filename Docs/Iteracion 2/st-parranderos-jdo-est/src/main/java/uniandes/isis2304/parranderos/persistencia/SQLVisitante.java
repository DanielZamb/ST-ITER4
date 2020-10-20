package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


import uniandes.isis2304.parranderos.negocio.Visitante;

public class SQLVisitante {
	
	private final static String SQL = PersistenciaAforo.SQL;
	
	private PersistenciaAforo pa;
	
	public SQLVisitante (PersistenciaAforo pa)
	{
		this.pa = pa;
	}
	
	public long adicionarVisitante (PersistenceManager pm, long numIdentificacion, String tipoIdentificacion, String nombre, String correo, int telefono, String nombreContacto, int telefonoContacto, String ciudad, String tipo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaVisitante () + "(id, tipoId, nombre, correo, telefono, nombreCont, telefonoCont, ciudad, tipo) values (?, ?, ?, ?)");
        q.setParameters(numIdentificacion,tipoIdentificacion, nombre, correo, telefono, nombreContacto, telefonoContacto,ciudad, tipo);
        return (long) q.executeUnique();
	}
	
	public long eliminarVisitantePorNombre (PersistenceManager pm, String nombre)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaVisitante () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();            
	}
	
	public long eliminarVisitantePorId (PersistenceManager pm, long idVisitante)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaVisitante () + " WHERE id = ?");
        q.setParameters(idVisitante);
        return (long) q.executeUnique();            
	}
	
	public Visitante darBebedorPorId (PersistenceManager pm, long idVisitante) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitante () + " WHERE id = ?");
		q.setResultClass(Visitante.class);
		q.setParameters(idVisitante);
		return (Visitante) q.executeUnique();
	}
	
	public List<Visitante> darVisitantePorNombre (PersistenceManager pm, String nombreVisitante) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitante () + " WHERE nombre = ?");
		q.setResultClass(Visitante.class);
		q.setParameters(nombreVisitante);
		return (List<Visitante>) q.executeList();
	}
	
	public List<Visitante> darVisitantes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitante());
		q.setResultClass(Visitante.class);
		return (List<Visitante>) q.executeList();
	}
	
	
	
}
