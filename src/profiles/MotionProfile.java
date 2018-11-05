package profiles;

public abstract class MotionProfile {

	protected double maxSpeed;
	protected double acceleration;
	protected double distance;
	protected double timeToAccelerate;
	protected double expectedTime;
	
	public MotionProfile(double _maxSpeed, double _acceleration, double _distance) {
		
		maxSpeed = _maxSpeed;
		acceleration = _acceleration;
		distance = _distance;
		timeToAccelerate = maxSpeed / acceleration;
		expectedTime = ((distance - (acceleration * Math.pow(timeToAccelerate, 2))) / maxSpeed) + (2* timeToAccelerate);
		// Dm = D - 2De
		// De = .5 * a(te^2)
		// Dm = D - 2(.5 * a(te^2))
		// Dm = Vm * tm
		// Vm * tm = D - a(te^2)
		// tm = (D - a(te^2)) / Vm
		// total time = tm + 2te
		
		
		// total time = (D - a(te^2)) / Vm + 2te
		
	}
	
	public double getMaxSpeed () {
		return maxSpeed;
	}

	public double getAccelerationConstant () {
		return acceleration;
	}
	
	public double getDistance () {
		return distance;
	}
	
	public double getTimeToAccelerate () {
		return timeToAccelerate;
	}
	
	public double getExpectedTime () {
		return expectedTime;
	}

}
