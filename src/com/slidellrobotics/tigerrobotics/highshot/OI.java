
package com.slidellrobotics.tigerrobotics.highshot;

import com.slidellrobotics.tigerrobotics.highshot.commands.HighGear;
import com.slidellrobotics.tigerrobotics.highshot.commands.LowGear;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private Joystick leftJoystick = new Joystick(RobotMap.leftJoystick); //Left Joystick
    private Joystick rightJoystick = new Joystick(RobotMap.rightJoystick); //Right Joystick
    private Button fireBall = new JoystickButton(rightJoystick, RobotMap.fireButton); //Button to fire the ball
    private Button shiftHighGear = new JoystickButton(rightJoystick, RobotMap.highGearShiftButton); //Button to shift to High Gear
    private Button shiftLowGear = new JoystickButton(rightJoystick, RobotMap.lowGearShiftButton); //Button to shift to Low Gear
    
    public OI() {
        shiftHighGear.whenPressed(new HighGear());
        shiftLowGear.whenPressed(new LowGear());
    }
    
    /**
     * Get the Left Joystick Object
     * @return left joystick object
     */
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }
    
    /**
     * Get the Right Joystick Object
     * @return right joystick object
     */
    public Joystick getRightJoystick() {
        return rightJoystick;
    }
    
    /**
     * get Fire Button Object
     * @return fire button object
     */
    public Button getFireButton() {
        return fireBall;
    }
    
    /**
     * get High Gear Shift Button
     * @return high gear shift button
     */
    public Button getHighGearShift() {
        return shiftHighGear;
    }
    
    /**
     * get Low Gear Shift Button
     * @return low gear shift button 
     */
    public Button getLowGearShift() {
        return shiftLowGear;
    }
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

