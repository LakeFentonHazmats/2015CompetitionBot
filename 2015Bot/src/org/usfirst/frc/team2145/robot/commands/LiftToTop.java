package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftToTop extends Command{
	public LiftToTop() {
        requires(Robot.lift);
    }
	@Override
	protected void initialize() {
		Robot.lift.liftEncoderReset();
	}

	@Override
	protected void execute() {
		if(Robot.lift.liftEncoder() < 52){
			Robot.lift.liftDrive(-0.7);
		}
		else{
			Robot.lift.liftDrive(0);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {	
		
	}

	@Override
	protected void interrupted() {
		
	}

}
