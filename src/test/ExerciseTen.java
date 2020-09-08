package test;

public class ExerciseTen {

	public void token() {
        String cadena = "sdffsd{hOLa} jyfljyf {cOmo} dfdf {esTAs} fdfsf";
        String arreglo[] = null;
        if(cadena.contains("{")) {
            arreglo = cadena.substring(cadena.indexOf("{")).split("\\{");
        }
        
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] != null && !arreglo[i].isEmpty()) {
                if(arreglo[i].contains("{")) {
                    arreglo[i] = arreglo[i].split("\\{")[1];
                }
                if(arreglo[i].contains("}")) {
                    arreglo[i] = arreglo[i].split("\\}")[0];
                }
                arreglo[i] = arreglo[i].substring(0,1).toUpperCase() + arreglo[i].substring(1).toLowerCase();
                System.out.println(arreglo[i]);
            }
            
        }
            
    }
}
