package test;

import java.util.Scanner;

public class ExerciseEight {

	public void insertar(Scanner scanner) {
		ListaDoble lista = new ListaDoble();
		int x = 1;
		do {
			if(x==1) {
				lista.agregarInicio("Persona " + x);
			} else {
				lista.agregarFinal("Persona "+x);
			}
			x++;
			System.out.println("¿Desea ingresar una persona a la fila? Y/N");
		} while (scanner.next().toUpperCase().equals("Y"));
		System.out.println("Ingrese posición en la que desea colar a la persona en la fila");
		lista.meterPersona(scanner.nextInt());
		lista.mostarListaInicioFin();
	}
}

class NodoDoble {
	public String dato;
	NodoDoble siguiente, anterior;
	
	public NodoDoble(String elemento, NodoDoble siguiente, NodoDoble anterior) {
		this.dato=elemento;
		this.siguiente = siguiente;
		this.anterior = anterior;
	}
	
	public NodoDoble(String elemento) {
		this(elemento, null, null);
	}
}

class ListaDoble {
	private NodoDoble inicio, fin;
	
	public ListaDoble() {
		inicio=fin=null;
	}
	
	public boolean listaVacia() {
		return inicio==null;
	}
	
	public int contarElementos() {
		NodoDoble aux=inicio;
		int contador = 0;
		while(aux!=null) {
			contador++;
			aux = aux.siguiente;
		}
		return contador;
	}
	
	public void agregarFinal(String elemento) {
		if(!listaVacia())
		{
			fin = new NodoDoble(elemento, null, fin);
			fin.anterior.siguiente=fin;
		} else {
			inicio = fin = new NodoDoble(elemento);
		}
	}
	
	public void agregarInicio(String elemento) {
		if(!listaVacia())
		{
			inicio = new NodoDoble(elemento, inicio, null);
			inicio.siguiente.anterior=inicio;
		} else {
			inicio = fin = new NodoDoble(elemento);
		}
	}
	
	public void mostarListaInicioFin() {
		if(!listaVacia()) {
			String datos = "<=>";
			NodoDoble aux=inicio;
			while(aux!=null) {
				datos+="["+aux.dato+"]<=>";
				aux = aux.siguiente;
			}
			System.out.println(datos);
		}
	}
	
	public void mostarListaFinInicio() {
		if(!listaVacia()) {
			String datos = "<=>";
			NodoDoble aux=fin;
			while(aux!=null) {
				datos+="["+aux.dato+"]<=>";
				aux = aux.anterior;
			}
			System.out.println(datos);
		}
	}
	
	public void meterPersona(int posicion) {
		System.out.println(contarElementos());
		if(!listaVacia() && posicion <= contarElementos()) {
			NodoDoble aux=inicio, anterior=null, siguiente=null;
			for (int i = 0; i < posicion-2; i++) {
				aux = aux.siguiente;				
			}
			siguiente = aux.siguiente;
			anterior = aux;
			aux.siguiente = new NodoDoble("Persona metida", null , null);
			aux.siguiente.siguiente = siguiente;
		} else {
			agregarFinal("Persona metida");
		}
	}
}
