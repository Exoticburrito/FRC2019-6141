package frc.robot.autonCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.robotMain.Robot;

/**
 *  Code for commands intake wheels for cargo of robot.
 *  When run, the execute() method will:
 *  get values from RT and LR
 *  to operate the cargo intake wheels. 
 * 
 *  Calls the setCargoIntakeSpeed method
 *  from the Intake subsystem in subsystems package.
 *  Uses intakeWheels object in SystemController class to access these methods.
 * 
 */

public class AutoIntakeCommand extends Command {

private final double intakeSpeed = 1.0;
private final double outputSpeed = -0.7;
private final double time = 3;
private boolean inOut;

//TODO FIGURE OUT DIRECTIONS AND TRUE/FALSE HERE

  public AutoIntakeCommand(boolean direction) {

    super();
    requires(Robot.sysController.intakeWheels);

  }

  @Override
  protected void initialize() {

    setTimeout(time);    

  }

  @Override
  protected void execute() {

    if (inOut) {

        Robot.sysController.intakeWheels.setCargoIntakeSpeed(intakeSpeed);

    } else if (!inOut) {

        Robot.sysController.intakeWheels.setCargoIntakeSpeed(outputSpeed);

    }

  }

  @Override
  protected boolean isFinished() {

    return isTimedOut();

  }

  @Override
  protected void end() {
    
    Robot.sysController.intakeWheels.stopCargoIntake();

  }
  
  @Override
  protected void interrupted() {

    end();

  }
}
