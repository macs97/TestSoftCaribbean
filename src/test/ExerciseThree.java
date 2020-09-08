package test;

public class ExerciseThree {
	
    public void exethree() {
        double suma = 0;
        for (int i = 1; i <= 100; i++) {
            suma = suma + Math.pow(i, 2);
        }
        System.out.println("La suma de los 100 primeros números naturales es: " + suma);
    }
    
}
