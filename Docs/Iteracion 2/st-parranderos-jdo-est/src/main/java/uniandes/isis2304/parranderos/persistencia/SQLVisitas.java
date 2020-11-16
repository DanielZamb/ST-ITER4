package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Visitante;
import uniandes.isis2304.parranderos.negocio.Visitas;


public class SQLVisitas {
    private final static String SQL = PersistenciaAforo.SQL;

    private PersistenciaAforo pa;

    public SQLVisitas (PersistenciaAforo pa)
    {
        this.pa = pa;
    }
    
    public long adicionarVisita (PersistenceManager pm, long idLector, long idVisitante, String horaIngreso, String horaSalida) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaVisitas () + "(id_lector, id_visitante, hora_ingreso, hora_salida ) values (?,?,?,?)");
        q.setParameters(idLector,idVisitante, horaIngreso, horaSalida);
        return (long) q.executeUnique();
	}
    
    public long eliminarVisitasPorIdVisitante (PersistenceManager pm, long idVisitas)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaVisitas () + " WHERE id_visitante = ?");
        q.setParameters(idVisitas);
        return (long) q.executeUnique();            
	}
    
    public Visitas darVisitasPorIdVisitante (PersistenceManager pm, long idVisitas) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitas () + " WHERE id_visitante = ?");
		q.setResultClass(Visitas.class);
		q.setParameters(idVisitas);
		return (Visitas) q.executeUnique();
	}
    
    public Visitas darVisitasPorIdLector (PersistenceManager pm, long idVisitas) 
   	{
   		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitas () + " WHERE id = ?");
   		q.setResultClass(Visitas.class);
   		q.setParameters(idVisitas);
   		return (Visitas) q.executeUnique();
   	}
    
    public Visitas darVisitasRangoTiempo(PersistenceManager pm, long idLector, String inicio, String fin)
    {
    	Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitas () + " WHERE id_lectorhora_ingreso BETWEEN ? AND ? ");
    	q.setResultClass(Visitas.class);
   		q.setParameters(inicio,fin);
   		return (Visitas) q.executeUnique();
    }
    
    
    public List<Visitas> darVisitas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitas());
		q.setResultClass(Visitante.class);
		return (List<Visitas>) q.executeList();
	}
    
    
    
    
    
}
