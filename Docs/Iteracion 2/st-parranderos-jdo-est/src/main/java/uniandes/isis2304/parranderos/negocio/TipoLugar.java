package uniandes.isis2304.parranderos.negocio;

public class TipoLugar implements VOTipoLugar {
    private String tipo_Lugar;
    private String cons_aforo;
    public TipoLugar() {
        this.tipo_Lugar = "";
        this.cons_aforo = "";
    }
    public TipoLugar(String tipo_Lugar, String cons_aforo) {
        this.tipo_Lugar = tipo_Lugar;
        this.cons_aforo = cons_aforo;
    }

    public String getTipo_Lugar() {
        return tipo_Lugar;
    }

    public void setTipo_Lugar(String tipo_Lugar) {
        this.tipo_Lugar = tipo_Lugar;
    }

    public String getCons_aforo() {
        return cons_aforo;
    }

    public void setCons_aforo(String cons_aforo) {
        this.cons_aforo = cons_aforo;
    }

    @Override
    public String toString() {
        return "TipoLugar{" +
                "tipo_Lugar='" + tipo_Lugar + '\'' +
                ", cons_aforo='" + cons_aforo + '\'' +
                '}';
    }
}
