/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omgagfx;

import javafx.scene.image.Image;

/**
 *
 * @author Ben
 */
public class Animation {
    
    private Image[] frames;
    private double frameDuration;
    
    public Image getFrame(double time)
    {
	int index = (int)((time % (frames.length * frameDuration)) / frameDuration);
	return frames[index];
    }
    
    Animation(Image[] frames, double fd)
    {
	this.frames = frames;
	this.frameDuration = fd;
    }
}
