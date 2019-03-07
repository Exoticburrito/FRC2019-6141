package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.robotMain.Robot;

/**
 *  Code for commands on the hatch side of robot.
 *  When run, the execute() method 
 *  will get left JS y-axis and check for Y-button to operate 
 *  the pneumatics and the arm motor. 
 * 
 *  Calls the setSpeed method and the pistonIn/Out methods
 *  from the HatchArm subsystem in subsystems package.
 *  Uses secondArm object in SystemController class to access these methods.
 * 
 */

public class HatchCommand extends Command {

  final private double maxArmSpeed = 0.4;
  final private double minArmSpeed = -0.4;
  private double hatchArmSpeed;

  public HatchCommand() {

    super();
    requires(Robot.sysController.secondArm);
    requires(Robot.sysController.airSystem);

  }

  @Override
  protected void initialize() {

    Robot.sysController.airSystem.pistonIn();

    hatchArmSpeed = 0;

  }

  @Override
  protected void execute() {

    hatchArmSpeed = Robot.oi.getLY();

    if (hatchArmSpeed > maxArmSpeed) {

      hatchArmSpeed = maxArmSpeed;

    } else if (hatchArmSpeed < minArmSpeed) {

      hatchArmSpeed = minArmSpeed;

    }

    if (Robot.oi.getXButton()) {

      hatchArmSpeed *= 0.5;

    }

    Robot.sysController.secondArm.setSpeed(hatchArmSpeed);

    if (Robot.oi.getLBumper()) {

      Robot.sysController.airSystem.pistonOut();

    } else if (Robot.oi.getRBumper()){

      Robot.sysController.airSystem.pistonIn();

    }

  }

  @Override
  protected boolean isFinished() {

    return false;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.sysController.secondArm.stopHArm();
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    end();
    
  }

}
