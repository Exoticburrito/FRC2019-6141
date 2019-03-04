package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *  Code for commands that delete all commands.
 *  When run, the execute() method will:
 *  remove all commands in queue from Scheduler.
 * 
 *  Calls no other methods.
 * 
 */

public class CancelCommand extends Command {

  public CancelCommand() {
    
    super();
    
  }
  
  @Override
  protected void initialize() {  
  }

  @Override
  protected void execute() {  

    Scheduler.getInstance().removeAll();

  }

  protected boolean isFinished() {  

    return true;

  }
  
}
