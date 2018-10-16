
public class Motor {

	private double encoderState;
	
	public Motor() {
		
		encoderState = 0D;
		
	}
	
	
	public void setPower (double power) {
		
		encoderState += power;
		
	}
	
	public double getEncoderState () {
		return encoderState;
	}

}
