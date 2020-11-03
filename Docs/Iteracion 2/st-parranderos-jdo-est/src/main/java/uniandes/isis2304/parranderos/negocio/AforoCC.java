package uniandes.isis2304.parranderos.negocio;

import org.apache.log4j.Logger;
import com.google.gson.JsonObject;
import uniandes.isis2304.parranderos.persistencia.PersistenciaAforo;

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
}
