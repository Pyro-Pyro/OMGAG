/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omgagfx;

import java.awt.Point;
import java.util.HashMap;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author Ben
 */
public class Renderer extends Canvas{
    
    //For access to the current game state
    Game game;
    
    //image and animation storage
    HashMap<String, Image> images;
    HashMap<String, Animation> animations;
    
    //Do I really need to say what this is?
    //fine, it's a graphicsContext object, basically the same as a Graphics2D Object from swing
    GraphicsContext gc;
    
    //anchor points for the background image, state where the corners of the map are on the image
    //t stands for top, b stands for bottom, l for left and r for right
    Point tl,tr,bl,br;
    
    Renderer(Game game, int x, int y)
    {
	super(x,y);
	images = new HashMap();
	animations = new HashMap();
	initialiseImages();
	initialiseAnimations();
	this.game = game;
	gc = getGraphicsContext2D();
	
	tl = new Point(410,575);
	tr = new Point(1090,575);
	bl = new Point(255,1230);
	br = new Point(1255,1230);
    }
    
    private void initialiseImages()
    {
	Image back = new Image("res/background.png");
	images.put("background", back);
    }
    private void initialiseAnimations()
    {
	Image [] walk = new Image[31];
	for (int i = 1; i < 32; i++)
	{
	    String s = "res/walking animation/walk_basic00";
	    if(i < 10)
		s += '0';
	    s += i + ".png";
	    walk[i-1] = new Image(s);
	}
	Animation player = new Animation(walk,0.04);
	
	animations.put("player", player);
    }
    
    public void render(double t)
    {
	drawBackground();
	drawPlayer(t);
    }
    
    private void drawBackground()
    {
	gc.drawImage(images.get("background"), 0, -400);
    }
    
    private void drawPlayer(double t)
    {
	gc.drawImage(animations.get("player").getFrame(t), game.player.x, game.player.y, game.player.width, game.player.height);
    }

    
}
