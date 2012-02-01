/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slidellrobotics.tigerrobotics.highshot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.image.*;

/**
 *
 * @author 10491477
 */


public class FilterImage { //need to extend commandbase
    private ColorImage pic;
    private BinaryImage thresholdHSL = null;
    private int remove  = 0;
    private BinaryImage bigObjectsImage = null;
    private BinaryImage convexHullImage = null;
    private BinaryImage filteredImage = null;
    CriteriaCollection cc;
    
    
    //Todo: add missing constructor FilterImage
    
    
    //Todo: Add missing command functions
    //Command need to over ride the following functions
    /*
    // Called just before this Command runs the first time
    protected void initialize() {
     
    //need to make a subsystem called camera and require it here
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    */
    
    public ColorImage getImage() {
        try {
            BinaryImage thresholdHSL = pic.thresholdHSL(140,180,
                0,20, 200, 250);
        } catch (NIVisionException ex) {
        }
       
        try {
            int remove = thresholdHSL.getNumberParticles() - 4;
        } catch (NIVisionException ex) {
        }
        try {
            BinaryImage bigObjectsImage = thresholdHSL.removeSmallObjects(false, remove);
        } catch (NIVisionException ex) {
        }
        
        try {
            BinaryImage convexHullImage = bigObjectsImage.convexHull(false);
        } catch (NIVisionException ex) {
        }
        
        try {
            BinaryImage filteredImage = convexHullImage.particleFilter(cc);
        } catch (NIVisionException ex) {
        }
        
        ParticleAnalysisReport[] reports = null;
        try {
            reports = filteredImage.
                    getOrderedParticleAnalysisReports();
        } catch (NIVisionException ex) {
            
        }
        for (int i=0; i<reports.length; i++) {
            ParticleAnalysisReport r = reports[i];
            System.out.println("Particle: "+i+": Center of mass x:"+
                    r.center_mass_x);
        }
        try {
            System.out.println(filteredImage.getNumberParticles()+" "+
                    Timer.getFPGATimestamp());
        } catch (NIVisionException ex) {
        }
        
        try {
            filteredImage.free();
        } catch (NIVisionException ex) {
        }
        
        try {
            convexHullImage.free();
        } catch (NIVisionException ex) {
        }
        
        try {
            bigObjectsImage.free();
        } catch (NIVisionException ex) {
        }
        
        try {
            thresholdHSL.free();
        } catch (NIVisionException ex) {
        }
        
        try {
            pic.free();
        } catch (NIVisionException ex) {
        }
        return pic;
    }
}


