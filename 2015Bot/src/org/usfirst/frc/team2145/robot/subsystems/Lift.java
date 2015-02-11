package org.usfirst.frc.team2145.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.TalonSRX;

import org.usfirst.frc.team2145.robot.RobotMap;

public class Lift extends Subsystem {
	
	TalonSRX liftMotor = new TalonSRX(RobotMap.liftMotor);
	

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void liftDrive(double liftSpeed) {
		liftMotor.set(liftSpeed);
	
	}
	
	
	
}
