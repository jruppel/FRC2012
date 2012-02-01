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
public class FilterImage {
    private ColorImage pic;
    private BinaryImage thresholdHSL = null;
    private int remove  = 0;
    private BinaryImage bigObjectsImage = null;
    private BinaryImage convexHullImage = null;
    private BinaryImage filteredImage = null;
    CriteriaCollection cc;
    
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
