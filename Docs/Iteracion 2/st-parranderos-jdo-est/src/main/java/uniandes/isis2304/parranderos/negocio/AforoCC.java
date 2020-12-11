package uniandes.isis2304.parranderos.negocio;

import org.apache.log4j.Logger;
import com.google.gson.JsonObject;
import uniandes.isis2304.parranderos.persistencia.PersistenciaAforo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AforoCC {
    private static Logger log = Logger.getLogger(AforoCC.class.getName());
    private PersistenciaAforo pp;
    private Map<Integer,String> cvisitasMap = new HashMap<>();
    public AforoCC () {
        pp = PersistenciaAforo.getInstance();
        cvisitasMap.put(1,"visitante_id");
        cvisitasMap.put(2,"tipo_identificacion");
        cvisitasMap.put(3,"tempreatura");
        cvisitasMap.put(4,"correo");
        cvisitasMap.put(5,"telefono");
        cvisitasMap.put(6,"nombre_contacto");
        cvisitasMap.put(7,"telefono_contacto");
        cvisitasMap.put(8,"positivo");
        cvisitasMap.put(9,"visitante_color");
        cvisitasMap.put(10,"tipo");
        cvisitasMap.put(11,"id_lector_carnet");
        cvisitasMap.put(12,"id_visitante");
        cvisitasMap.put(13,"hora_ingreso");
        cvisitasMap.put(14,"hora_salida");
        cvisitasMap.put(15,"espacio_id");
        cvisitasMap.put(16,"capacidad_original");
        cvisitasMap.put(17,"hora_apertura");
        cvisitasMap.put(18,"hora_cierre");
        cvisitasMap.put(19,"descripcion");
        cvisitasMap.put(20,"espacio_color");
        cvisitasMap.put(21,"tipo_lugar_id");
        cvisitasMap.put(22,"tipo_lugar");
        cvisitasMap.put(23,"cons_aforo");
        cvisitasMap.put(24,"establecimiento_id");
        cvisitasMap.put(25,"area");
        cvisitasMap.put(26,"establecimiento_nombre");
        cvisitasMap.put(27,"cerrado");
        cvisitasMap.put(28,"tipo_establecimiento");
        cvisitasMap.put(29,"id_cc");
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
        List<VOAforoMaximo> voAforoMax = new LinkedList<>(pp.darAforoMax());
        log.info ("Generando los VO de AforoMaximo : " + voAforoMax.size() + " existentes");
        return voAforoMax;
    }
    public List<VOCvisitas_VIEW> darTuplasCVisitas(){
        log.info("Generado los VO de la vista materializada");
        List<VOCvisitas_VIEW> voCvisitas_views = new LinkedList<>(pp.darCvisitas());
        log.info("Generado los VO de la vista materializada: "+voCvisitas_views.size()+ " existentes" );
        return voCvisitas_views;
    }
    public String manageCvisitasQuery(String sort, String[] sParams, String[] sTypes){
        StringBuilder query = new StringBuilder("SELECT * FROM CVISITAS");
        if (sort.equals("Y")){
            query.append(" ORDER BY");
            for (int i=0;i<sParams.length;i++){
                if(i==sParams.length-1){
                    query.append(" ").append(pp.darVistaVisitas()).append(".").append(cvisitasMap.get(Integer.parseInt(sParams[i]))).append(" ").append(sTypes[i]);
                }
                else
                    query.append(" ").append(pp.darVistaVisitas()).append(".").append(cvisitasMap.get(Integer.parseInt(sParams[i]))).append(" ").append(sTypes[i]).append(",");
            }
        }
        return query.toString();
    }
    public List<VOCvisitas_VIEW> getQueryCvisitasResults(String query){
        log.info("Generado los VO de la vista materializada");
        List<VOCvisitas_VIEW> voCvisitas_views = new LinkedList<>(pp.executeQueryCvisitas(query));
        log.info("Generado los VO de la vista materializada: "+voCvisitas_views.size()+ " existentes" );
        return voCvisitas_views;
    }
    public long [] limpiarAforo ()
    {
        log.info ("Limpiando la BD de Aforo");
        long [] borrrados = pp.limpiarAforo();
        log.info ("Limpiando la BD de Parranderos: Listo!");
        return borrrados;
    }
}
