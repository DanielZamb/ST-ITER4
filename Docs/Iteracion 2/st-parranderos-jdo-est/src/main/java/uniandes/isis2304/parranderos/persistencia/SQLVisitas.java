package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


import uniandes.isis2304.parranderos.negocio.Visitante;

import uniandes.isis2304.parranderos.negocio.Espacio;
import uniandes.isis2304.parranderos.negocio.TipoLugar;
import uniandes.isis2304.parranderos.negocio.TipoVisitante;

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
    
    public List<Long> darVisitasRangoTiempo(PersistenceManager pm, long idLector, String inicio, String fin)
    {
    	Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitas () + " WHERE id_lector = ? AND hora_ingreso BETWEEN ? AND ? ");
    	q.setResultClass(long.class);
   		q.setParameters(idLector,inicio,fin);
   		return (List<Long>) q.executeList();
    }
    
    
    public List<Visitas> darVisitas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitas());
		q.setResultClass(Visitante.class);
		return (List<Visitas>) q.executeList();
	}
    
 
   
    public long eliminarVisitaPorId (PersistenceManager pm, long idVisita)
    {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaVisitas() + " WHERE id = ?");
        q.setParameters(idVisita);
        return (long) q.executeUnique();
    }

    public Visitas darVisitaPorId (PersistenceManager pm, long idVisita)
    {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitas() + " WHERE id = ?");
        q.setResultClass(Visitas.class);
        q.setParameters(idVisita);
        return (Visitas) q.executeUnique();
    }
    public List<Visitas> darTodasLasVisitas (PersistenceManager pm){
        Query q = pm.newQuery(SQL, "SELECT * FROM "+pa.darTablaVisitas());
        q.setResultClass(Visitas.class);
        return (List<Visitas>) q.executeUnique();
    }
    public TipoVisitante updateVisita(PersistenceManager pm, long id_lector_carnet,long id_espacio, Visitas visita){
        Query q = pm.newQuery(SQL, "UPDATE "+pa.darTablaVisitas()+" SET hora_ingreso = ?, hora_salida = ? WHERE id_lector_carnet = ? AND id_espacio = ?");
        q.setResultClass(Visitas.class);
        q.setParameters(visita.getHora_ingreso(),visita.getHora_salida(),id_lector_carnet,id_espacio);
        return (TipoVisitante) q.executeUnique();
    }
    
   
}
