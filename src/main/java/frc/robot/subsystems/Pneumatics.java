package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.HatchCommand;
import frc.robot.commands.DriveCommand;

public class Pneumatics extends Subsystem {

    DoubleSolenoid hatchSolenoid;
    DoubleSolenoid driveSolenoid;
    DoubleSolenoid climbSolenoid;

    private boolean hatch;
    private boolean drive;
    private boolean climb;

  public void initDefaultCommand() {
      
    setDefaultCommand(new HatchCommand());
    setDefaultCommand(new DriveCommand());
  
  }

  public Pneumatics () {

    hatchSolenoid = new DoubleSolenoid(0, 1);
    driveSolenoid = new DoubleSolenoid(2, 3);
    climbSolenoid = new DoubleSolenoid(4, 5);

    hatchSolenoid.set(DoubleSolenoid.Value.kReverse);
    driveSolenoid.set(DoubleSolenoid.Value.kReverse);
    climbSolenoid.set(DoubleSolenoid.Value.kReverse);
        
  }

  public void pistonOff () {

    hatchSolenoid.set(DoubleSolenoid.Value.kOff);
    driveSolenoid.set(DoubleSolenoid.Value.kOff);
    climbSolenoid.set(DoubleSolenoid.Value.kOff);

  }
  
  public void hatchPiston (boolean hatchInOut) {

    if (hatchInOut) {

      hatchSolenoid.set(DoubleSolenoid.Value.kForward);

    } else {

      hatchSolenoid.set(DoubleSolenoid.Value.kReverse);

    }

    this.hatch = hatchInOut;
    
  }  
  
  public void drivePiston (boolean driveShift) {

    if (driveShift) {

      driveSolenoid.set(DoubleSolenoid.Value.kForward);

    } else {

      driveSolenoid.set(DoubleSolenoid.Value.kReverse);

    }

    this.drive = driveShift;
    
  } 
   
  public void climbPiston (boolean climbBool) {

    if (climb) {

      climbSolenoid.set(DoubleSolenoid.Value.kForward);

    } else {

      climbSolenoid.set(DoubleSolenoid.Value.kReverse);

    }

    this.climb = climbBool;

  }

  public void updateSD() {

  SmartDashboard.putBoolean("Hatch Piston State", hatch);
  SmartDashboard.putBoolean("Drive Piston State", drive);
  SmartDashboard.putBoolean("Climb Piston State", climb);
  
  }

}
