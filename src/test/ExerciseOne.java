package test;


public class ExerciseOne {

	public void multiples(int n) {
		if(n>=4) {
			System.out.println("Multiplos de 4:");
			for(int i=4;i<=n;i++)
			{
				if(i%4==0) {
					System.out.println(i);
				}
			}
		}
	}
}
