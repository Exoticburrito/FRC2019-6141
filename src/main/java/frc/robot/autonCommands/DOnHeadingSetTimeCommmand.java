package frc.robot.autonCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.robotMain.Robot;

public class DOnHeadingSetTimeCommmand extends Command {
	
	private double heading;
	private double speed;
	private double time;

	private final double STRAIGHT_DRIVE_TURN_RATE = 0.005;
	
	public DOnHeadingSetTimeCommmand(double heading, double speed, double time) {
		
		super();
		requires(Robot.sysController.drive);
		this.heading = heading;
		this.speed = speed;
		this.time = time;

	}
	
	protected void initialize() {
		setTimeout(time);
	}
	
	@Override
	protected void execute() {
			
		double turn = Robot.sysController.g1.getAngleError(heading) 
				* STRAIGHT_DRIVE_TURN_RATE;
		if (turn > 1) turn = 1;
		if (turn < -1) turn = -1;
		Robot.sysController.drive.setInputSpeed(speed, turn);
		
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.sysController.drive.stopDT();
	}

	@Override
    protected void interrupted() {
    }

}
