package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.robotMain.Robot;

/**
 *  Code for commands that drive the robot.
 *  When run, the execute() method will:
 *  get y-axis and x-axis from driver JS.
 * 
 *  Calls the setInputSpeed method 
 *  from the DriveTrain subsystem in subsystems package.
 *  Uses drive object in SystemController class to access these methods.
 * 
 */

public class DriveCommand extends Command {

  private double linearSpeed;
  private double rotationalSpeed;

  private double maxSpeed = 0.7;
  private double maxTurn = 0.6;
  private final double STRAIGHT_DRIVE_TURN_RATE= 0.1;

  public DriveCommand() {

    super();
    requires(Robot.sysController.drive);
    requires(Robot.sysController.airSystem);

  }

  @Override
  protected void initialize() {

    linearSpeed = 0;
    rotationalSpeed = 0;
    
  }
  
  @Override
  protected void execute() {

    linearSpeed = Robot.oi.getYAxis();
    rotationalSpeed = Robot.oi.getZAxis();

    if (Math.abs(linearSpeed) >  0.08 || Math.abs(rotationalSpeed) > 0.08) {

      if (Robot.oi.isStraightDrive()) {

        rotationalSpeed *= STRAIGHT_DRIVE_TURN_RATE;
  
      } 
      
      if (Robot.oi.isReverseDrive()) {
        
        linearSpeed *= -1;
  
      }
  
      if (Robot.oi.isSlowDrive()) {
  
        linearSpeed *= 0.4;
        rotationalSpeed *= 0.4;
        
      } 
  
      if (linearSpeed > maxSpeed) {
  
        linearSpeed = maxSpeed;
  
      }
      
      if (rotationalSpeed > maxTurn) {
  
        rotationalSpeed = maxTurn;

      }

    }
   
    Robot.sysController.airSystem.drivePiston(Robot.oi.isShiftGears());
    Robot.sysController.drive.setInputSpeed(linearSpeed, rotationalSpeed);

    if (Robot.oi.isClimbMode()) {
      Robot.sysController.airSystem.climbPiston(Robot.oi.isClimbMode());
    }
  }

  @Override
  protected boolean isFinished() {

    return false;

  }

  @Override
  protected void end() {

    Robot.sysController.drive.stopDT();

  }

  @Override
  protected void interrupted() {

    end();

  }
}

