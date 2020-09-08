package test;

import java.util.Scanner;
public class ExerciseFive {
    
    public void nDado(Scanner scanner) {
        System.out.print("Ingrese el valor de n: ");
        int n = scanner.nextInt();
        expresion(n, -1, -1);
    }
    
    public void terminoMenorQueE(Scanner scanner) {
        System.out.print("Ingrese el valor de n: ");
        int n = scanner.nextInt();
        System.out.print("Ingrese el valor de E: ");
        int e = scanner.nextInt();
        System.out.print("Ingrese el valor de x: ");
        int x = scanner.nextInt();
        expresion(n, e, x);
    }
    
    private void expresion(int n, int e, int x) {
        String ex = "Ex = ";
        for (int i = 0; i <= n; i++) {
            if(e != -1 && i != 0) {
                double m = Math.pow(x, i)/i;
                if (m >= e) {
                    break;
                }
            }
            if(i == 0) {
                ex += "1 ";
            } else if(i == 1) {
                ex += "+ x ";
            } else {
                ex += "+ (x^" + i + ") / " + i + "! ";
            }
        }
        System.out.println(ex);
    }
}
