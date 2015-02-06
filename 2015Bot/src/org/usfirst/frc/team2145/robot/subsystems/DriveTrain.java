package org.usfirst.frc.team2145.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import org.usfirst.frc.team2145.robot.Robot;
import org.usfirst.frc.team2145.robot.RobotMap;
import org.usfirst.frc.team2145.robot.commands.DriveWithController;


public class DriveTrain extends Subsystem{
	
	TalonSRX frontRightWheel = new TalonSRX(RobotMap.frontRightWheel);
	TalonSRX frontLeftWheel = new TalonSRX(RobotMap.frontLeftWheel);
	TalonSRX backRightWheel = new TalonSRX(RobotMap.backRightWheel);
	TalonSRX backLeftWheel = new TalonSRX(RobotMap.backLeftWheel);
	
	Encoder backRightEncoder = new Encoder(RobotMap.backRightEncoder1,RobotMap.backRightEncoder2);
	Encoder backLeftEncoder= new Encoder(RobotMap.backLeftEncoder1,RobotMap.backLeftEncoder2);
	
	Gyro gyro = new Gyro(RobotMap.driveGyro);
	
	PIDController encoderPID;
	PIDSource ePIDSource;
	PIDOutput ePIDOutput;
	
	
	
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
       setDefaultCommand(new DriveWithController());
    }
	
	public void MecanumDrive (double X,double Y,double Z) {
	   
		double forward= Y;
		double right= X;
		double clockwise= Z;
		//Gets Directions like from Joy Sticks.
		
		double front_left = forward + clockwise + right;
		double front_right = forward - clockwise- right;
		double rear_left = forward + clockwise - right;
		double rear_right = forward - clockwise + right;
		//Kinetic Data for Mech Wheels
		
		double max = Math.abs(front_left);
		if (Math.abs(front_right)>max) max=Math.abs(front_right);
		if (Math.abs(rear_left)>max) max= Math.abs(rear_left);
		if (Math.abs(rear_right)>max) max= Math.abs(rear_right);
		//Determines highest going Motor
		
		if (max>1)
		{front_left/=max; front_right/=max; rear_left/=max; rear_right/=max;}
		//Makes it so none can be above 1
		
		frontRightWheel.set(front_right);
		frontLeftWheel.set(-front_left);
		backRightWheel.set(rear_right);
		backLeftWheel.set(-rear_left);
		//Sends Data to Talons
	}
	
	@SuppressWarnings("deprecation")
	public double logDrive(){
		double encoderAverage = (backRightEncoder.getDistance() + backLeftEncoder.getDistance()) / 2;
		encoderAverage= (encoderAverage /(8 * Math.PI));
		return encoderAverage;
		
	}
	public void encoderReset(){
		backRightEncoder.reset();
		backLeftEncoder.reset();
	}
	public double gyroValue(){
		return gyro.getAngle();
	}
	public void gyroReset(){
		gyro.reset();
	}
	public double encoderValue(){
		double encoderAverage = (backRightEncoder.getDistance() + backLeftEncoder.getDistance()) / 2;
		encoderAverage= (encoderAverage /(8 * Math.PI));
		return encoderAverage;
	}
	public void driveStraightToDistance(double distance){
		double eP = 0;
		double eI = 0;
		double eD = 0;
		double ePIDSpeed = 0;
		
		ePIDSource.equals(encoderValue());
		ePIDOutput.equals(ePIDSpeed);
		encoderPID = new PIDController(eP,eI,eD,distance,ePIDSource,ePIDOutput );
		encoderPID.enable();
		
		ePIDOutput.pidWrite(ePIDSpeed);
		MecanumDrive (0,ePIDSpeed,0);
		
	}
	
		
	
	

}
