package uniandes.isis2304.parranderos.controller;

import uniandes.isis2304.parranderos.negocio.AforoCC;
import uniandes.isis2304.parranderos.negocio.VOVisitante;
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
                case 1:
                    int c = 0;
                    view.printMessage("[");
                    for (VOVisitante vt : modelo.darVisitantes()){
                        view.printMessage(vt.toString()+" ,");
                        c++;
                    }
                    view.printMessage("]");
                    view.printMessage("numero de tuplas en la tabla a_VISITANTES: " +c);
            }
        }
    }
}
