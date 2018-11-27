package Main;
import drive.Drive;
import drive.Motor;
import profiles.DistanceCurve;
import profiles.VelocityTrapezoid;

public class Main {

	public static void main(String[] args) {
		
		Drive drive = new Drive ();
		
		// maxSpeed, acceleration, total distance
		VelocityTrapezoid vt = new VelocityTrapezoid (12D, 0.1D, 100D);
		DistanceCurve dc = new DistanceCurve (vt);
		
		// currentVelocity, time
		//System.out.println(vt.getError(0D, 110D));
		
		// leftSide distance, rightSide distance
		//System.out.println (MotorSync.getDistanceError(100D, 90D));
		
		// currentDistance, time
		
		
		
	}

}
