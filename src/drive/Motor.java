package drive;

public class Motor {

	public static final double Inches_Per_Second_Of_Full_Power = 12; 

	private double encoderState;
	
	public Motor() {
		
		encoderState = 0D;
		
	}
	
	
	public void setPower (double power) {
		
		encoderState += (power * Inches_Per_Second_Of_Full_Power);
		
	}
	
	public double getEncoderState () {
		return encoderState;
	}

}
