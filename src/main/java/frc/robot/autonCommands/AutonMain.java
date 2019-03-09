package frc.robot.autonCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 
 * A class that runs autonomous commands, which are essentially task lists
 * with small commands that all have timeOuts, which causes the command to end
 * and run the next command in sequence. 
 * Note specific auto modes descriptions seen next to command.
 * 
 */
public class AutonMain extends CommandGroup {

	
	//Drive For Set Time Command with gyro(heading, speed, time in seconds)
	//Rotate to heading Command (heading)
	//Intake out command() shoots cube out, spins intake for 2 seconds
	
	
    public AutonMain(AutoOptionsEnum auto, AutoOptionsEnum delay, AutoOptionsEnum withGyro) {
 
    	if (delay == AutoOptionsEnum.DELAY) {

            addSequential(new DelayCommand(3));
            
    	}
    		
    	if (withGyro == AutoOptionsEnum.WITHGYRO) {

    		if (auto == AutoOptionsEnum.TEST) {

    		} else if (auto == AutoOptionsEnum.L1 ) { 
                
	    	} else if (auto == AutoOptionsEnum.L2) { 

	    	} else if (auto == AutoOptionsEnum.R1) { 
                
	    	} else if (auto == AutoOptionsEnum.R2) {

	    	} else if (auto == AutoOptionsEnum.CR) {

	    	} else if (auto == AutoOptionsEnum.CL) {

	    	}  	
	       	
    	} else {    // No GYRO
    	
	    	if (auto == AutoOptionsEnum.TEST) {

    		} else if (auto == AutoOptionsEnum.L1 ) { 

				addSequential(new DSetTimeCommand(0.4, 3));
				addSequential(new RSetTimeCommand(2, -1));

	    	} else if (auto == AutoOptionsEnum.L2) { 

				//ADD NOGYRO L2 (Start on HAB2?!)

	    	} else if (auto == AutoOptionsEnum.R1) { 

				addSequential(new DSetTimeCommand(0.4, 3));
				addSequential(new RSetTimeCommand(2, 1));

	    	} else if (auto == AutoOptionsEnum.R2) {

				//ADD NOGYRO R2 (Start on HAB2?!)

	    	} else if (auto == AutoOptionsEnum.CR) {

				addSequential(new DSetTimeCommand(0.4, 3));
				addSequential(new AutoHatchCommand(0.4, 2 ));
				addSequential(new AutoHatchCommand(true, 2));

	    	} else if (auto == AutoOptionsEnum.CL) {

				addSequential(new DSetTimeCommand(0.4, 3));
				addSequential(new AutoHatchCommand(0.4, 2 ));
				addSequential(new AutoHatchCommand(true, 2));

            }  
        } 
    }
}
 