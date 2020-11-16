package uniandes.isis2304.parranderos.persistencia;

import java.sql.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Espacio;

public class SQLEspacio {

	private final static String SQL = PersistenciaAforo.SQL;
	
	private PersistenciaAforo pa;
	
	public SQLEspacio (PersistenciaAforo pa)
	{
		this.pa = pa;
	}
	
	public long adicionarEspacio (PersistenceManager pm, long idEspacio, int capacidad, String apertura, String cierre, String descripcion,long tipo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaEspacio () + "(id, capacidad_original, hora_apertura, hora_cierre, descripcion, tipo_lugar) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idEspacio, capacidad, apertura, cierre, descripcion, tipo);
        return (long) q.executeUnique();
	}
	
	public long eliminarEspacioPorId (PersistenceManager pm, long idEspacio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaEspacio () + " WHERE id = ?");
        q.setParameters(idEspacio);
        return (long) q.executeUnique();
	}
	
	public Espacio darEspacioPorId (PersistenceManager pm, long idEspacio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaEspacio () + " WHERE id = ?");
		q.setResultClass(Espacio.class);
		q.setParameters(idEspacio);
		return (Espacio) q.executeUnique();
	}
	
	public List<Espacio> darEspacios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaEspacio ());
		q.setResultClass(Espacio.class);
		return (List<Espacio>) q.executeList();
	}
	public void cambiarColor(PersistenceManager pm, long id, String color ) {
		Query q = pm.newQuery(SQL, "UPDATE " + pa.darTablaEspacio() + " SET color = ? WHERE id = ?");
		q.setParameters(color, id);
	}

}
