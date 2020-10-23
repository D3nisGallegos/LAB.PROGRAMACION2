/*Clase de metodos del laboratorio 1 de la clase de programacion 2 de semana1. 
 */
package lab1_denisgallegos;

import java.util.Scanner;
import java.util.Random;

public class METODOSCONECTA4 {
    
    //VARIABLES NECESARIAS: 
    Scanner lectura = new Scanner(System.in);
    Random aleatorio = new Random();
    
    //INICIO DE METODOS: 
    public void JUEGO(String nombre1, String nombre2){
        boolean ganar = false; 
        int turno = 1; 
        char [][] matriz = new char [7][7];
        while (ganar == false){
            if (turno == 1){
                System.out.println("TABLERO ACTUAL: ");
                IMPRIMIRTABLON(matriz);
                System.out.println("TURNO DEL JUGADOR 1: "+"\u001B[36m"+nombre1+"\u001B[0m");
                System.out.println("TIPO DE FICHA: o ");
                boolean validar = false; 
                String n = "";
                while (validar == false){
                    validar = false; 
                    n = "";
                    System.out.println("Ingrese la columna a conectar: ");
                    n = lectura.next();
                    for (int c = 0; c < n.length();c++){
                        char caracter = n.charAt(c);
                        int ascii = (int) caracter;
                        if (n.length() == 1){
                            if (ascii >= 48 && ascii <= 54){
                                validar = true;
                            }//Fin del if que valida el caracter.
                        }//Fin del if que valida la entrada.
                    }//Fin del for que recorre la entrada.
                }//Fin del while que reinica la entrada.
                int columna = Integer.parseInt(n);
                matriz = INGRESARJUGADOR1(matriz, columna);
                ganar = VERIFICARGANE1(matriz);
                if (ganar == true){
                    System.out.println("TABLERO DEL GANE: ");
                IMPRIMIRTABLON(matriz);
                    System.out.println("EL JUGADOR 1: "+"\u001B[36m"+nombre1+"\u001B[0m"+" HA GANADO.");
                }else {
                    turno = 2;
                }//Fin del if que valida el gane.
            }else if (turno == 2){
                System.out.println("TABLERO ACTUAL: ");
                IMPRIMIRTABLON(matriz);
                System.out.println("TURNO DEL JUGADOR 2: "+"\u001B[35m"+nombre2+"\u001B[0m");
                System.out.println("TIPO DE FICHA: * ");
                boolean validar = false; 
                String n = "";
                while (validar == false){
                    validar = false; 
                    n = "";
                    System.out.println("Ingrese la columna a conectar: ");
                    n = lectura.next();
                    for (int c = 0; c < n.length();c++){
                        char caracter = n.charAt(c);
                        int ascii = (int) caracter;
                        if (n.length() == 1){
                            if (ascii >= 48 && ascii <= 54){
                                validar = true;
                            }//Fin del if que valida el caracter.
                        }//Fin del if que valida la entrada.
                    }//Fin del for que recorre la entrada.
                }//Fin del while que reinica la entrada.
                int columna = Integer.parseInt(n);
                matriz = INGRESARJUGADOR2(matriz, columna);
                ganar = VERIFICARGANE2(matriz);
                if (ganar == true){
                    System.out.println("TABLERO DEL GANE: ");
                    IMPRIMIRTABLON(matriz);
                    System.out.println("El JUGADOR 2: "+"\u001B[35m"+nombre2+"\u001B[0m"+" HA GANADO.");
                }else {
                    turno = 1;
                }//Fin del if que valida el gane.
            }//Fin del if que valida los turnos.
            boolean llena = VERIFICARLLENA(matriz);
            if (llena == true){
                System.err.println("EMPATE: MATRIZ LLENA.");
                break;
            }//Fin del if que valida sila matriz esta llena.
        }//Fin del while que reinicia los turnos.
    }//Fin del metodo JUEGO.
    
