package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.TipoLugar;
public class SQLTipoLugar {
    private final static String SQL = PersistenciaAforo.SQL;

    private PersistenciaAforo pa;

    public SQLTipoLugar (PersistenciaAforo pa)
    {
        this.pa = pa;
    }

    public long adicionarTipoVisitante (PersistenceManager pm,long id, String tipoLugar, String consAforo)
    {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaVisitante () + "(id,tipo_lugar, cons_aforo) values (?,?, ?)");
        q.setParameters(id,tipoLugar,consAforo);
        return (long) q.executeUnique();
    }
}
