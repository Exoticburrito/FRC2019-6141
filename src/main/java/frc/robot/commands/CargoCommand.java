package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.robotMain.Robot;

/**
 *  Code for commands for cargo arm motor.
 *  When run, the execute() method will:
 *  get right JS y-axis
 *  to operate the cargo arm motor. 
 * 
 *  Calls the setMainArmRotateSpeed method
 *  from the CargoArm subsystem in subsystems package.
 *  Uses mainArm object in SystemController class to access these methods.
 * 
 */

public class CargoCommand extends Command {

  final private double maxArmSpeed = 0.4;
  final private double minArmSpeed = -0.4;
  private double armSpeed;

  public CargoCommand() {

    super();
    requires(Robot.sysController.mainArm);

  }

  @Override
  protected void initialize() {

    armSpeed = 0;
    
  }

  @Override
  protected void execute() {

    armSpeed = Robot.oi.getRY();

    if (armSpeed > maxArmSpeed) {

      armSpeed = maxArmSpeed;

    } else if (armSpeed < minArmSpeed) {

      armSpeed = minArmSpeed;

    }

    if (Robot.oi.getAButton()) {

      armSpeed *= 0.5;

    }

    Robot.sysController.mainArm.setMainArmRotateSpeed(armSpeed);

  }

  @Override
  protected boolean isFinished() {

    return false;

  }

  @Override
  protected void end() {

    Robot.sysController.mainArm.stopMainArm();

  }
  
  @Override
  protected void interrupted() {

    end();

  }
}
