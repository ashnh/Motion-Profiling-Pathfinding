
public class Main {

	public static final double Inches_Per_Second_Of_Power = 12; 

	public static void main(String[] args) {
		
		Drive drive = new Drive ();
		
		// maxSpeed, acceleration, total distance
		VelocityTrapezoid vt = new VelocityTrapezoid (1D, 0.1D, 100D);
		
		// currentDistance, time
		System.out.println(vt.getError( 6.4D, 8D));
		
	}

}
