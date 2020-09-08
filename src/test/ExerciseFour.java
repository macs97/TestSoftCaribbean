package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExerciseFour {

	public void readFile(Scanner scanner) {
		String routeFile = "files/numbers.txt";
		try {
			File file = new File(routeFile);
			scanner = new Scanner(file);
			String data = null;
			double suma = 0;
			while (scanner.hasNextLine()) {
				data = scanner.nextLine();
			}
			String[] numb = data.split(",");
			for (int i = 0; i < numb.length; i++) {
				double n = Double.parseDouble(numb[i]);
				if(n%2==0 || isPrime(n)) {
					suma+=n;
				}
			}
			System.out.println("La suma de los números primos es :" + suma);
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private boolean isPrime(double number) {
		int contador=0;
		for (double i = number; i > 0; i--) {
			if(number%i == 0) {
				contador++;
			}
		}
		if(contador == 2) {
			return true;
		}
		return false;
	}
}
