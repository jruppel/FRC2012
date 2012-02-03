/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slidellrobotics.tigerrobotics.highshot.subsystems;

import com.slidellrobotics.tigerrobotics.highshot.commands.UpdateDashboard;
import edu.wpi.first.wpilibj.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author gixxy
 */
public class TheDash extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new UpdateDashboard());
    }
    
    public void log(int value, String key) {
        SmartDashboard.log(value, key);
    }
    public void log(double value, String key) {
        SmartDashboard.log(value, key);
    }
    public void log(boolean value, String key) {
        SmartDashboard.log(value, key);
    }
    public void log(String value, String key) {
        SmartDashboard.log(value, key);
    }
    public void log(char value, String key) {
        SmartDashboard.log(value, key);
    }
}
