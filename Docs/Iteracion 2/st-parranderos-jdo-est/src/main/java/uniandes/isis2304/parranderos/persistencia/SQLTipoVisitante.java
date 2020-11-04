package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Espacio;
import uniandes.isis2304.parranderos.negocio.TipoLugar;
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
    
    public Espacio darTipoVisitantePorId (PersistenceManager pm, long idTipoV)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaEspacio () + " WHERE id = ?");
		q.setResultClass(Espacio.class);
		q.setParameters(idTipoV);
		return (Espacio) q.executeUnique();
	}
    public List<TipoVisitante> darTodosLosTiposVisitante (PersistenceManager pm){
        Query q = pm.newQuery(SQL, "SELECT * FROM "+pa.darTablaVisitante());
        q.setResultClass(TipoVisitante.class);
        return (List<TipoVisitante>) q.executeUnique();
    }
    public TipoVisitante updateTipoLugar(PersistenceManager pm, long id, TipoVisitante tipoVisitante){
        Query q = pm.newQuery(SQL, "UPDATE "+pa.darTablaVisitante()+" SET tipo_visitante = ?, horario = ? WHERE id = ?");
        q.setResultClass(TipoLugar.class);
        q.setParameters(tipoVisitante.getTipo_visitante(),tipoVisitante.getHorario(),id);
        return (TipoVisitante) q.executeUnique();
    }
}
