
public class DistanceCurve extends MotionProfile {
	
	private double accelerationDistance;
	private double coastingDistance;

	public DistanceCurve(VelocityTrapezoid vc) {
		
		super (vc.getMaxSpeed(), vc.getAccelerationConstant(), vc.getDistance());
		
		distanceValues();
		
	}
	
	public DistanceCurve (double _maxSpeed, double _acceleration, double _distance) {
		
		super (_maxSpeed, _acceleration, _distance);
		
		distanceValues();
		
	}
	
	private void distanceValues() {
		accelerationDistance = 0.5 * acceleration * Math.pow(timeToAccelerate, 2D);
		coastingDistance = maxSpeed * (expectedTime - (2*timeToAccelerate));
	}
	
	// current distance, time
	public double getError (double currentDistance, double time) {
		
		if (time == 0D)
			return -131D;
		
		double expectedDistance;
		
		if (time < timeToAccelerate) {
			
			// delta x = (V initial)t + .5at^2 = .5at^2
			expectedDistance = 0.5 * acceleration * (Math.pow(time, 2D));
			
		} else {
			
			if (time < expectedTime - timeToAccelerate) {
				
				// delta x = accelerationDistance + V(t - timeToAccelerate)
				expectedDistance =  accelerationDistance + (maxSpeed * (time - timeToAccelerate));
				
			} else {
				double deccelerationTime = (time - (expectedTime - timeToAccelerate));
				//delta x = acclerationDistance + (V * (expectedTime - 2timeToAccelerate)) + (maxSpeed(t) - .5at^2)
				expectedDistance = 	accelerationDistance + 
									coastingDistance + 
									((maxSpeed * deccelerationTime) -
									(0.5 * acceleration * Math.pow(deccelerationTime, 2D)));
				
			}
			
		}
		return (currentDistance - expectedDistance) / expectedDistance;
		
	}

	public double getAccelerationDistance () {
		return accelerationDistance;
	}
	
}
