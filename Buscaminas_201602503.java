package buscaminas_201602503;

import java.util.Random;
import java.util.Scanner;


public class Buscaminas_201602503 {

    public static char[][] m1 = new char[17][31];
    public static char[][] m2 = new char[17][31];
    public static int minas = 0;
    public static int a = 0;
    public static int b = 0;
    public static int gan = 0;
    public static int fil = 0;
    public static int col = 0;
    public static boolean reiniciar = false;
    public static String d;
    public static boolean finalito = false;
    public static boolean ocaso = false;
    public static boolean pr = false;
    public static int conta = 0;

   
    public static void menú2() {
        finalito =true;
        Scanner sc = new Scanner(System.in);
        while(finalito){
            finalito=false;
        System.out.println("¡¡¡BUSCAMINAS!!!");
        System.out.println("1. Principiante");
        System.out.println("2. Intermedio");
        System.out.println("3. Avanzado");
        System.out.println("4. Salir");
        System.out.print("Ingrese opción... ");
        int op=0;
        String error="";
        try{
            op = sc.nextInt();
        }catch(Exception e){
            
            error = sc.nextLine();
        }
        System.out.println("");
        switch (op) {
            case 1:
                System.out.println("Nivel Principiante");
                fil = 5;
                col = 5;
                minas = 4;
                gan = (4 * 4) - 4;
                break;
            case 2:
                System.out.println("Nivel Intermedio");
                fil = 7;
                col = 7;
                minas = 8;
                gan = (6 * 6) - 8;
                break;
            case 3:
                System.out.println("Nivel Avanzado");
                fil = 9;
                col = 9;
                minas = 12;
                gan = (8 * 8) - 12;
                break;
            case 4:
                ocaso = true;
                System.exit(0);
                break;
            default:
                System.out.println("Ingrese un valor permitido, error: "+error);
                finalito=true;
                break;
        }
        }
    }

    
    public static void eltablero(int length, int length0, char[][] matriz) {
       
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length0; j++) {
                System.out.printf("%s", "[" + matriz[i][j] + "]");
            }
         
            System.out.println("");
        }
    }

   
    public static int randnumeros(int sup) {
        Random rnd = new Random();
        int num = (int) (Math.random() * sup);
        return num;
    }

   
    public static void tab() {
        for (int l = 1; l < fil; l++) {
            for (int m = 1; m < col; m++) {
                m2[l][m] = 'X';
            }
        }
        for (int l = 1; l < fil; l++) {
            for (int m = 1; m < col; m++) {
                m1[l][m] = 'X';
            }
        }
    }

    
    public static void minasfeas() {
        boolean full = false;
        int i = 0;
        out:
        while (i <= minas) {
            for (int j = 1; j < fil; j++) {
                for (int k = 1; k < col; k++) {
                    int mina = randnumeros(col);
                    if ((k == mina) && (m1[j][k] == 'X') && (j != a && k != b)) {
                        m1[j][k] = '*';
                        ++i;
                        if (i == minas) {
                            break out;
                        }
                    }
                }
            }
        }
    }

  

   
    public static void usuario() {
       
        
        Scanner sc = new Scanner(System.in);
        Scanner x = new Scanner(System.in);
        Scanner pri = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
           
            System.out.println("Voltear (V) ");
            System.out.println("Reiniciar (R) ");
            System.out.println("Salir (S) ");
            try{
                System.out.println("\nIngrese fila y columana separado por coma ");
                String entrada = sc.nextLine();
                String s[] = entrada.split(",");
                a = Integer.parseInt(s[0]);
                b = Integer.parseInt(s[1]);
                
            }catch(Exception e){
                System.out.println("Ingrese un dato valido");
            }
            System.out.println("Ingrese opción, (Y) para sí y (N) para no: ");
            String ele = x.nextLine();
            System.out.println("");

            if ((ele.equals("Y") || ele.equals("y"))) {
                if((a < fil && b < col) && (a > 0 && b > 0)){
                    valid = true;
                }else{
                    System.out.print("¡¡ERROR!!");
                    valid = false;
                }
            }else{
                if ((ele.equals("N") || ele.equals("n"))){
                    valid = false;    
                }else{ 
                    if (ele.equals("S") || ele.equals("s")){
                        valid = true;
                        finalito = true;
                    }else{
                        if(ele.equalsIgnoreCase("r")){
                            valid=true;
                            reiniciar=true;
                        }else{
                            System.out.println("Instruccion no reconocida, ingresa un caracter valido");
                        }
                    }
                }
            }
        }
    }

   
    

  
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s="";
        while(true){
            System.out.println("Pablo Rodrigo Barillas Calderón");
            System.out.println("201602503");
            System.out.println("IPC1 (A) Práctica 1");
            System.out.println("Buscaminas");
            System.out.println("Presione enter para iniciar...");
            s = sc.nextLine();
            break;
        }
        
        while (!ocaso) {
            conta = 0;
            finalito = false;
            menú2();
            tab();
            eltablero(fil, col, m2);
            System.out.println("");
            usuario();
            minasfeas();
            while (!finalito) {
                if (pr) {
                    eltablero(fil, col, m1);
                    System.out.println("");
                }
                if(reiniciar){
                    tab();
                    reiniciar=false;
                }
                eltablero(fil, col, m2);
                System.out.println("");
                usuario();
            }
        }

    }
}