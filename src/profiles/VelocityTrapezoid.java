package profiles;

public class VelocityTrapezoid extends MotionProfile {
	
	public VelocityTrapezoid(double _maxSpeed, double _acceleration, double _distance) {
		
		super (_maxSpeed, _acceleration, _distance);
		
		
	}
	
	public double getError (double currentVelocity, double time) {
		
		if (time == 0D)
			return -131D;
		
		double expectedVelocity = 0D;
		
		if (time < expectedTime - timeToAccelerate) {
			
			if (time < timeToAccelerate)
				expectedVelocity = acceleration * time;
			else
				expectedVelocity = maxSpeed;
			
		}else 
			expectedVelocity = (expectedTime - time) * acceleration;
		
		return (currentVelocity - expectedVelocity) / expectedVelocity;
		
	}
}
