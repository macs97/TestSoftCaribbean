package test;

import java.util.Scanner;

public class ExerciseSix {
	
	public void fibonacci(Scanner scanner) {
		System.out.print("Ingrese el valor de n: ");
		int n = scanner.nextInt();
		double a[] = new double[n+1];
		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		for (int i = 3; i <= n; i++) {
		    a[i] = a[i-1]+a[i-2];
		}
		System.out.println("El " + n + "-ésimo término de la serie de fibonacci es: " + a[n]);
	}
}






