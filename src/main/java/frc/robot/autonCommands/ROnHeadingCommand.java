package frc.robot.autonCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.robotMain.Robot;

public class ROnHeadingCommand extends Command {
	
	private final double MAX_ROTATE_SPEED = 0.4;
	
	private double heading;

    public ROnHeadingCommand(double target) {

    	requires(Robot.sysController.drive);
		this.heading = target;
		
    }

    protected void execute() {  

		double angleError = Robot.sysController.g1.getAngleError(heading);
		
    	if (Math.abs(angleError) > 30.0) {

			Robot.sysController.drive.setInputSpeed(0, MAX_ROTATE_SPEED * (angleError / Math.abs(angleError)));
			
    	}  else {

			Robot.sysController.drive.setInputSpeed(0, 0.2 * (angleError / Math.abs(angleError)));
			
		}
		
    }
    protected boolean isFinished() {

		return (Math.abs(Robot.sysController.g1.getAngleError(heading)) < 5.0);
		
    }
    
    protected void end() {
    	Robot.sysController.drive.stopDT();
    }
    
}
