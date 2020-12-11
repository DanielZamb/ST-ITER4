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

    public List<Visitas> darVisitasRangoTiempoLectorCarnet(PersistenceManager pm, long idLector, String inStart, String inEnd, String outStart, String outEnd)
    {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitas () + " WHERE id_lector_carnet = ? AND (hora_ingreso BETWEEN TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF') AND TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) AND (hora_salida between TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF') AND TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) ");
        q.setResultClass(Visitas.class);
        q.setParameters(idLector,inStart,inEnd,outStart,outStart);
        return (List<Visitas>) q.executeList();
    }
    public List<Visitas> darVisitasRangoTiempoLectorCarnet(PersistenceManager pm, long idLector, String inStart, String inEnd)
    {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitas () + " WHERE id_lector_carnet = ? AND (hora_ingreso > TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) AND (hora_salida < TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) ");
        q.setResultClass(Visitas.class);
        q.setParameters(idLector,inStart,inEnd);
        return (List<Visitas>) q.executeList();
    }

    public List<Visitas> darVisitasRangoTiempoIdVisitante(PersistenceManager pm, long idVisitante, String inicio, String inEnd, String outStart, String outEnd)
    {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitas () + " WHERE id_visitante = ? AND (hora_ingreso BETWEEN TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF') AND TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) AND (hora_salida between TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF') AND TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) ");
        q.setResultClass(Visitas.class);
        q.setParameters(idVisitante,inicio,inEnd,outStart,outStart);
        return (List<Visitas>) q.executeList();
    }
    public List<Visitas> darVisitasRangoTiempoIdVisitante(PersistenceManager pm, long idVisitante, String inicio, String inEnd)
    {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitas () + " WHERE id_visitante = ? AND (hora_ingreso > TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) AND (hora_salida < TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) ");
        q.setResultClass(Visitas.class);
        q.setParameters(idVisitante,inicio,inEnd);
        return (List<Visitas>) q.executeList();
    }

    public List<Long> darIdVisitanteVisitasRangoTiempoLectorCarnet(PersistenceManager pm, long idLector, String inicio, String inEnd, String outStart, String outEnd)
    {
        Query q = pm.newQuery(SQL, "SELECT id_visitante FROM " + pa.darTablaVisitas () + " WHERE id_lector_carnet = ? AND (hora_ingreso BETWEEN TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF') AND TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) AND (hora_salida between TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF') AND TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) ");
        q.setResultClass(Long.class);
        q.setParameters(idLector,inicio,inEnd,outStart,outEnd);
        return (List<Long>) q.executeList();
    }
    public List<Long> darIdVisitanteVisitasRangoTiempoLectorCarnet(PersistenceManager pm, long idLector, String inicio, String inEnd)
    {
        Query q = pm.newQuery(SQL, "SELECT id_visitante FROM " + pa.darTablaVisitas () + " WHERE id_lector_carnet = ? AND (hora_ingreso > TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) AND (hora_salida < TO_TIMESTAMP(?,'DD/MM/YYYY HH24:MI:SSXFF')) ");
        q.setResultClass(Long.class);
        q.setParameters(idLector,inicio,inEnd);
        return (List<Long>) q.executeList();
    }
    
    public List<Visitas> darVisitasClientesEsablecimientoPorIdEspacio(PersistenceManager pm, long idEspacio){
        String sql0 = "SELECT "+pa.darTablaLectorCarnet()+".id,id_espacio FROM "+ pa.darTablaLectorCarnet() + ","+pa.darTablaEstablecimiento()+" WHERE "+ pa.darTablaLectorCarnet()+".id_espacio = ? and "+ pa.darTablaEstablecimiento()+".id = ?";
        String sql1 = "SELECT id_lector_carnet,id_visitante,hora_ingreso,hora_salida FROM  ( "+sql0+" ) t1,"+pa.darTablaVisitas()+","+pa.darTablaVisitante()
                +" where t1.id = "+ pa.darTablaVisitas()+".id_lector_carnet and "+ pa.darTablaVisitante()+".tipo = 1 and "
                + pa.darTablaVisitante()+".id = "+ pa.darTablaVisitas()+".id_visitante ORDER BY "+pa.darTablaVisitas()+".id_visitante";
        Query q = pm.newQuery(SQL, sql1);
        q.setResultClass(Visitas.class);
        q.setParameters(idEspacio,idEspacio);
        return (List<Visitas>) q.executeList();
    }
    public List<Visitas> darVisitaPorIdVisitanteIdLector (PersistenceManager pm, long idVisitante,long idLector){
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVisitas() + " WHERE id_visitante = ? and id_lector_carnet = ? " +
                "order by hora_ingreso");
        q.setResultClass(Visitas.class);
        q.setParameters(idVisitante,idLector);
        return (List<Visitas>) q.executeUnique();
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
        return (List<Visitas>) q.executeList();
    }
    public TipoVisitante updateVisita(PersistenceManager pm, long id_lector_carnet,long id_espacio, Visitas visita){
        Query q = pm.newQuery(SQL, "UPDATE "+pa.darTablaVisitas()+" SET hora_ingreso = ?, hora_salida = ? WHERE id_lector_carnet = ? AND id_espacio = ?");
        q.setResultClass(Visitas.class);
        q.setParameters(visita.getHora_ingreso(),visita.getHora_salida(),id_lector_carnet,id_espacio);
        return (TipoVisitante) q.executeUnique();
    }
    
   
}
