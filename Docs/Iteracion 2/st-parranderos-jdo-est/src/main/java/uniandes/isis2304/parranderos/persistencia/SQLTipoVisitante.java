package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Espacio;
import uniandes.isis2304.parranderos.negocio.TipoVisitante;
public class SQLTipoVisitante {
    private final static String SQL = PersistenciaAforo.SQL;

    private PersistenciaAforo pa;

    public SQLTipoVisitante (PersistenciaAforo pa)
    {
        this.pa = pa;
    }

    public long adicionarTipoVisitante (PersistenceManager pm,long id, String tipoVisitante, String horario)
    {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaVisitante () + "(id,tipo_visitante, horario) values (?,?, ?)");
        q.setParameters(id,tipoVisitante,horario);
        return (long) q.executeUnique();
    }
    
    public long eliminarTipoVisitantePorId (PersistenceManager pm, long idTipoV)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaTipoVisitante() + " WHERE id = ?");
        q.setParameters(idTipoV);
        return (long) q.executeUnique();
	}
    
    public Espacio darTipoVisitantePorId (PersistenceManager pm, long idEspacio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaEspacio () + " WHERE id = ?");
		q.setResultClass(Espacio.class);
		q.setParameters(idEspacio);
		return (Espacio) q.executeUnique();
	}
}
