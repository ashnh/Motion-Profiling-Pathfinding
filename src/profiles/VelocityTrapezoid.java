package profiles;

public class VelocityTrapezoid extends MotionProfile {
	
	public VelocityTrapezoid(double _maxSpeed, double _acceleration, double _distance) {
		
		super (_maxSpeed, _acceleration, _distance);
		
		
	}
	
	public double getError (double currentVelocity, double time) {
		
		double expectedVelocity = getExpectedVelocity (time);
		
		if (expectedVelocity == 0D)
			return 0D;
		
		return (currentVelocity - expectedVelocity) / expectedVelocity;
		
	}
	
	public double getExpectedVelocity (double time) {

		if (time == 0D)
			return 0D;
		
		double expectedVelocity;
		
		if (time < expectedTime - timeToAccelerate) {
			
			if (time < timeToAccelerate)
				expectedVelocity = acceleration * time;
			else
				expectedVelocity = maxSpeed;
			
		}else 
			expectedVelocity = (expectedTime - time) * acceleration;
		return expectedVelocity;
	}
}
