package profiles;

public class VelocityTrapezoid extends MotionProfile {
	
	private double preDeccelerationValue;
	
	public VelocityTrapezoid(double _maxSpeed, double _acceleration, double _distance) {
		
		super (_maxSpeed, _acceleration, _distance);
		
		preDeccelerationValue = 0D;
		
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
			
			preDeccelerationValue = expectedVelocity;
			
		} else {
			expectedVelocity = preDeccelerationValue
					- ((time - expectedTime + timeToAccelerate) * acceleration);
		}
		
		return expectedVelocity;
	}
}
