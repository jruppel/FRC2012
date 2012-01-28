/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slidellrobotics.tigerrobotics.highshot.subsystems;

import com.slidellrobotics.tigerrobotics.highshot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author gixxy
 */
public class Transmission extends Subsystem {
    DoubleSolenoid gearShifter = new DoubleSolenoid(RobotMap.gearSolinoid, RobotMap.gearSolinoid+1);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setHighGear() {
        gearShifter.set(DoubleSolenoid.Value.kForward);
    }
    
    public void setLowGear() {
        gearShifter.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void setNeutralGear() {
        gearShifter.set(DoubleSolenoid.Value.kOff);
    }
    
    public Value getGear() {
        return gearShifter.get();
    }
}
