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

  public DriveCommand() {

    requires(Robot.sysController.drive);

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

    if (Robot.oi.isStraightDrive()) {

      rotationalSpeed = 0;

    } 
    
    if (Robot.oi.isSlowTurn()) {

      rotationalSpeed *= 0.3;

    }
    
    if (Robot.oi.isReverseDrive()) {
      
      linearSpeed *= -1;

    }

    if (Robot.oi.isSlowDrive()) {

      linearSpeed *= 0.2;
      
    } 
    // } else if (Robot.oi.isModerateDrive()) {

    //   linearSpeed *= 0.5;

    // }

    Robot.sysController.drive.setInputSpeed(linearSpeed, rotationalSpeed);

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

