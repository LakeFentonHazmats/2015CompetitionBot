package org.usfirst.frc.team2145.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {

	public Autonomous() {
		addSequential(new LiftToTop());
		addSequential(new Strafe(10));
    	addParallel(new LiftToHome());
    	addSequential(new DriveStraight(-3));
    	addSequential(new Strafe(-10));
    	addSequential(new LiftToTop());
    	addSequential(new Strafe(10));
    	addParallel(new LiftToHome());
    	addSequential(new DriveStraight(-10));
    	addSequential(new Strafe(-10));
    	addSequential(new LiftToTop());
    	addSequential(new Turn(90));
    	addSequential(new DriveStraight(-48));
	}
}
