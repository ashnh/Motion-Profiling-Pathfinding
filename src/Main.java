
public class Main {

	public static final double Inches_Per_Second_Of_Power = 12; 

	public static void main(String[] args) {
		
		Drive drive = new Drive ();
		
		// maxSpeed, acceleration, total distance
		VelocityTrapezoid vt = new VelocityTrapezoid (1D, 0.1D, 100D);
		DistanceCurve dc = new DistanceCurve (vt);
		
		// currentVelocity, time
		//System.out.println(vt.getError(0D, 110D));
		
		// leftSide distance, rightSide distance
		//System.out.println (MotorSync.getDistanceError(100D, 90D));
		
		// currentDistance, time
		System.out.println(dc.getError( 15D, 20D));
		
	}

}
