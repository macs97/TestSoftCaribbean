package test;

import java.util.Scanner;

public class ExerciseNine {

	public void arbol(Scanner scanner) {
		BinarySearchTree<Integer> arbol = new BinarySearchTree<>();
		do {
			System.out.println("Ingrese un numero entero para el arbol");
			arbol.add(scanner.nextInt());
			System.out.println("¿Desea ingresar un nuevo número? Y/N");
		} while (scanner.next().toUpperCase().equals("Y"));
		
		
		System.out.println("El número de nodos es: " + arbol.contarNodos(arbol.getRoot()));
	}
	
	class BinarySearchTree<T extends Comparable<T>> {
		private Nodo<T> root;
		
		
		public boolean isEmpty() {
			return root == null;
		}
		
		public Nodo<T> getRoot() {
			return root;
		}
		
		public boolean isRoot(Nodo<T> nodo) {
			return root == nodo;
		}
		
		public boolean isLeaf(Nodo<T> nodo) {
			return nodo.getLeft() == null && nodo.getRight() == null;
		}
		
		public boolean isInternal(Nodo<T> nodo) {
			return !isLeaf(nodo);
		}
		
		public Nodo<T> add(Nodo<T> origen, T elemento) {
			Nodo<T> nodo = null;
			if (root == null) {
				root = new Nodo<>(elemento);
			} else if(origen == null) {
				System.out.println("El origen es nulo");
			} else {
				if(origen.getElement().compareTo(elemento) > 0) {
					if(origen.getLeft() != null) {
						add(origen.getLeft(), elemento);
					} else {
						nodo = new Nodo<>(elemento);
						nodo.setParent(origen);
						origen.setLeft(nodo);
					}
				} else {
					if(origen.getRight() != null) {
						add(origen.getRight(), elemento);
					} else {
						nodo = new Nodo<>(elemento);
						nodo.setParent(origen);
						origen.setRight(nodo);
					}
				}
			}
			return nodo;
		}
		
		public Nodo<T> add(T elemento) {

			Nodo<T> nodo = null;
	        if (root == null) {
	            nodo = new Nodo<>(elemento);
	            root = nodo;
	        } else {

	        	Nodo<T> aux = root;
	            boolean insertado = false;
	            while (!insertado) {

	                if (aux.getElement().compareTo(elemento) > 0) {

	                    if (aux.getLeft() != null) {
	                        aux = aux.getLeft();
	                    } else {
	                        nodo = new Nodo<>(elemento);
	                        nodo.setParent(aux);
	                        aux.setLeft(nodo);
	                        insertado = true;
	                    }

	                } else {

	                    if (aux.getRight() != null) {
	                        aux = aux.getRight();
	                    } else {
	                        nodo = new Nodo<>(elemento);
	                        nodo.setParent(aux);
	                        aux.setRight(nodo);
	                        insertado = true;
	                    }

	                }

	            }

	        }
	        return nodo;
	    }
	
		public int contarNodos(Nodo<Integer> nodo) {
			int contador = 1;
			
			if(nodo.getLeft() != null) {
				contador += contarNodos(nodo.getLeft());
			}
			
			if(nodo.getRight() != null) {
				contador += contarNodos(nodo.getRight());
			}
			return contador;
		}
	}
	
	class Nodo<T> {
		private T element;
		private Nodo<T> parent;
		private Nodo<T> left;
		private Nodo<T> right;
		
		public Nodo(T element) {
			this.element = element;
		}
		
		public Nodo(T element, Nodo<T> left, Nodo<T> right) {
			super();
			this.element = element;
			this.left = left;
			this.right = right;
		}



		public Nodo(T element, Nodo<T> parent) {
			super();
			this.element = element;
			this.parent = parent;
		}



		public Nodo(T element, Nodo<T> parent, Nodo<T> left, Nodo<T> right) {
			super();
			this.element = element;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}



		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public Nodo<T> getParent() {
			return parent;
		}

		public void setParent(Nodo<T> parent) {
			this.parent = parent;
		}

		public Nodo<T> getLeft() {
			return left;
		}

		public void setLeft(Nodo<T> left) {
			this.left = left;
		}

		public Nodo<T> getRight() {
			return right;
		}

		public void setRight(Nodo<T> right) {
			this.right = right;
		}
		
	}
}




