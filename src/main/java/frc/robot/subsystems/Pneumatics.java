package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.HatchCommand;

public class Pneumatics extends Subsystem {

    DoubleSolenoid hatchSolenoid;
    // Compressor c1;

  public void initDefaultCommand() {
      
    setDefaultCommand(new HatchCommand());
  
  }

  public Pneumatics () {

    hatchSolenoid = new DoubleSolenoid(0, 1);
    // c1 = new Compressor(0);

    hatchSolenoid.set(DoubleSolenoid.Value.kOff);
    // c1.setClosedLoopControl(true);
    // c1.start();


  }

  public void pistonOff () {

    hatchSolenoid.set(DoubleSolenoid.Value.kOff);

  }
  
  public void pistonOut () {

    hatchSolenoid.set(DoubleSolenoid.Value.kForward);

  }

  public void pistonIn () {

    hatchSolenoid.set(DoubleSolenoid.Value.kReverse);

  }

}
