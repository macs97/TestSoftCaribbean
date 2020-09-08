package test;

public class ExerciseTwo {

	private static final float FT_TO_FMT = 3.28084f;
	private static final float P_TO_MT = 39.37f;
	
	public double mtToFt(double mts) {
		return mts*FT_TO_FMT;
	}
	public double mtToP(double mts) {
		return mts*P_TO_MT;
	}
}
