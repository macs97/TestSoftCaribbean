package test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		Scanner scanner = new Scanner(System.in);
		test.menu(scanner);
		
		scanner.close();
	}
	
	private void menu(Scanner scanner) {
		System.out.println("1. Calcular los múltiplos de 4 comprendidos entre 4 y N , donde N es un valor introducido por consola. \n"
				+ "2. Convertir metros a pies y a pulgadas (1 Metro = 39.37 pulgadas) \n"
				+ "3. Calcular la suma de los cuadrados de los 100 primeros números naturales. \n"
				+ "4. Leer un archivo que solo contiene números y sumar los números pares y primos. \n"
				+ "5. Calcular Ex=1+x+(x^2/2!)+(x^3/3!)+...+(x^n/n!) para N>0 \n"
				+ "\t a) Para N dado \n \t b) Hasta que N sea tal que (x^n/n)<E(por ejemplo, E=10^-4) \n"
				+ "6. Calcular el n-ésimo término de la seria de Fibonacci definida por: \n"
				+ "\tA1=1\tA2=2\tA3=1+2=A1+A2...An=An-1+An-2 (n>=3) \n"
				+ "7. Implemente una Pila que opere de manera LIFO(Last in, first out) para recibir simulación de transacciones de ventas.\n"
				+ "8. Teniendo una cola doblemente enlazada de personas haciendo la fila en un banco, permita adicionar una nueva persona que\n se mete de colada a la fila.\n"
				+ "9. Escriba un programa que recorra un árbol binario de números enteros y cuente cuantos nodos tiene.\n"
				+ "10. Teniendo una cadena con varias palabras claves entre corchetes {}, encuentra dichas\n palabras y retorne un Array con dichas palabras, colocando su primera letra en mayúscula.\n"
				+ "\t Las palabras claves son {CODIGO},{NOMBRE},{APELLIDO}. Tenga en cuenta que puedo agregar o quitar palabras claves a la cadena.\n"
				+ "11. Realizar la evaluación de una expresión matemática usando evaluación postfija. La expresión matemática es la entrada en forma de cadena, debe ser evaluada y retornar el resultado del cálculo. Recuerde que la evaluación postfija se resuelve con el uso de pilas.\n"
				+ "\tExpresión para evaluar: 4*2-2/4*67^2\n"
				+ "12. Teniendo un arreglo en una estructura Json, según muestra la figura. Calcule y muestre el total por ciudad para cada mes.\n"
				+ "0. Salir\n"
				+ "Seleccione ejercicio: ");
		String op = scanner.next();
		do {
			switch (op) {
			case "1":
				ExerciseOne one = new ExerciseOne();
				System.out.println("Ingrese N mayor o igual a 4");
				int n = scanner.nextInt();
				one.multiples(n);
				break;
			case "2":
				ExerciseTwo two = new ExerciseTwo();
				System.out.println("Ingrese valor en metros para convertir a pies y pulgadas");
				double mts = scanner.nextDouble();
				System.out.println("Valor en metros: " + mts + " valor en pies: " + two.mtToFt(mts));
				System.out.println("Valor en metros: " + mts + " valor en pulgadas: " + two.mtToP(mts));
				break;
			case "3":
				ExerciseThree three = new ExerciseThree();
				three.exethree();
				break;
			case "4":
				ExerciseFour four = new ExerciseFour();
				four.readFile(scanner);
				break;
			case "5":
				ExerciseFive five = new ExerciseFive();
				five.nDado(scanner);
				five.terminoMenorQueE(scanner);
				break;
			case "6":
				ExerciseSix six = new ExerciseSix();
				six.fibonacci(scanner);
				break;
			case "7":
				ExerciseSeven seven = new ExerciseSeven();
				seven.apilar(scanner);
				break;
			case "8":
				ExerciseEight eight = new ExerciseEight();
				eight.insertar(scanner);
				break;
			case "9":
				ExerciseNine nine = new ExerciseNine();
				nine.arbol(scanner);
				break;
			case "10":
				ExerciseTen ten = new ExerciseTen();
				ten.token();
				break;
			case "11":
				ExerciseEleven eleven = new ExerciseEleven();
				eleven.evalPostFija();
				break;
			case "12":
				ExerciseTwelve twelve = new ExerciseTwelve();
				twelve.readJson();
				break;
			case "0":
				
				break;
			default:
				System.err.println("Opción inválida");
				break;
			}
			System.out.println("**********************************************************");
			System.out.println("Digite número de ejercicio que desea ejecutar");
			op = scanner.next();
		} while (!op.equals("0"));
	}
	
	private void gaussJordan(Scanner scanner) {
		System.out.println("ingrese tamaño de la matriz");
		int n = scanner.nextInt();
		double matriz[][] = new double[n][n];
		double aumentada[] = new double[n];
		double c = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.println("Ingrese valor para la posición [" + i + "][" + j +"]");
				double number = scanner.nextDouble();
				matriz[i-1][j-1] = number;
			}
			System.out.println("Ingrese valor para la matriz aumentada en la posición [" + i + "]");
			double number = scanner.nextDouble();
			aumentada[i-1] = number;
		}

		for (int fila = 0; fila < n; fila++) {
			double pivote = matriz[fila][fila];
			for (int columna = 0; columna < n; columna++) {
				matriz[fila][columna] = (matriz[fila][columna]/pivote);
			}
			aumentada[fila] =(aumentada[fila]/pivote);
			
			for (int filaAux = 0; filaAux < n; filaAux++) {
				if(fila != filaAux) {
					c = matriz[filaAux][fila];
					for (int columnaAux = 0; columnaAux < n; columnaAux++) {
						matriz[filaAux][columnaAux] = matriz[filaAux][columnaAux] -c * matriz[fila][columnaAux];
					}
					aumentada[filaAux] = aumentada[filaAux] -c * aumentada[fila];
				}
				
			}
		}
		
		
		
		for(int i=0; i<n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println(aumentada[i]);
		}
	}

}
