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
        Scanner scan = new Scanner(System.in);
        Scanner teclado= new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        Scanner prin = new Scanner(System.in);
        Scanner sca = new Scanner(System.in);
        while(op != 3 ){
          
            System.out.println("Tarea 3");
            System.out.println("201602503");
            System.out.println("\nSeleccione una opción");
            System.out.println("1. USUARIOS");
            System.out.println("2. PALABRAS PALÍNDROMAS");
           
            Scanner scansi = new Scanner(System.in);
            op = scansi.nextInt();
            
            switch (op){
            case (1):
        
                  while(h != 4 ){
            System.out.println("Menú de usuarios");
            System.out.println("\nSeleccione una opción");
            System.out.println("1. INGRESAR USUARIOS");
            System.out.println("2. MOSTRAR TODOS LOS USUARIOS");
            System.out.println("3. MOSTRAR UN USUARIO PERSONALIZADO");
            System.out.println("4. MENÚ PRINCIPAL");
            System.out.println("5. SALIR");
            Scanner ssi = new Scanner(System.in);
            h = ssi.nextInt();
            
            switch (h){
                case (1):
             for(a=0; a<5; a++){
			System.out.println("Ingrese usuario: ");
			usuario[a] = sc.nextLine();
		}
             break;
                case (2):
                  for(a=0; a<5; a++){
			System.out.println("Usuario " + (a+1) + " es " + usuario[a]);
		}  
             break;       
                case (3): 
                    error=0;
                    System.out.println("MOSTRAR UN USUARIO PERSONALIZADO: ");
                    System.out.println("Ingrese usuario: ");
                    letra = sca.next();
                    for(a=0; a<5; a++){
                    if (usuario[a].equals(letra)){
                     System.out.println(letra+"");   
                    }else{
                    error = error + 1; 
                    }
                    if (error == 5){
                     System.out.println("¡¡¡ERROR!!! No existe ningún usuario con esa coincidencia");
                    }
                    }   
                            
               break;  
               
               case(4):
                  
                   break;
                   
                   case(5):
               System.exit(0); 
                break;     
            }
         
                  }
                  
                  break;
            case (2):
                break;
        
                                
        }
        }

	}

}

