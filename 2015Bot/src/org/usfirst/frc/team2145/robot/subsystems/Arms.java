package org.usfirst.frc.team2145.robot.subsystems;

import org.usfirst.frc.team2145.robot.RobotMap;
import org.usfirst.frc.team2145.robot.commands.ExampleCommand;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arms extends Subsystem{
	TalonSRX leftArmMotor = new TalonSRX(RobotMap.leftArmMotor);
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ExampleCommand());
	}
	
	public void setMotor(double x){
		leftArmMotor.set(x);
	}

}
