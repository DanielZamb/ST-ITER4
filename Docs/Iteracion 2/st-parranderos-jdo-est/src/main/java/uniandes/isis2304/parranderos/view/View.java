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
        System.out.println("0.Terminar ejecucion");
        System.out.println("1.Ejecutar un select de visitantes");
    }

    public void printMessage(String mensaje) {

        System.out.println(mensaje);
    }
}
