/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slidellrobotics.tigerrobotics.highshot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 *
 * @author gixxy
 */
public class LowGear extends CommandBase {
    
    public LowGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(transmission);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        transmission.setLowGear();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(transmission.getGear().equals(Value.kReverse)) {
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