/*
 * 
 * check out Brad's example code from
 * http://firstforge.wpi.edu/sf/go/doc1209;jsessionid=DE1AA2AE5AA5396063CB73C1AE17456B?nav=1
 * 
 * package edu.wpi.first.wpilibj.templates;

* // to remove the comments high light all the code and press ctrl+slash
//import com.sun.squawk.util.Arrays;
//import com.sun.squawk.util.Comparer;
//import edu.wpi.first.wpilibj.SimpleRobot;
//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.camera.AxisCamera;
//import edu.wpi.first.wpilibj.camera.AxisCameraException;
//import edu.wpi.first.wpilibj.image.BinaryImage;
//import edu.wpi.first.wpilibj.image.ColorImage;
//import edu.wpi.first.wpilibj.image.NIVisionException;
//import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
//
///**
// *
// * @author Greg Granito (Team 190)
// * This sample program finds the top 3 camera images that are likely to be the goals
// * when viewed by the axis camera. You would use this data to drive the robot towards
// * the appropriate goal and score the tube.
// */
//
///*
//public class CameraSample extends SimpleRobot {
//
//    AxisCamera camera;
//    private ColorImage colorImage;
//    private ParticleAnalysisReport s_particles[];
//    private final ParticleComparer particleComparer = new ParticleComparer();
//
//    /**
//     * Constructor for the sample program.
//     * Get an instance of the axis camera.
//     */
//    public CameraSample() {
//        camera = AxisCamera.getInstance();
//    }
//
//    /**
//     * the sample code runs during the autonomous period.
//     *
//     */
//    public void autonomous() {
//
//	/**
//	 * Run while the robot is enabled
//	 */
//        while (isEnabled()) {
//            if (camera.freshImage()) {	    // check if there is a new image
//                try {
//                    colorImage = camera.getImage(); // get the image from the camera
//
//                    /**
//		     * The color threshold operation returns a bitmap (BinaryImage) where pixels are present
//		     * when the corresponding pixels in the source (HSL) image are in the specified
//		     * range of H, S, and L values.
//		     */
//                    BinaryImage binImage = colorImage.thresholdHSL(242, 255, 36, 255, 25, 255);
//
//		    /**
//		     * Find blobs (groupings) of pixels that were identified in the color threshold operation
//		     */
//                    s_particles = binImage.getOrderedParticleAnalysisReports();
//
//		    /**
//		     * Free the underlying color and binary images.
//		     * You must do this since the image is actually stored
//		     * as a C++ data structure in the underlying implementation to maximize processing speed.
//		     */
//                    colorImage.free();
//                    binImage.free();
//
//		    /**
//		     * print the number of detected particles (color blobs)
//		     */
//                    System.out.println("Particles: " + s_particles.length);
//
//                    if (s_particles.length > 0) {
//			/**
//			 * sort the particles using the custom comparitor class (see below)
//			 */
//                        Arrays.sort(s_particles, particleComparer);
//
//                        for (int i = 0; i < s_particles.length; i++) {
//                            ParticleAnalysisReport circ = s_particles[i];
//
//			    /**
//			     * Compute the number of degrees off center based on the camera image size
//			     */
//                            double degreesOff = -((54.0 / 640.0) * ((circ.imageWidth / 2.0) - circ.center_mass_x));
//                            switch (i) {
//                                case 0:
//                                    System.out.print("Best Particle:     ");
//                                    break;
//                                case 1:
//                                    System.out.print("2nd Best Particle: ");
//                                    break;
//                                case 2:
//                                    System.out.print("3rd Best Particle: ");
//                                    break;
//                                default:
//                                    System.out.print((i + 1) + "th Best Particle: ");
//                                    break;
//                            }
//                            System.out.print("    X: " + circ.center_mass_x
//                                    + "     Y: " + circ.center_mass_y
//                                    + "     Degrees off Center: " + degreesOff
//                                    + "     Size: " + circ.particleArea);
//                            System.out.println();
//
//                        }
//                    }
//                    System.out.println();
//                    System.out.println();
//                    Timer.delay(4);
//                } catch (AxisCameraException ex) {
//                    ex.printStackTrace();
//                } catch (NIVisionException ex) {
//                    ex.printStackTrace();
//                }
//            }
//            Timer.delay(0.01);
//        }
//    }
//
//
//    /**
//     * compare two particles
//     *
//     */
//    class ParticleComparer implements Comparer {
//
//        public int compare(ParticleAnalysisReport p1, ParticleAnalysisReport p2) {
//            float p1Ratio = p1.boundingRectWidth / p1.boundingRectHeight;
//            float p2Ratio = p2.boundingRectWidth / p2.boundingRectHeight;
//
//            if (Math.abs(p1Ratio - p2Ratio) < 0.1) {
//                return -(Math.abs((p1.imageWidth / 2) - p1.center_mass_x))
//                        - Math.abs(((p2.imageWidth / 2) - p2.center_mass_x));
//            } else {
//                if (Math.abs(p1Ratio - 1) < Math.abs(p2Ratio - 1)) {
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//        }
//
//	// overloaded method because the comparitor uses Objects (not Particles)
//        public int compare(Object o1, Object o2) {
//            return compare((ParticleAnalysisReport) o1, (ParticleAnalysisReport) o2);
//        }
//    };
//}
//
// 