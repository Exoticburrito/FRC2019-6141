package frc.robot.subsystems;

import frc.robot.commands.DriveCommand;
import frc.robot.robotMain.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

    private VictorSP leftOne;
    private VictorSP leftTwo;
    private VictorSP rightOne;
    private VictorSP rightTwo;

    public void initDefaultCommand() {
			
			setDefaultCommand(new DriveCommand());
				
    }

    public DriveTrain() {
			
		leftOne = new VictorSP(RobotMap.LEFT_MOTOR_ONE_PWM_PORT);
		leftTwo = new VictorSP(RobotMap.LEFT_MOTOR_TWO_PWM_PORT);
		
    	rightOne = new VictorSP(RobotMap.RIGHT_MOTOR_ONE_PWM_PORT);
		rightTwo = new VictorSP(RobotMap.RIGHT_MOTOR_TWO_PWM_PORT);
			
    }
    
    public void setSpeed(double leftSpeed, double rightSpeed) {
		//actual method that sets motor speeds.

    	leftOne.set(leftSpeed);
    	leftTwo.set(leftSpeed);
    	rightOne.set(rightSpeed);
		rightTwo.set(rightSpeed);
		
    }
    
    public void stopDT() {

    	leftOne.stopMotor();
    	leftTwo.stopMotor();
    	rightOne.stopMotor();
			rightTwo.stopMotor();
		
    }
    
    public void setInputSpeed(double speed, double turn) {
		//takes input turn, speed and processes to create a LSpeed and RSpeed.

    	double leftSpeed = -speed + turn;
		double rightSpeed = speed + turn;
		
			if (leftSpeed > 1.0) leftSpeed = 1.0;
			if (leftSpeed < -1.0) leftSpeed = -1.0;
			if (rightSpeed > 1.0) rightSpeed = 1.0;
			if (rightSpeed < -1.0) rightSpeed = -1.0;
		
			setSpeed(leftSpeed, rightSpeed);
			//then after processing calls setSpeed(). See above...
    }
    
    public void updateSD() {

    	SmartDashboard.putNumber("Drive LeftSpeed", leftOne.getSpeed());
		SmartDashboard.putNumber("Drive RightSpeed", rightOne.getSpeed());
		
    }
}

