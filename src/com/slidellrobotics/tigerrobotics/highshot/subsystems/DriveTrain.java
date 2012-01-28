/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slidellrobotics.tigerrobotics.highshot.subsystems;

import com.slidellrobotics.tigerrobotics.highshot.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author gixxy
 */
public class DriveTrain extends Subsystem {
    private Jaguar leftJaguar;
    private Jaguar rightJaguar;
    private RobotDrive robotDrive;
    
    public DriveTrain() {
        leftJaguar = new Jaguar(RobotMap.leftMotor);
        rightJaguar = new Jaguar(RobotMap.rightMotor);
        robotDrive = new RobotDrive(leftJaguar, rightJaguar);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(double leftSpeed, double rightSpeed) {
        robotDrive.tankDrive(leftSpeed, rightSpeed);
    }
    
    public double getLeftSpeed() {
        return leftJaguar.getSpeed();
    }
    
    public double getRightSpeed() {
        return leftJaguar.getSpeed();
    }
}
