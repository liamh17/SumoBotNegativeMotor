
package org.usfirst.frc.team3167.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    private Jaguar leftMotor; 
    private Jaguar rightMotor; 
    private Joystick driveStick; 
    private Timer timer; 
    
	public void robotInit() 
	{
		//TODO: Need to be updated to compensate for cRio
		leftMotor = new Jaguar(3);  
		rightMotor = new Jaguar(4);
    }

    public void autonomousPeriodic() {

    }

    public void teleopPeriodic() 
    {
    	/*TODO:
    	 * Check axes. 
    	 * Check motor values, negative vs positive. 
    	 * Check correct axis number and move value. 
    	 */
    	if(driveStick.getRawAxis(5) == 1)
    	{
    		//Forwards
    		leftMotor.set(0.5);
    		rightMotor.set(-0.5);
    	}
    	else if(driveStick.getRawAxis(5) == -1) 
    	{
    		//Backwards
    		leftMotor.set(-0.5); 
    		rightMotor.set(0.5);
    	}
    	else if(driveStick.getRawAxis(3) == 1) 
    	{
    		//Left spin
    		leftMotor.set(-0.5);
    		rightMotor.set(-0.5); 
    	}
    	else if(driveStick.getRawAxis(3) == -1) 
    	{
    		//Right spin
    		leftMotor.set(0.5);
    		rightMotor.set(0.5);
    	}
    	//TODO: Find what button X is equivalent to in numeric value on joystick.
    	else if(driveStick.getRawButton(1) /*== true*/)
    	{
    		stop(); 
    	}
    }
    public void stop() 
    {
    	/*
    	 * Stop leftMotor, start timer, set rightMotor to 
    	 * one-tenths speed and do that for five hundredths of
    	 * a second. Repeat this just going the opposite direction.
    	 * 
    	 * This is used to compensate for either direction of move-
    	 * ment. It's almost like a sudden jolt of movement that stops 
    	 * the robot. 
    	 */
    	leftMotor.set(0.0);
    	
    	timer.start(); 
    	rightMotor.set(-0.1); 
    	timer.delay(0.05);
    	rightMotor.set(0.1);
    	timer.delay(0.05);
    	
    	timer.stop(); 
    }
}
