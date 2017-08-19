package buscaminas_201602503;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Buscaminas_201602503 {
    
       
        private static Scanner sc;
	private static int a, error;
	private static String usuario[] = new String[5];
	public static void main(String[] args) {
        sc = new Scanner(System.in);
        int op =0, h=0, pri=0;
        String letra;
        String nuevo;
        
        
          
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
        }
        if (scanner.hasNextLine()) {
            readString = scanner.nextLine();
        } else {
            readString = null;
        }

                                  
            }
        }

