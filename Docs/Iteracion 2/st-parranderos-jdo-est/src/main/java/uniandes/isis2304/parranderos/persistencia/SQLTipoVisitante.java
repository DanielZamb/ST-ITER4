package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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
}
