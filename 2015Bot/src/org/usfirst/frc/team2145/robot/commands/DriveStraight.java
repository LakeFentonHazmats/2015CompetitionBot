package org.usfirst.frc.team2145.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2145.robot.Robot;

public class DriveStraight extends Command {
	private PIDController pid;
	public DriveStraight(double distance) {
        requires(Robot.driveTrain);
        pid = new PIDController(0.666, 0, 0,
                new PIDSource() { public double pidGet() {
                    return Robot.driveTrain.encoderValue();
                }},
                new PIDOutput() { public void pidWrite(double d) {
                    Robot.driveTrain.MecanumDrive(0, d * 0.25, 0);;
                }});
        pid.setAbsoluteTolerance(1);
        pid.setSetpoint(distance);
    }

	@Override
	protected void initialize() {
		Robot.driveTrain.encoderReset();;
    	pid.reset();
        pid.enable();
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return pid.onTarget();
	}

	@Override
	protected void end() {
		pid.disable();
        Robot.driveTrain.MecanumDrive(0, 0, 0);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		end();
		// TODO Auto-generated method stub
		
	}

}
