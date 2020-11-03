package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Visitas;
public class SQLVisitas {
    private final static String SQL = PersistenciaAforo.SQL;

    private PersistenciaAforo pa;

    public SQLLectorCarnet (PersistenciaAforo pa)
    {
        this.pa = pa;
    }
}
