package frc.robot.autonCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.robotMain.Robot;

/**
 *	Also used exclusively in the autonomous code, tells the robot to drive straight
 *	no turn value added, but does not use gyro (potentially prone to drifting).
 *
 *	parameters for constructor- speed, time
 *	
 */
public class DSetTimeCommand extends Command {
	
	private double timeLimit;
	private double speed;

    public DSetTimeCommand(double speed, double time) {
    	
    	super();
    	this.speed = -speed;//reverse so it runs the right way
    	this.timeLimit = time;
    	
    }

    protected void initialize() {
        setTimeout(timeLimit);
    }
    
    public void execute() {
    	Robot.sysController.drive.setInputSpeed(speed, 0);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        Robot.sysController.drive.stopDT();
    } 

    @Override
    protected void interrupted() {
    }

}
