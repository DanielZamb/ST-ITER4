package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.AforoActual;
import uniandes.isis2304.parranderos.negocio.AforoMaximo;
import uniandes.isis2304.parranderos.negocio.Espacio;

public class SQLAforoMaximo {
	
	private final static String SQL = PersistenciaAforo.SQL;
	
	private PersistenciaAforo pa;
	
	public SQLAforoMaximo (PersistenciaAforo pa)
	{
		this.pa = pa;
	}
	
	public long adicionarAforoActual (PersistenceManager pm, String tipo, double aforoMaximo, long idEspacio ) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaAforoMaximo () + "(TIPO,AFORO_MAXIMO,ID_ESPACIO) values (?, ?, ?)");
        q.setParameters(tipo, aforoMaximo, idEspacio);
        return (long) q.executeUnique();
	}
	
	public long eliminarAforoPorId (PersistenceManager pm, long idAforo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaAforoMaximo () + " WHERE id = ?");
        q.setParameters(idAforo);
        return (long) q.executeUnique();
	}
	
	public AforoMaximo darAforoPorId (PersistenceManager pm, long idAforo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaAforoMaximo () + " WHERE id = ?");
		q.setResultClass(AforoMaximo.class);
		q.setParameters(idAforo);
		return (AforoMaximo) q.executeUnique();
	}
	
	public List<AforoMaximo> darAforosMaximos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaAforoMaximo ());
		q.setResultClass(Espacio.class);
		return (List<AforoMaximo>) q.executeList();
	}
	
	public int darAforoMaximo(PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "SELECT aforo_maximo FROM " + pa.darTablaAforoMaximo() +"WHERE id_espacio = ?");
		q.setResultClass(int.class);
		q.setParameters(id);
		return (int)q.executeUnique();
	}
	

}
