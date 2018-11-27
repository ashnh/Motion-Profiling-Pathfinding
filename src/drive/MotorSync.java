package drive;

public class MotorSync {

	public MotorSync() {
		
		
		
	}
	
	public static double getDistanceError (double leftSide, double leftExpected, double rightSide, double rightExpected) {
		
		return (rightSide - rightExpected - leftSide + leftExpected) / (rightSide - rightExpected);
		
	}

}