    public void JUGADORVSPC(String nombre1){
        boolean ganar = false; 
        int turno = 1; 
        char [][] matriz = new char [7][7];
        while (ganar == false){
            if (turno == 1){
                System.out.println("TABLERO ACTUAL: ");
                IMPRIMIRTABLON(matriz);
                System.out.println("TURNO DEL JUGADOR 1: "+"\u001B[36m"+nombre1+"\u001B[0m");
                System.out.println("TIPO DE FICHA: o ");
                boolean validar = false; 
                String n = "";
                while (validar == false){
                    validar = false; 
                    n = "";
                    System.out.println("Ingrese la columna a conectar: ");
                    n = lectura.next();
                    for (int c = 0; c < n.length();c++){
                        char caracter = n.charAt(c);
                        int ascii = (int) caracter;
                        if (n.length() == 1){
                            if (ascii >= 48 && ascii <= 54){
                                validar = true;
                            }//Fin del if que valida el caracter.
                        }//Fin del if que valida la entrada.
                    }//Fin del for que recorre la entrada.
                }//Fin del while que reinica la entrada.
                int columna = Integer.parseInt(n);
                matriz = INGRESARJUGADOR1(matriz, columna);
                ganar = VERIFICARGANE1(matriz);
                if (ganar == true){
                    System.out.println("TABLERO DEL GANE: ");
                    IMPRIMIRTABLON(matriz);
                    System.out.println("EL JUGADOR 1: "+"\u001B[36m"+nombre1+"\u001B[0m"+" HA GANADO.");
                    break;
                }else {
                    turno = 2;
                }//Fin del if que valida el gane.
            }else if (turno == 2){
                System.out.println("TABLERO ACTUAL: ");
                IMPRIMIRTABLON(matriz);
                System.out.println("TURNO DE "+"\u001B[35m"+"PC"+"\u001B[0m"+":");
                System.out.println("TIPO DE FICHA: * ");
                int columna = 0;
                boolean v = false;
                while (v == false){
                    columna = 0 + aleatorio.nextInt(7);
                    v = VALIDARCOLUMNA(matriz, columna);
                }
                System.out.println("LA PC JUGARA EN LA COLUMNA: "+columna);
                matriz = INGRESARJUGADOR2(matriz, columna);
                ganar = VERIFICARGANE2(matriz);
                System.out.println(ganar);
                if (ganar == true){
                    System.out.println("TABLERO DEL GANE: ");
                    IMPRIMIRTABLON(matriz);
                    System.out.println("LA"+"\u001B[35m"+"PC"+"\u001B[0m"+"HA GANADO.");
                    break;
                }else {
                    turno = 1;
                }//Fin del if que valida el gane.
            }//Fin del if que valida los turnos.
            boolean llena = VERIFICARLLENA(matriz);
            if (llena == true){
                System.err.println("EMPATE: MATRIZ LLENA.");
                break;
            }//Fin del if que valida si la matriz esta llena.
        }//Fin del while que reinicia los turnos.
    }//Fin del metodo JUGADOR VS PC.
    
    //METODOS IMPRIMIR Y VERIFICAR: 
    public void IMPRIMIRTABLON(char [][] matriz){
        System.out.println("  0  1  2  3  4  5  6");
        char [] letras = { 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int c = 0; c < matriz.length;c++){
            System.out.print(letras [c]);
            for (int j = 0; j < matriz[0].length;j++){
                System.out.print("[");
                if (matriz [c][j] == 'o' || matriz [c][j] == '*'){
                    if (matriz [c][j] == 'o'){
                        System.out.print("\u001B[36m"+matriz [c][j]+"\u001B[0m");
                    }else {
                        System.out.print("\u001B[35m"+matriz [c][j]+"\u001B[0m");
                    }
                }else {
                    System.out.print(" ");
                }//Fin del if que valida los espacios.
                System.out.print("]");
            }//Fin del for que recorre las columnas.
            System.out.println("");
        }//Fin del for que recorre las filas.
    }//Fin del metodo IMPRIMIR TABLON.
    
    public char [][] INGRESARJUGADOR1(char [][] matriz, int columna){
        int acum = 0;
        for(int c = matriz.length - 1; c >= 0;c--){
            for (int j = matriz[0].length - 1; j >= 0;j--){
                if (j == columna){
                    String n = matriz [c][j] + "";
                    if (n.contains("o") == false && n.contains("*") == false && acum != 1){
                        matriz [c][j] = 'o';
                        acum = 1;
                    }//Fin del if que valida el elemento.
                }//Fin del if que valida la posicion. 
            }//Fin del for que recorre las columnas.
        }//Fin del for que recorre las filas.
        return matriz;
    }//Fin del metodo INGRESAR FICHA PARA JUGADOR 1.
    
