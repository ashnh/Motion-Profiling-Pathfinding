
public class VelocityTrapezoid {

	private double maxSpeed;
	private double accelerationSlope;
	private double distance;
	private double accelerationTime;
	private double expectedTime;
	
	public VelocityTrapezoid(double _maxSpeed, double _accelerationSlope, double _distance) {
		
		maxSpeed = _maxSpeed;
		accelerationSlope = _accelerationSlope;
		accelerationTime = maxSpeed / accelerationSlope;
		distance = _distance;
		expectedTime = ((distance - (accelerationSlope * Math.pow(accelerationTime, 2))) / maxSpeed) + (2* accelerationTime);
		
		// Dm = D - 2De
		// De = .5 * a(te^2)
		// Dm = D - 2(.5 * a(te^2))
		// Dm = Vm * tm
		// Vm * tm = D - a(te^2)
		// tm = (D - a(te^2)) / Vm
		// total time = tm + 2te
		
		
		// total time = (D - a(te^2)) / Vm + 2te
		
	}
	
	public VelocityTrapezoid (double _distance) {
		
		maxSpeed = 1D; // d / t
		accelerationSlope = .1D; // d / t^2
		accelerationTime = 10D; // t
		distance = _distance; // d
		
	}
	
	
	public double getError ( double currentDistance, double time) {
		
		if (time == 0d)
			return -131D;
		
		double currentVelocity = currentDistance / time;
		
		double expectedVelocity = 0D;
		
		if (currentDistance < distance - (accelerationTime * maxSpeed))
			expectedVelocity = accelerationSlope * time;
		 else 
			expectedVelocity = (expectedTime - time) * accelerationSlope;
		
		expectedVelocity = (expectedVelocity > maxSpeed) ? maxSpeed : expectedVelocity;
		
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
