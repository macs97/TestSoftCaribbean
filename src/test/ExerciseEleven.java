package test;

import java.util.Stack;

public class ExerciseEleven {

	private static final String OPERADOR = "^+-*/";

	public void evalPostFija() {
		String expr = ordenar("4*2-2/4*67^2");
		String[] arrayInFija = expr.split(" ");

		Stack<String> entrada = new Stack<String>();
		Stack<String> operadores = new Stack<String>();
		Stack<String> salida = new Stack<String>();

		for (int i = arrayInFija.length - 1; i >= 0; i--) {
			entrada.push(arrayInFija[i]);
		}

		int jerarquia = 0;
		int jerarquiaOperador = 0;

		while (!entrada.isEmpty()) {

			if (!operadores.isEmpty()) {

				jerarquia = jerarquia(entrada.peek());
				jerarquiaOperador = jerarquia(operadores.peek());

				if (jerarquia < jerarquiaOperador) {

					if (OPERADOR.contains(entrada.peek())) {
						while (!operadores.isEmpty()) {
							salida.push(operadores.pop());
						}
						operadores.push(entrada.pop());
					} else {
						salida.push(entrada.pop());
					}

				} else if (jerarquia == jerarquiaOperador) {

					salida.push(operadores.pop());
					operadores.push(entrada.pop());

				} else {
					operadores.push(entrada.pop());
				}

			} else {
				if (OPERADOR.contains(entrada.peek())) {
					operadores.push(entrada.pop());
				} else {
					salida.push(entrada.pop());
				}
			}
		}

		while (!operadores.isEmpty()) {
			salida.push(operadores.pop());
		}

		calcular(salida);
	}

	private String ordenar(String expresion) {
		String expr = "";

		for (int i = 0; i < expresion.length(); i++) {
			if (OPERADOR.contains("" + expresion.charAt(i))) {
				expr += " " + expresion.charAt(i) + " ";
			} else
				expr += expresion.charAt(i);
		}
		return expr.replaceAll("\\s+", " ").trim();
	}

	private int jerarquia(String operador) {
		int jerarquia = 1000;
		if (operador.equals("^")) {
			jerarquia = 3;
		} else if (operador.equals("*") || operador.equals("/")) {
			jerarquia = 2;
		} else if (operador.equals("+") || operador.equals("-")) {
			jerarquia = 1;
		} else {
			jerarquia = 0;
		}
		return jerarquia;
	}

	private void calcular(Stack<String> salida) {

		Stack<String> salidaOrden = new Stack<String>();
		Stack<String> auxiliar = new Stack<String>();
		double resultado = 0, num1 = 0, num2 = 0;

		while (!salida.isEmpty()) {
			salidaOrden.push(salida.pop());
		}

		while (!salidaOrden.isEmpty()) {

			if (OPERADOR.contains(salidaOrden.peek())) {
				num2 = Double.parseDouble(auxiliar.pop());
				num1 = Double.parseDouble(auxiliar.pop());

				switch (salidaOrden.pop()) {
				case "^":
					resultado = Math.pow(num1, num2);
					break;

				case "/":
					if (num2 != 0) {
						resultado = num1 / num2;
					} else {
						throw new ArithmeticException();
					}

					break;
				case "*":
					resultado = num1 * num2;
					break;

				case "-":
					resultado = num1 - num2;
					break;

				case "+":
					resultado = num1 + num2;
					break;

				default:
					break;
				}
				auxiliar.push(String.valueOf(resultado));
			} else {
				auxiliar.push(salidaOrden.pop());

			}

		}
		System.out.println("El resultado de la operación es: " + auxiliar.peek());
	}
}
