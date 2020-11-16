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
    public long eliminarTipoVisitantePorId(PersistenceManager pm,long id){
        Query q = pm.newQuery(SQL,"DELETE FROM "+ pa.darTablaTipoVisitante()+" WHERE ID = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
    }
    public TipoLugar darTipoDeLugaPorId(PersistenceManager pm,long id){
        Query q = pm.newQuery(SQL, "SELECT * FROM " +pa.darTablaTipoLugar()+" WHERE ID = ?");
        q.setResultClass(TipoLugar.class);
        q.setParameters(id);
        return (TipoLugar) q.executeUnique();
    }
    public List<TipoLugar> darTodosLosTiposLugar (PersistenceManager pm){
        Query q = pm.newQuery(SQL, "SELECT * FROM "+pa.darTablaTipoLugar());
        q.setResultClass(TipoLugar.class);
        return (List<TipoLugar>) q.executeUnique();
    }
    public TipoLugar updateTipoLugar(PersistenceManager pm, long id, TipoLugar tipoLugar){
        Query q = pm.newQuery(SQL, "UPDATE "+pa.darTablaTipoLugar()+" SET tipo_lugar = ?, cons_aforo= ? WHERE id = ?");
        q.setResultClass(TipoLugar.class);
        q.setParameters(tipoLugar.getTipo_Lugar(),tipoLugar.getCons_aforo(),id);
        return (TipoLugar) q.executeUnique();
    }
}
