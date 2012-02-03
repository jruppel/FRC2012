package com.slidellrobotics.tigerrobotics.highshot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.slidellrobotics.tigerrobotics.highshot.OI;
import com.slidellrobotics.tigerrobotics.highshot.subsystems.Accelerometer;
import com.slidellrobotics.tigerrobotics.highshot.subsystems.DriveTrain;
import com.slidellrobotics.tigerrobotics.highshot.subsystems.Transmission;
import com.slidellrobotics.tigerrobotics.highshot.subsystems.TheDash;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static DriveTrain driveTrain = new DriveTrain();
    public static Transmission transmission = new Transmission();
    public static Accelerometer accelerometer = new Accelerometer();
    public static TheDash theDash = new TheDash();
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the TheDash
        
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
