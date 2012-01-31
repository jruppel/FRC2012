/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slidellrobotics.tigerrobotics.highshot.commands;
import java.util.Date;

/**
 *
 * @author Jeff
 */
public class ProcessAccelerometer extends CommandBase {
    
    double newAcceleration;
    double timespan;
    long lastTime;
    double velocityX;
    double velocityY;
    Date date;
    
    
    public ProcessAccelerometer() {
        // Use requires() here to declare subsystem dependencies
    requires(accelerometer);
    newAcceleration = 0;
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
        
        //newAcceleration = accelerometer.getAccelerationX();
        velocityX = velocityX + newAcceleration * timespan;
        velocityY = velocityY + newAcceleration * timespan;
        
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
