/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slidellrobotics.tigerrobotics.highshot.commands;

/**
 *
 * @author gixxy
 */
public class UpdateDashboard extends CommandBase {
    boolean updated;
    public UpdateDashboard() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(theDash);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        updated = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        theDash.log(transmission.getGearString(), "Gear");
        theDash.log(driveTrain.getLeftSpeed(), "Left Speed");
       
        theDash.log(driveTrain.getRightSpeed(), "Right Speed");
        updated = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return updated;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
