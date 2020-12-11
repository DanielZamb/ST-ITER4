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
        System.out.println("2.Ejecutar un select de lectorCarnet");
        System.out.println("3.Ejecutar un select de espacio");
        System.out.println("4.Ejecutar un select de establecimiento");
        System.out.println("5.Ejecutar un select de visitas");
        System.out.println("6.Ejecutar un select de Cvisitas view");
        System.out.println("7.Ejecutar un query de Cvisitas view");
    }

    public void printMessage(String mensaje) {

        System.out.println(mensaje);
    }
}
