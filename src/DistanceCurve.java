
public class DistanceCurve extends MotionProfile {
	
	private double accelerationDistance;

	public DistanceCurve(VelocityTrapezoid vc) {
		
		super (vc.getMaxSpeed(), vc.getAccelerationConstant(), vc.getDistance());
		
		accelerationDistance = 0.5 * acceleration * timeToAccelerate;
		
	}
	
	public DistanceCurve (double _maxSpeed, double _acceleration, double _distance) {
		
		super (_maxSpeed, _acceleration, _distance);
		
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
				
				//delta x = acclerationDistance + (V * (expectedTime - 2timeToAccelerate)) + (maxSpeed(t) - .5at^2)
				expectedDistance = accelerationDistance + 
						(maxSpeed * (expectedTime - (2*timeToAccelerate))) + 
						((maxSpeed * time) - (0.5 * acceleration * Math.pow(time, 2D)));
				
			}
			
		}
		
		return (currentDistance - expectedDistance) / expectedDistance;
		
	}

	public double getAccelerationDistance () {
		return accelerationDistance;
	}
	
}
