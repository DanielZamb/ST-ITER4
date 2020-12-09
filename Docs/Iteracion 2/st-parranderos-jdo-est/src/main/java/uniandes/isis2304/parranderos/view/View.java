package uniandes.isis2304.parranderos.view;

public class View {
    /**
     * Metodo constructor
     */
    public View()
    {
    }

    public void printMenu()
    {
        System.out.println("Interfaz AFOROCC C-10");
        System.out.println("0. Terminar la ejecucion");
        System.out.println("10. CONSULTAR VISITAS EN AFORO-CCANDES");
        System.out.println("11. CONSULTAR VISITAS EN AFORO-CCANDES v.2");
    }

    public void printMessage(String mensaje) {

        System.out.println(mensaje);
    }
}
