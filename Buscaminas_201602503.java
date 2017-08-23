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
    public static boolean mostratodo = false;
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
        System.out.println("\n¡¡¡BUSCAMINAS!!!");
        System.out.println("1. Principiante");
        System.out.println("2. Intermedio");
        System.out.println("3. Avanzado");
        System.out.println("4. Salir");
        System.out.println("");
        System.out.print("Ingrese su elección: ");
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
    
    public static void eltablero(int l, int an, char[][] matriz) {
       
        for (int i = 1; i < l; i++) {
            for (int po = 1; po < an; po++) {
                System.out.printf("%s", "[" + matriz[i][po] + "]");
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
            for (int po = 1; po < fil; po++) {
                for (int k = 1; k < col; k++) {
                    int mina = randnumeros(col);
                    if ((k == mina) && (m1[po][k] == 'X') && (po != a && k != b)) {
                        m1[po][k] = '*';
                        ++i;
                        if (i == minas) {
                            break out;
                        }
                    }
                }
            }
        }
    }

  
    public static void min() {
        int count = 0;
        for (int n = 2; n <= m1.length - 2; ++n) {
            for (int o = 2; o <= m1[0].length - 2; ++o) {
                count = 0;
                if ((m1[n + 1][o + 1] == '*') && (m1[n][o] == 'X')) {
                    ++count;
                }
                if ((m1[n - 1][o - 1] == '*') && (m1[n][o] == 'X')) {
                    ++count;
                }
                if ((m1[n - 1][o + 1] == '*') && (m1[n][o] == 'X')) {
                    ++count;
                }
                if ((m1[n + 1][o - 1] == '*') && (m1[n][o] == 'X')) {
                    ++count;
                }
                if ((m1[n - 1][o] == '*') && (m1[n][o] == 'X')) {
                    ++count;
                }
                if ((m1[n + 1][o] == '*') && (m1[n][o] == 'X')) {
                    ++count;
                }
                if ((m1[n][o + 1] == '*') && (m1[n][o] == 'X')) {
                    ++count;
                }
                if ((m1[n][o - 1] == '*') && (m1[n][o] == 'X')) {
                    ++count;
                }
                if (m1[n][o] == 'X') {
                    if (count > 0) {
                        m1[n][o] = Integer.toString(count).charAt(0);
                    } else if (count == 0) {
                        m1[n][o] = Integer.toString(count).charAt(0);
                    }
                }
            }
        }
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                if (m1[i][j] == 'X') {
                    m1[i][j] = Integer.toString(0).charAt(0);
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
           
            System.out.println("-------------------------");
            System.out.println("\nVoltear (V) ");
            System.out.println("Reiniciar (R) ");
            System.out.println("Salir (S) ");
            System.out.println("");
            System.out.print("Escoga su opción: ");
            String simon = pri.nextLine();
            
        if(simon.equalsIgnoreCase("v")){    
            try{
                System.out.println("-------------------------");
                System.out.print("\nIngrese fila y columana separado por coma: ");
                String entrada = sc.nextLine();
                String s[] = entrada.split(",");
                a = Integer.parseInt(s[0]);
                b = Integer.parseInt(s[1]);
                
            }catch(Exception e){
                System.out.println("Ingrese un dato válido");
            }
            System.out.print("¿Está seguro?, ingrese (Y) para sí y (N) para no: ");
            String ele = x.nextLine();
            System.out.println("");

            if ((ele.equals("Y") || ele.equals("y"))) {
                if((a < fil && b < col) && (a > 0 && b > 0)){
                    valid = true;
                }else{
                    System.out.println("¡¡ERROR!!");
                    System.out.println("¡Ingresa una fila y columna dentro del rango del tamaño elegido!");
                    valid = false;
                }
            }else{
                if ((ele.equals("N") || ele.equals("n"))){
                    valid = false;    
                }    
            }    
        }    
            
            
                
                
                
                
        else if (simon.equals("S") || simon.equals("s")){
                        valid = true;
                        finalito = true;
           }
        else if(simon.equalsIgnoreCase("r")){
                            valid=true;
                            reiniciar=true;
                         
                        }else{
                            System.out.println("Instrucción no reconocida, ingresa un caracter válido");
                        }     
        }
    }

   
    public static void destapar(int c1, int c2) {
        boolean valid = false;
        Scanner io = new Scanner(System.in);
        int cas1 = a;
        int cas2 = b;
        if (c1 > fil - 1 || c1 < 0 || c2 > col - 1 || c2 < 0) {
            return;
        }
        if (m1[cas1][cas2] == '*') {
            
            System.out.println("¡ENCONTRASTE UNA MINA!, ¡¡¡PERDISTE!!! JAJA");
            System.out.println("¡Estas eran las posiciones:");
            System.out.println("");
            eltablero(fil,col,m1);
            System.out.print("\nPero... ¿desea reiniciar?, (Y) para sí y (N) para no: ");
            String re = io.nextLine();
            if(re.equalsIgnoreCase("y")){
                System.out.println("");
                valid=true;
               reiniciar=true;
                }
            else if (re.equals("N") || re.equals("n")){
                System.out.println("");
                valid=true;
                finalito = true;
                }
        } else if (m1[c1][c2] == '0') {
            if (m2[c1][c2] != m1[c1][c2]) {
                m2[c1][c2] = m1[c1][c2];
                ++conta;
                destapar(c1 + 1, c2);
                destapar(c1, c2 + 1);
                destapar(c1 + 1, c2 + 1);
            }
            if (c1 > fil - 1 || c1 < 0 || c2 > col - 1 || c2 < 0) {
                destapar(c1, c2 - 1);
                destapar(c1 - 1, c2);
                destapar(c1 - 1, c2 - 1);
                destapar(c1 - 1, c2 + 1);
                destapar(c1 + 1, c2 - 1);
            }
        } else if ((m1[c1][c2] > '0')) {
            if (m2[c1][c2] != m1[c1][c2]) {
                m2[c1][c2] = m1[c1][c2];
                ++conta;
            }
        }
        if (conta == gan) {
            System.out.println("VICTORIA, ¡FELICITACIONES GANASTE!");
            finalito = true;
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
            System.out.println("");
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
            min();
            destapar(a, b);
            while (!finalito) {
                if (pr) {
                    eltablero(fil, col, m1);
                    System.out.println("");
                }
                if(reiniciar){
                    tab();
                    minasfeas();
                    min();
                    System.out.println("");
                    reiniciar=false;
                }
                if (mostratodo){
                    eltablero(fil, col, m2);
                    
                    mostratodo=false;
                }
                eltablero(fil, col, m2);
                System.out.println("");
                usuario();
                destapar(a, b);
            }
        }

    }                                   
     
}