/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slidellrobotics.tigerrobotics.highshot.commands;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import java.util.Date;

/**
 *
 * @author Jeff
 */
public class ProcessAccelerometer extends CommandBase {

    double timespan;
    long lastTime;
    double velocityX;
    protected double velocityY;
    Date date;
    ADXL345_I2C.AllAxes allaxes;
    
    public ProcessAccelerometer() {
        // Use requires() here to declare subsystem dependencies
        requires(accelerometer);
        
        timespan = .02;
        velocityX = 0;
        velocityY = 0;
        date = new Date();
        lastTime = date.getTime(); // time in ms

        //newVelocity = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        timespan = date.getTime() - lastTime;
        allaxes = accelerometer.GetAcceleration();
        velocityX = velocityX + allaxes.XAxis * timespan;
        velocityY = velocityY + allaxes.YAxis * timespan;
        theDash.log(velocityX,"X");
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