    public char [][] INGRESARJUGADOR2(char [][] matriz, int columna){
        int acum = 0;
        for(int c = matriz.length - 1; c >= 0;c--){
            for (int j = matriz[0].length - 1; j >= 0;j--){
                if (j == columna){
                    String n = matriz [c][j] + "";
                    if (n.contains("*") == false && n.contains("o") == false && acum != 1){
                        matriz [c][j] = '*';
                        acum = 1;
                    }//Fin del if que valida el elemento.
                }//Fin del if que valida la posicion. 
            }//Fin del for que recorre las columnas.
        }//Fin del for que recorre las filas.
        return matriz;
    }//Fin del metodo INGRESAR FICHA PARA JUGADOR 1.
    
    public boolean VERIFICARGANE1(char [][] matriz){
        int acum = 0;
        boolean ganar = false; 
        for (int c = 0; c < matriz.length;c++){
            acum = 0;
            for (int j = 0; j <= 3;j++){
                if (matriz [c][j] == 'o'){
                    acum++;
                }//Fin del if que valida si las casillas.
            }//Fin del for que recorre las columnas.
            if (acum == 4){
                ganar = true;
            }//Fin del if que valida el gane.
        }//Fin del for que recorre las filas.
        for (int c = matriz.length - 1; c >= 0;c--){
            acum = 0;
            for (int j = matriz[0].length - 1; j >= 3;j--){
                if (matriz [c][j] == 'o'){
                    acum++;
                }//Fin del if que valida si las casillas.
            }//Fin del for que recorre las columnas.
            if (acum == 4){
                ganar = true;
            }//Fin del if que valida el gane.
        }//Fin del for que recorre las filas.
        //VALIDA POR COLUMNA:
        for (int c = 0; c < matriz[0].length;c++){
            acum = 0;
            for (int j = 0; j <= 3;j++){
                if (matriz [j][c] == 'o'){
                    acum++;
                }//Fin del if que valida la casilla.
            }//Fin del for que recorre las filas.
            if (acum == 4){
                ganar = true;
            }//Fin del if que valida el gane.
        }//Fin del for que recorre las columnas.
        for (int c = matriz[0].length - 1; c >= 0;c--){
            acum = 0;
            for (int j = matriz.length - 1; j >= 3;j--){
                if (matriz [j][c] == 'o'){
                    acum++;
                }//Fin del if que valida la casilla.
            }//Fin del for que recorre las filas.
            if (acum == 4){
                ganar = true;
            }//Fin del if que valida el gane.
        }//Fin del for que recorre las columnas.
        return ganar;
    }//Fin del metodo VERIFICAR GANE 1.
    
    public boolean VERIFICARGANE2(char [][] matriz){
        int acum = 0;
        boolean ganar = false; 
        for (int c = 0; c < matriz.length;c++){
            acum = 0;
            for (int j = 0; j <= 3;j++){
                if (matriz [c][j] == '*'){
                    acum++;
                }//Fin del if que valida si las casillas.
            }//Fin del for que recorre las columnas.
            if (acum == 4){
                ganar = true;
            }//Fin del if que valida el gane.
        }//Fin del for que recorre las filas.
        for (int c = matriz.length - 1; c >= 0;c--){
            acum = 0;
            for (int j = matriz[0].length - 1; j >= 3;j--){
                if (matriz [c][j] == '*'){
                    acum++;
                }//Fin del if que valida si las casillas.
            }//Fin del for que recorre las columnas.
            if (acum == 4){
                ganar = true;
            }//Fin del if que valida el gane.
        }//Fin del for que recorre las filas.
        //VALIDA POR COLUMNA:
        for (int c = 0; c < matriz[0].length;c++){
            acum = 0;
            for (int j = 0; j <= 3;j++){
                if (matriz [j][c] == '*'){
                    acum++;
                }//Fin del if que valida la casilla.
            }//Fin del for que recorre las filas.
            if (acum == 4){
                ganar = true;
            }//Fin del if que valida el gane.
        }//Fin del for que recorre las columnas.
        for (int c = matriz[0].length - 1; c >= 0;c--){
            acum = 0;
            for (int j = matriz.length - 1; j >= 3;j--){
                if (matriz [j][c] == '*'){
                    acum++;
                }//Fin del if que valida la casilla.
            }//Fin del for que recorre las filas.
            if (acum == 4){
                ganar = true;
            }//Fin del if que valida el gane.
        }//Fin del for que recorre las columnas.
        return ganar;
    }//Fin del metodo VERIFICAR GANE 1.
    
