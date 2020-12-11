package uniandes.isis2304.parranderos.controller;

import uniandes.isis2304.parranderos.negocio.*;
import uniandes.isis2304.parranderos.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private View view;
    private AforoCC modelo;
    public Controller(){
        view = new View();
        modelo = new AforoCC();
    }

    public void run() throws IOException{
        boolean fin = false;
        Scanner reader = new Scanner(System.in);
        while (!fin){
            view.printMenu();
            int option = reader.nextInt();
            switch (option){
                case 0:
                    fin = true;
                    break;
                case 1:
                    int a = 0;
                    view.printMessage("[");
                    for (VOVisitante vt : modelo.darVisitantes()){
                        view.printMessage(vt.toString()+" ,");
                        a++;
                    }
                    view.printMessage("]");
                    view.printMessage("numero de tuplas en la tabla a_VISITANTES: " +a);
                    break;
                case 2:
                	int b = 0;
                    view.printMessage("[");
                    for (VOLectorCarnet vt : modelo.darLectores()){
                        view.printMessage(vt.toString()+" ,");
                        b++;
                    }
                    view.printMessage("]");
                    view.printMessage("numero de tuplas en la tabla a_LECTOR_CARNET: " +b);
                    break;
                case 3:
                	int c = 0;
                	view.printMessage("[");
                    for (VOEspacio vt : modelo.darEspacios()){
                        view.printMessage(vt.toString()+" ,");
                        c++;
                    }
                    view.printMessage("]");
                    view.printMessage("numero de tuplas en la tabla a_ESPACIO: " +c);
                    break;
                case 4:
                	int d = 0;
                	view.printMessage("[");
                    for (VOEstablecimiento vt : modelo.darEstablecimientos()){
                        view.printMessage(vt.toString()+" ,");
                        d++;
                    }
                    view.printMessage("]");
                    view.printMessage("numero de tuplas en la tabla a_ESTABLECIMIENTO: " +d);
                    break;
                case 5:
                	int e = 0;
                	view.printMessage("[");
                    for (VOVisitas vt : modelo.darVisitas()){
                        view.printMessage(vt.toString()+" ,");
                        e++;
                    }
                    view.printMessage("]");
                    view.printMessage("numero de tuplas en la tabla a_VISITAS: " +e);
                    break;
                case 6:
                    int f = 0;
                    view.printMessage("[");
                    for (VOCvisitas_VIEW vt : modelo.darTuplasCVisitas()){
                        view.printMessage(vt.toString()+" ,");
                        f++;
                    }
                    view.printMessage("]");
                    view.printMessage("numero de tuplas en la tabla CVISITAS: " +f);
                    break;
                case 10:
                    String atr1 = "";
                    String atr2 = "";
                    String tipOrden = "";
                    int M = 0;
                    view.printMessage("\tSELECCIONE EL NUMERO DE FILAS QUE QUIERE VER EN EL RESULTADO DE LA CONSULTA:\n ");
                    M= reader.nextInt();
                    view.printMessage("\tSELECCIONE LO QUE QUIERE HACER EN LA CONSULTA:\n ");
                    view.printMessage("\t\tQuiere agrupar informacion? Y/N");
                    String agrupar = reader.next();
                    if (agrupar.equalsIgnoreCase("Y")){
                        System.out.print("\t\tEn la vista CVISITAS se tienen lo siguientes atributos: \n" +
                                "\t\t VISITANTE:\n" +
                                "\t\t\t 1) id\n" +
                                "\t\t\t 2) tipo de identificacion\n" +
                                "\t\t\t 3) temperatura\n" +
                                "\t\t\t 4) correo\n" +
                                "\t\t\t 5) telefono\n" +
                                "\t\t\t 6) nombre contacto\n" +
                                "\t\t\t 7) telefono de contacto\n" +
                                "\t\t\t 8) positivo\n" +
                                "\t\t\t 9) color\n" +
                                "\t\t\t 10) tipo\n" +
                                "\t\t VISITAS:\n" +
                                "\t\t\t 11) id del lector de carnet \n" +
                                "\t\t\t 12) id del visitante \n " +
                                "\t\t\t 13) hora de ingreso al lugar\n" +
                                "\t\t\t 14) hora de salida del lugar\n" +
                                "\t\t ESPACIO:\n" +
                                "\t\t\t 15) id\n" +
                                "\t\t\t 16) capacidad original\n" +
                                "\t\t\t 17) hora apertura\n" +
                                "\t\t\t 18) hora cierre\n" +
                                "\t\t\t 19) descripcion\n" +
                                "\t\t\t 20) color\n" +
                                "\t\t\t 21) tipo de lugar\n" +
                                "\t\t TIPO LUGAR:\n" +
                                "\t\t\t 22) tipo de lugar (descripcion)\n" +
                                "\t\t\t 23) constante de aforo\n" +
                                "\t\t ESTABLECIMIENTO:\n" +
                                "\t\t\t 24) id\n" +
                                "\t\t\t 25) area\n" +
                                "\t\t\t 26) nombre\n" +
                                "\t\t\t 27) cerrado\n" +
                                "\t\t\t 28) tipo de estableciemiento\n" +
                                "\t\t\t 29) id del centro comercial\n" +
                                "Escriba los numeros de los atributos por lo cuales quiere ordenar, seprardos por comas\n" +
                                "Ej: 1,5,7,...,29\n"
                            );
                        atr1 = reader.next();
                    }
                    view.printMessage("\t\tQuiere ordernar informacion? Y/N");
                    String ordenar = reader.next();
                    if (ordenar.equalsIgnoreCase("Y")){
                        System.out.print("\t\tEn la vista CVISITAS se tienen lo siguientes atributos: \n" +
                                "\t\t VISITANTE:\n" +
                                "\t\t\t 1) id\n" +
                                "\t\t\t 2) tipo de identificacion\n" +
                                "\t\t\t 3) temperatura\n" +
                                "\t\t\t 4) correo\n" +
                                "\t\t\t 5) telefono\n" +
                                "\t\t\t 6) nombre contacto\n" +
                                "\t\t\t 7) telefono de contacto\n" +
                                "\t\t\t 8) positivo\n" +
                                "\t\t\t 9) color\n" +
                                "\t\t\t 10) tipo\n" +
                                "\t\t VISITAS:\n" +
                                "\t\t\t 11) id del lector de carnet \n" +
                                "\t\t\t 12) id del visitante \n " +
                                "\t\t\t 13) hora de ingreso al lugar\n" +
                                "\t\t\t 14) hora de salida del lugar\n" +
                                "\t\t ESPACIO:\n" +
                                "\t\t\t 15) id\n" +
                                "\t\t\t 16) capacidad original\n" +
                                "\t\t\t 17) hora apertura\n" +
                                "\t\t\t 18) hora cierre\n" +
                                "\t\t\t 19) descripcion\n" +
                                "\t\t\t 20) color\n" +
                                "\t\t\t 21) tipo de lugar\n" +
                                "\t\t TIPO LUGAR:\n" +
                                "\t\t\t 22) tipo de lugar (descripcion)\n" +
                                "\t\t\t 23) constante de aforo\n" +
                                "\t\t ESTABLECIMIENTO:\n" +
                                "\t\t\t 24) id\n" +
                                "\t\t\t 25) area\n" +
                                "\t\t\t 26) nombre\n" +
                                "\t\t\t 27) cerrado\n" +
                                "\t\t\t 28) tipo de estableciemiento\n" +
                                "\t\t\t 29) id del centro comercial\n" +
                                "Escriba los numeros de los atributos por lo cuales quiere ordenar, seprardos por comas\n" +
                                "Ej: 1,5,7,...,28\n"
                        );
                        atr2 = reader.next();
                        view.printMessage("\t\tEscriba el para cada atributo en que tipo de orden lo quiere ordenar" +
                                "Ej; ASC,DESC,DESC,...,ASC\n");
                        tipOrden = reader.next();
                        while  (atr2.split(",").length != tipOrden.split(",").length) {
                            view.printMessage("los atributos a ordernar y el tipo de orden no tienen la misma longitud, por favor corrija");
                            view.printMessage("Atributos:\n");
                            atr2 = reader.next();
                            view.printMessage("Tipo Orden:\n");
                            tipOrden =reader.next();
                        };
                    }
                    String query = modelo.manageCvisitasQuery(agrupar,atr1.split(","),ordenar,atr2.split(","),tipOrden.split(","));
                    ArrayList<String> group = new ArrayList<>();
                    for (String s : atr1.split(",") ){
                        group.add(modelo.tablaInd().get(Integer.parseInt(s)));
                    };
                    //metodo que maneje A,F,O
                    List<VOCvisitas_VIEW> resultList = modelo.getQueryCvisitasResults(query);
                    view.printMessage("[");
                    for(int i=0;i<M;i++){
                        view.printMessage(resultList.get(i).toStringVariable());
                    }
                    view.printMessage("]");
                    break;
            }               
        }
    }
}
