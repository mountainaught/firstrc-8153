package T4P8153.EveBot22;

public class Functions {
	private Functions() {}
	
    public static double Deadband(double value) {
		/* Upper deadband */
		if (value >= +0.05) 
			return value;
		
		/* Lower deadband */
		if (value <= -0.05)
			return value;
		
		/* Outside deadband */
		return 0;
	}


}
