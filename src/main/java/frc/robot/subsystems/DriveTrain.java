package frc.robot.subsystems;

import frc.robot.RampInputSpeed;
import frc.robot.commands.DriveCommand;
import frc.robot.robotMain.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class DriveTrain extends Subsystem {

    private VictorSP leftOne;
	private VictorSP leftTwo;
	private PWMVictorSPX leftThree;
    private VictorSP rightOne;
	private VictorSP rightTwo;
	private PWMVictorSPX rightThree;

	private RampInputSpeed leftRamp = new RampInputSpeed();
	private RampInputSpeed rightRamp = new RampInputSpeed();


    public void initDefaultCommand() {
			
			setDefaultCommand(new DriveCommand());
				
    }

    public DriveTrain() {
			
		leftOne = new VictorSP(RobotMap.LEFT_MOTOR_ONE_PWM_PORT);
		leftTwo = new VictorSP(RobotMap.LEFT_MOTOR_TWO_PWM_PORT);
		leftThree = new PWMVictorSPX(RobotMap.LEFT_MOTOR_TWO_PWM_PORT);

    	rightOne = new VictorSP(RobotMap.RIGHT_MOTOR_ONE_PWM_PORT);
		rightTwo = new VictorSP(RobotMap.RIGHT_MOTOR_TWO_PWM_PORT);
		rightThree = new PWMVictorSPX(RobotMap.LEFT_MOTOR_TWO_PWM_PORT);	

		leftRamp.setMaxCPS(0.07);
		rightRamp.setMaxCPS(0.07);
    }
    
    public void setSpeed(double leftSpeed, double rightSpeed) {
		//actual method that sets motor speeds.

    	leftOne.set(leftSpeed);
		leftTwo.set(leftSpeed);
		leftThree.set(leftSpeed);
    	rightOne.set(rightSpeed);
		rightTwo.set(rightSpeed);
		rightThree.set(rightSpeed);

    }
    
    public void stopDT() {

    	leftOne.stopMotor();
		leftTwo.stopMotor();
		leftThree.stopMotor();
    	rightOne.stopMotor();
		rightTwo.stopMotor();
		rightThree.stopMotor();
		
    }
    
    public void setInputSpeed(double speed, double turn) {
		//takes input turn, speed and processes to create a LSpeed and RSpeed.

    	double leftSpeed = -speed + turn;
		double rightSpeed = speed - turn;
		
			if (leftSpeed > 1.0) leftSpeed = 1.0;
			if (leftSpeed < -1.0) leftSpeed = -1.0;
			if (rightSpeed > 1.0) rightSpeed = 1.0;
			if (rightSpeed < -1.0) rightSpeed = -1.0;
		
			leftSpeed = leftRamp.rampSpeed(leftSpeed);
			rightSpeed = rightRamp.rampSpeed(rightSpeed);

			setSpeed(leftSpeed, rightSpeed);
			//then after processing calls setSpeed(). See above...
    }
    
    public void updateSD() {

    	SmartDashboard.putNumber("Drive LeftSpeed", leftOne.getSpeed());
		SmartDashboard.putNumber("Drive RightSpeed", rightOne.getSpeed());
		
    }
}

