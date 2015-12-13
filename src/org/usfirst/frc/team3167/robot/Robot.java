
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
    	//TODO: Check all values for if statements and motor speeds
    	if(driveStick.getRawAxis(5) == 1)
    	{
    		leftMotor.set(0.5);
    		rightMotor.set(0.5);
    	}
    	else if(driveStick.getRawAxis(5) == -1) 
    	{
    		leftMotor.set(-0.5); 
    		rightMotor.set(0.5);
    	}
    	else if(driveStick.getRawAxis(3) == 1)
    }
}
