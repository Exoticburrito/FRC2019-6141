package frc.robot.autonCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.robotMain.Robot;

/**
 *	this command is very similar to rotate for set time command
 *	But uses the gyro for maximum precision
 */
public class ROnHeadingCommand extends Command {
	
	private final double MAX_ROTATE_SPEED = 0.4;
	
	private double heading;

    public ROnHeadingCommand(double heading) {
    	requires(Robot.sysController.drive);
    	this.heading = heading;
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
