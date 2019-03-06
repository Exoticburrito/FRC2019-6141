package frc.robot.commands;

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

public class IntakeCommand extends Command {

private double intakeSpeed;

  public IntakeCommand() {

    requires(Robot.sysController.intakeWheels);

  }

  @Override
  protected void initialize() {

    intakeSpeed = 0;
    
  }

  @Override
  protected void execute() {

    if (Robot.oi.getRT() > 0.2){
      
      intakeSpeed = 0.3;

    } else if (Robot.oi.getLT() > 0.2) {
      
      intakeSpeed = -0.7;

    } else {

      intakeSpeed = 0;

    }

    Robot.sysController.intakeWheels.setCargoIntakeSpeed(intakeSpeed);

  }

  @Override
  protected boolean isFinished() {

    return false;

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
