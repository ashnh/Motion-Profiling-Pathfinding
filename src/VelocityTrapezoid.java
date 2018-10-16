
public class VelocityTrapezoid {

	private double maxSpeed;
	private double accelerationSlope;
	private double distance;
	private double accelerationTime;
	
	public VelocityTrapezoid(double _maxSpeed, double _accelerationSlope, double _distance) {
		
		maxSpeed = _maxSpeed;
		accelerationSlope = _accelerationSlope;
		accelerationTime = maxSpeed / accelerationSlope;
		distance = _distance;
		
		// d = .5at^2 + 
		// 100 = 5
		
	}
	
	public VelocityTrapezoid (double _distance) {
		
		maxSpeed = 1D; // d / t
		accelerationSlope = .1D; // d / t^2
		accelerationTime = 10D; // t
		distance = _distance; // d
		
	}
	
	
	public double getError (double currentPower, double currentDistance, double encoderState, double time) {
		
		double currentVelocity = encoderState / time;
		
		double expectedVelocity = 0D;
		
		if (currentDistance < distance - (accelerationTime * maxSpeed)) {
			expectedVelocity = accelerationSlope * time;
			expectedVelocity = (expectedVelocity > maxSpeed) ? maxSpeed : expectedVelocity;
		} else {
			
			//aaaaaaaaaaaaaAAAAAAAAAAAAAGGGGGGGGGGGGGGGGGGGGGGGGGGGHHHHHHHHHHHHHHHHHHHHHH
			
		}
		
		return (currentVelocity - expectedVelocity) / expectedVelocity;
		
	}
	
	public double getMaxSpeed () {
		return maxSpeed;
	}

	public double getAccelerationSlope () {
		return accelerationSlope;
	}
	
	public double getDistance () {
		return distance;
	}
}
