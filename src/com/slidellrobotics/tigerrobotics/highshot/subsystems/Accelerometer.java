/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slidellrobotics.tigerrobotics.highshot.subsystems;

import com.slidellrobotics.tigerrobotics.highshot.commands.ProcessAccelerometer;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author gixxy
 */
public class Accelerometer extends Subsystem {
    ADXL345_I2C accelerometer;
    
    public void Accelerometer() {
        accelerometer = new ADXL345_I2C(2, ADXL345_I2C.DataFormat_Range.k4G);
    }
    public ADXL345_I2C.AllAxes GetAcceleration() {
        return accelerometer.getAccelerations();
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ProcessAccelerometer());
    }
}
