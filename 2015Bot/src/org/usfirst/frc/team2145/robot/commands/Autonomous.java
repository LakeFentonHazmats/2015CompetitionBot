package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous extends Command {

	@Override
	protected void initialize() {
		Robot.driveTrain.encoderReset();
	}

	@Override
	protected void execute() {
		Robot.driveTrain.driveStraightToDistance(-50);
		
		/*if(Robot.driveTrain.gyroValue() != 0){
			if(Robot.driveTrain.gyroValue() < 0){
				Robot.driveTrain.MecanumDrive(-0.07, -0.3, -0.07);
			}
			if(Robot.driveTrain.gyroValue() > 0){
				Robot.driveTrain.MecanumDrive(0.07, -0.3, 0.07);
			}
		}
		else{
			if(Robot.driveTrain.logDrive() > -30){
				Robot.driveTrain.MecanumDrive(0, -0.3, 0);
			}
			else{
				Robot.driveTrain.MecanumDrive(0, 0, 0);
			}
		}
		
		if (Robot.driveTrain.logDrive() < -30 ){
			if(Robot.driveTrain.gyroValue() < 90){
				Robot.driveTrain.MecanumDrive(0, -0.1, -0.35);
			}
			else{
				
				if(Robot.driveTrain.gyroValue() != 90){
					if(Robot.driveTrain.gyroValue() < 90){
						Robot.driveTrain.MecanumDrive(0.5, 0, -0.1);
					}
					if(Robot.driveTrain.gyroValue() > 90){
						Robot.driveTrain.MecanumDrive(0.5, 0, 0.1);
					}
				}
				else{
					Robot.driveTrain.MecanumDrive(0.5, 0, 0);
				}
			}
		}
		*/

		
		SmartDashboard.putNumber("Encoder", Robot.driveTrain.logDrive());
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
		Robot.driveTrain.encoderReset();
		Robot.driveTrain.gyroReset();
		
	}

}
