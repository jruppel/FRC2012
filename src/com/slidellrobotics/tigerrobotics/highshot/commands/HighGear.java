/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slidellrobotics.tigerrobotics.highshot.commands;


/**
 *
 * @author gixxy
 */
public class HighGear extends CommandBase {
    
    public HighGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(transmission);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        transmission.setHighGear();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(transmission.getGear() == true) {
            return(true);
        } else {
            return(false);
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
