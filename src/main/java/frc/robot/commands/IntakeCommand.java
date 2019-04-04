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
private double maxOutput;
private double maxInput;

  public IntakeCommand() {

    super();
    requires(Robot.sysController.intakeWheels);

  }

  @Override
  protected void initialize() {

    maxOutput = 0.8;
    maxInput = 0.9;
    intakeSpeed = 0;
    
  }

  @Override
  protected void execute() {

    if (Robot.oi.getRT() > 0.08) {
      
      if (Robot.oi.getRT() > maxInput) { 

        intakeSpeed = maxInput;
        
      } else { 

        intakeSpeed = Robot.oi.getRT();

      }

    } else if (Robot.oi.getLT() > 0.08) {

        if (Robot.oi.getLT() > maxOutput) {
          
          intakeSpeed = maxOutput;

        } else {
          
          intakeSpeed = Robot.oi.getLT();

        }

        intakeSpeed *= -1;

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
