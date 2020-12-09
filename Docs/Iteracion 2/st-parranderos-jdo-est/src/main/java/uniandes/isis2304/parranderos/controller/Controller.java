package uniandes.isis2304.parranderos.controller;

import uniandes.isis2304.parranderos.negocio.AforoCC;
import uniandes.isis2304.parranderos.negocio.VOEspacio;
import uniandes.isis2304.parranderos.negocio.VOEstablecimiento;
import uniandes.isis2304.parranderos.negocio.VOLectorCarnet;
import uniandes.isis2304.parranderos.negocio.VOVisitante;
import uniandes.isis2304.parranderos.negocio.VOVisitas;
import uniandes.isis2304.parranderos.view.View;

import java.io.IOException;
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
            }               
        }
    }
}
