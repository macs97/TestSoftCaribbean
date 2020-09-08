package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

public class ExerciseSeven {

	Stack<Object> pila = new Stack<Object>();
	
	public void apilar(Scanner scanner) {
		int id = 1;
		do {
			System.out.println("Ingrese nombre del producto");
			String nameProduct = scanner.next();
			System.out.println("Ingrese descripcion del producto");
			String descriptionProduct = scanner.next();
			pila.push(new Venta(id, formatDate(new Date()), nameProduct, descriptionProduct));
			id++;
			System.out.println("¿Desea ingresar una venta? Y/N");
			
		} while (scanner.next().toUpperCase().equals("Y"));
		imprimir();
	}
	
	private void imprimir() {
		while (!pila.empty()) {
			Object item = pila.pop();
			System.out.println(item);
		}
	}
	
	private String formatDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		return formatter.format(date);
	}
}
