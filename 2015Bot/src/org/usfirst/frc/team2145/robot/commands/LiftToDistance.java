package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftToDistance extends Command {
	private double setpoint;
	
	public LiftToDistance(double setpoint) {
        this.setpoint = setpoint;
        requires(Robot.lift);
    }
	protected void initialize() {
		Robot.lift.enable();
		Robot.lift.setSetpoint(setpoint);
	}

	@Override
	protected void execute() {
		
		
	}

	@Override
	protected boolean isFinished() {
		
		return Robot.lift.onTarget();
		
	}

	@Override
	protected void end() {
		
		
	}

	@Override
	protected void interrupted() {
		
	}

	

}
