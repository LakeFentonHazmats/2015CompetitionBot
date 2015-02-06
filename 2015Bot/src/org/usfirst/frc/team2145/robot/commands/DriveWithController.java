package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithController extends Command {
	public DriveWithController() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.encoderReset();
    	Robot.driveTrain.gyroReset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.MecanumDrive(Robot.oi.StickX(), Robot.oi.StickY(), Robot.oi.StickZ());
    	SmartDashboard.putNumber("X Value", Robot.oi.StickX());
    	SmartDashboard.putNumber("Y Value", Robot.oi.StickY());
    	SmartDashboard.putNumber("Z Value", Robot.oi.StickZ());
		SmartDashboard.putNumber("Gyro", Robot.driveTrain.gyroValue());
    	SmartDashboard.putNumber("Encoder", Robot.driveTrain.logDrive());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
