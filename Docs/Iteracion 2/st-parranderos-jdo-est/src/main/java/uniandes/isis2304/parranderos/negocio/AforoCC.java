package uniandes.isis2304.parranderos.negocio;

import org.apache.log4j.Logger;
import com.google.gson.JsonObject;
import uniandes.isis2304.parranderos.persistencia.PersistenciaAforo;

import java.util.LinkedList;
import java.util.List;

public class AforoCC {
    private static Logger log = Logger.getLogger(AforoCC.class.getName());
    private PersistenciaAforo pp;
    public AforoCC () {
        pp = PersistenciaAforo.getInstance();
    }
    public AforoCC (JsonObject tableConfig) {
        pp = PersistenciaAforo.getInstance (tableConfig);
    }
    public void cerrarUnidadPersistencia () {
        pp.cerrarUnidadPersistencia ();
    }
    public List<VOVisitante> darVisitantes(){
        log.info("Generado los VO de los Visitantes");
        List<VOVisitante> voVisitantes = new LinkedList<VOVisitante>();
        for (Visitante vt : pp.darVisitantes() ){
            voVisitantes.add(vt);
        }
        log.info ("Generando los VO de visitantes : " + voVisitantes.size() + " existentes");
        return voVisitantes;
    }
    
    public List<VOVisitas> darVisitas(){
        log.info("Generado los VO de los Visitas");
        List<VOVisitas> voVisitas = new LinkedList<VOVisitas>();
        for (Visitas vt : pp.darVisitas() ){
            voVisitas.add(vt);
        }
        log.info ("Generando los VO de visitas : " + voVisitas.size() + " existentes");
        return voVisitas;
    }
    
    public List<VOLectorCarnet> darLectores(){
        log.info("Generado los VO de los lectores");
        List<VOLectorCarnet> voLectorCarnet = new LinkedList<VOLectorCarnet>();
        for (LectorCarnet vt : pp.darLectores() ){
            voLectorCarnet.add(vt);
        }
        log.info ("Generando los VO de lectores : " + voLectorCarnet.size() + " existentes");
        return voLectorCarnet;
    }
    
    public List<VOEstablecimiento> darEstablecimientos(){
        log.info("Generado los VO de los Establecimientos");
        List<VOEstablecimiento> voEstablecimiento = new LinkedList<VOEstablecimiento>();
        for (Establecimiento vt : pp.darEstablecimiento() ){
            voEstablecimiento.add(vt);
        }
        log.info ("Generando los VO de Establecimientos : " + voEstablecimiento.size() + " existentes");
        return voEstablecimiento;
    }
    
    public List<VOEspacio> darEspacios(){
        log.info("Generado los VO de los Espacios");
        List<VOEspacio> voEspacio = new LinkedList<VOEspacio>();
        for (Espacio vt : pp.darEspacio() ){
            voEspacio.add(vt);
        }
        log.info ("Generando los VO de Espacios : " + voEspacio.size() + " existentes");
        return voEspacio;
    }
    
    public List<VOAforoMaximo> darAforoMaximo(){
        log.info("Generado los VO del aforo maximo");
        List<VOAforoMaximo> voAforoMax = new LinkedList<VOAforoMaximo>();
        for (AforoMaximo vt : pp.darAforoMax() ){
            voAforoMax.add(vt);
        }
        log.info ("Generando los VO de AforoMaximo : " + voAforoMax.size() + " existentes");
        return voAforoMax;
    }
    
    public long [] limpiarAforo ()
    {
        log.info ("Limpiando la BD de Aforo");
        long [] borrrados = pp.limpiarAforo();
        log.info ("Limpiando la BD de Parranderos: Listo!");
        return borrrados;
    }
}
