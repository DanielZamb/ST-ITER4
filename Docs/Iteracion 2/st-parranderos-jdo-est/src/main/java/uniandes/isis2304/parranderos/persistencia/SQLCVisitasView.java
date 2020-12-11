package uniandes.isis2304.parranderos.persistencia;

import uniandes.isis2304.parranderos.negocio.Cvisitas_VIEW;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

public class SQLCVisitasView {
    private final static String SQL = PersistenciaAforo.SQL;

    private PersistenciaAforo pa;

    public SQLCVisitasView (PersistenciaAforo pa)
    {
        this.pa = pa;
    }

    public List<Cvisitas_VIEW> darTuplasCvisitas(PersistenceManager pm){
        Query q = pm.newQuery(SQL,"SELECT * FROM CVISITAS");
        q.setResultClass(Cvisitas_VIEW.class);
        return (List<Cvisitas_VIEW>) q.executeList();
    }
    public List<Cvisitas_VIEW> queryCvistas(PersistenceManager pm, String query){
        Query q =  pm.newQuery(SQL, query);
        q.setResultClass(Cvisitas_VIEW.class);
        return (List<Cvisitas_VIEW>) q.executeList();
    }
}
