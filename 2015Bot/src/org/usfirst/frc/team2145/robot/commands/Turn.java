package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Turn extends Command{
	public Turn(double angle){
		if(Robot.driveTrain.gyroValue() < angle){
			Robot.driveTrain.MecanumDrive(0, 0, -0.3);
		}
		else{
			Robot.driveTrain.MecanumDrive(0, 0, 0);
		}
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.gyroReset();
		Robot.driveTrain.encoderReset();
		
	}

	@Override
	protected void execute() {
		
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
