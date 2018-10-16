
public class Drive {

	Motor left;
	Motor right;
	
	public Drive() {
		
		left = new Motor();
		right = new Motor();
		
	}
	
	public void setSpeed (double leftSpeed, double rightSpeed) {
		
		left.setPower(leftSpeed);
		right.setPower(rightSpeed);
		
	}
	
	public Motor getLeft () {
		
		return left;
		
	}
	
	public Motor getRight () {
		return right;
	}

}
