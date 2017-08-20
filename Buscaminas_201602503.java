package buscaminas_201602503;

import java.util.Scanner;
import java.util.Random;


public class Buscaminas_201602503 {
    
    public static char[][] matriz = new char[17][31];
    public static char[][] matriz2 = new char[17][31];
    public static int filas = 0;
    public static int columnas = 0;
    public static int minas = 0;
    public static int mov1 = 0;
    public static int mov2 = 0;
    public static int win = 0;
    public static boolean fipartida = false;
    public static boolean debug = false;
    public static int count = 0;
    public static boolean fi = false;
        private static Scanner sc;
	public static void main(String[] args) {
        int o=0;

        Scanner t=new Scanner(System.in);
        
          
            System.out.println("Pablo Rodrigo Barillas Calderón");
            System.out.println("201602503");
            System.out.println("\n IPC1 A Práctica 1");
            System.out.println("¡¡¡BUSCAMINAS!!!");
            System.out.println("\n Presione enter para empezar...");
           
            Scanner scanner = new Scanner(System.in);
           String readString = scanner.nextLine();
            
           if (readString.isEmpty()) {
                
           System.out.println("¡¡¡BUSCAMINAS!!!");
           System.out.println("\n1. Principiante");
           System.out.println("2. Intermedio");
           System.out.println("3. Experto");
           System.out.println("4. Salir");
           System.out.println("\nIngrese opción...");
           Scanner ssi = new Scanner(System.in);
            o = ssi.nextInt();
             switch (o) {
                 case(1):
                filas = 5;
                columnas = 5;
                minas = 4;
                win = (5 * 5) - 4;
                break;
                case(2):
                filas = 7;
                columnas = 7;
                minas = 8;
                win = (7 * 7) - 8;
                break;
                case (3):
                filas = 9;
                columnas = 9;
                minas = 12;
                win = (9 * 9) - 12; 
                break;
                case(4):
                System.exit(0);    
                    break;
             }
             
        }else {
            readString = null;
            System.out.println("\n¡SOLO ES VÁLIDA LA TECLA ENTER!");
        }
        }
}

