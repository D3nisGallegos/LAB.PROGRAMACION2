/*Programa de laboratorio 1 de la clase de programacion 2 de semamana 1.
 */
package lab1_denisgallegos;

import java.util.Random;
import java.util.Scanner;


public class Lab1_DenisGallegos {

    static Scanner lectura = new Scanner(System.in);
    static Random aleatorio = new Random();
    
    public static void main(String[] args) {
        
        boolean entrada = false; 
        String n = "";
        while (entrada == false){
            n = "";
            System.out.println("      CONECTA 4:");
            System.out.println("1) Modalidad de 2 jugadores. ");
            System.out.println("2) Modalidad de jugador vs la PC.");
            System.out.println("Ingrese la opcion: ");
            n = lectura.next();
            boolean validar = true; 
            for (int c = 0; c < n.length();c++){
                char caracter  = n.charAt(c);
                int ascii = (int) caracter;
                if (ascii != 49 && ascii != 50){
                    validar = false;
                } else if (n.length() > 1){
                    validar = false; 
                }//Fin del if que valida la entrada.
            }//Fin del for que recorre la entrada.
            if (validar == false){
                System.out.println("Error, entrada de modalidad no valida. Ingrese 1 o 2.");
                entrada = false; 
            }else if (validar == true){
                entrada = true;
            }//Fin del if que valida la entrada.
        }//Fin del while que reinicia la peticion de la entrada.
        int opcion = Integer.parseInt(n);
        switch (opcion){
            case 1:
                {
                System.out.println("      OPCION 1: JUGADOR VS JUGADOR: ");
                boolean nombres = false;
                String nombre1 = "";
                String nombre2 = "";
                while (nombres == false){
                    nombres = false;
                    nombre1 = "";
                    nombre2 = "";
                    System.out.println("Ingrese el nombre del jugador 1: ");
                    nombre1 = lectura.next();
                    if (nombre1.isEmpty() == true){
                        System.out.println("Error de entrada. Nombre ingresado no valido.");
                    }//Fin del if que valida los nombres.
                    System.out.println("Ingrese el nombre del jugador 2: ");
                    nombre2 = lectura.next();
                    if (nombre1.isEmpty() == false && nombre2.isEmpty() == false){
                        nombres = true;
                    }else {
                        System.out.println("Error de entrada. Nombres ingresados no validos.");
                    }//Fin del if que valida los nombres.
                }//Fin del while que reinicia el programa.
                METODOSCONECTA4 instancia = new METODOSCONECTA4();
                instancia.JUEGO(nombre1, nombre2);
                break; 
                }//Fin del caso 1.
            case 2:
                {
                System.out.println("      OPCION 2: JUGADOR VS PC: ");
                boolean nombres = false;
                String nombre1 = "";
                while (nombres == false){
                    nombres = false;
                    nombre1 = "";
                    System.out.println("Ingrese el nombre del jugador 1: ");
                    nombre1 = lectura.next();
                    if (nombre1.isEmpty() == false){
                        nombres = true;
                    }else {
                        System.out.println("Error de entrada. Nombre ingresado no valido.");
                    }//Fin del if que valida el nombre.
                }//Fin del while que reinicia el programa.
                METODOSCONECTA4 instancia = new METODOSCONECTA4();
                instancia.JUGADORVSPC(nombre1);
                break; 
                }//Fin del caso 2.
        }//Fin del switch que valida la opcion.
    }//Fin del MAIN.
    
}//Fin de la clase. 
