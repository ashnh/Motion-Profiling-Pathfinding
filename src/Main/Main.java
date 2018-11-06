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
		
		
		double time = 0D;
		double currentVelocity = 0D;
		while (drive.getLeft().getEncoderState() > -200D && time < vt.getExpectedTime()) {
			
			double error = vt.getError(currentVelocity, time);
			error = (error > 1D) ? 1D : error;
			error = (error < -1D) ? -1D : error;
			
			currentVelocity += (vt.getExpectedVelocity(time) 
					* vt.getError(currentVelocity, time));
			
			if (Math.abs(currentVelocity) > vt.getMaxSpeed())
				currentVelocity = (Math.abs(currentVelocity) / currentVelocity) ;
			
			drive.getLeft().setPower(currentVelocity / 12);
			
			System.out.println("Distance: " + drive.getLeft().getEncoderState() 
					+ "\tError: " + error + "\ttime: " + time);
			time++; 
			
		}
		
	}

}