    public boolean VERIFICARLLENA(char [][] matriz){
        boolean llena = false; 
        int acum = 0;
        for (int c = 0; c < matriz.length;c++){
            for (int j = 0; j < matriz[0].length;j++){
                if (matriz [c][j] == 'o' || matriz [c][j] == '*'){
                    
                }else{
                    acum++;
                }//Fin del if que valida si la casilla esta llena.
            }//Fin del for que recorre las columnas.
        }//Fin del for que recorre las filas.
        if (acum == 0){
            llena = true;
        }//Fin del if que valida si el tablon esta lleno.
        return llena;
    }//Fin del metodo VERIFICAR LLENA.
    
    public boolean VALIDARCOLUMNA(char [][] matriz, int columna){
        boolean espacio = false;
        for (int c = 0; c < matriz.length;c++){
            for (int j = 0; j < matriz[0].length;j++){
                if (columna == j){
                    if (matriz [c][j] == 'o' || matriz [c][j] == '*'){
                    
                    }else {
                        espacio = true;
                    }
                }
            }//Fin del for que recorre las columnas.
        }//Fin del for que recorre las filas.
        return espacio;
    }//Fin del metodo VALIDAR MATRIZ.
    
    public int validar1(char [][] matriz){
        int acum = 0;
        int columna = -1;
        boolean encontro = false;
        for (int c = 0; c < matriz.length;c++){
            acum = 0;
            for (int j = 0; j <= 3;j++){
                if (matriz [c][j] == 'o'){
                    acum++;
                    columna = j;
                }//Fin del if que valida si las casillas.
            }//Fin del for que recorre las columnas.
            if (acum == 3){
                columna++;
                encontro = true;
            }//Fin del if que valida el gane.
        }//Fin del for que recorre las filas.
        return columna;
    }//Fin del metodo VALIDAR 1.
    
    public int validar2(char [][] matriz){
        int acum = 0;
        int columna = -1;
        boolean encontro = false;
        for (int c = matriz.length - 1; c >= 0;c--){
            acum = 0;
            for (int j = matriz[0].length - 1; j >= 3;j--){
                if (matriz [c][j] == 'o'){
                    acum++;
                    if (encontro == false){
                        columna = j;
                    }
                }//Fin del if que valida si las casillas.
            }//Fin del for que recorre las columnas.
            if (acum == 3 && encontro == false){
                columna++;
                encontro = true; 
            }//Fin del if que valida el gane.
        }//Fin del for que recorre las filas.
        return columna;
    }//Fin del metodo VALIDAR 2.
    
    public int validar3(char [][] matriz){
        int acum = 0;
        int columna = -1;
        boolean encontro = false;
        for (int c = 0; c < matriz[0].length;c++){
            acum = 0;
            for (int j = 0; j <= 3;j++){
                if (matriz [j][c] == 'o'){
                    acum++;
                }//Fin del if que valida la casilla.
            }//Fin del for que recorre las filas.
            if (acum == 3 && encontro == false){
                columna = c; 
                encontro = true;
            }//Fin del if que valida el gane.
        }//Fin del for que recorre las columnas.
        return columna;
    }//Fin de el metodo VALIDAR 3.
    
    public int validar4(char [][] matriz){
        int acum = 0;
        int columna = -1;
        boolean encontro = false;
        for (int c = matriz[0].length - 1; c >= 0;c--){
            acum = 0;
            for (int j = matriz.length - 1; j >= 3;j--){
                if (matriz [j][c] == 'o'){
                    acum++;
                }//Fin del if que valida la casilla.
            }//Fin del for que recorre las filas.
            if (acum == 3 && encontro == false){
                columna = c;
                encontro = true;
            }//Fin del if que valida el gane.
        }//Fin del for que recorre las columnas.
        return columna;
    }//Fin del metodo VALIDAR 4.
}//Fin de la clase.
