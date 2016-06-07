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
    //the maths here are designed to work just for perfect trapeziums... with the bottom edge being longer than the top.
    Point tl,tr,bl,br;
    
    public double getBackgroundHeight()
    {
	return bl.y - tl.y;
    }
    
    public double getBackgroundWidth(double y)
    {
	double x = tr.x - tl.x;
	
	double xoffset = tl.x - bl.x;
	
	double scale = xoffset/getBackgroundHeight();
	
	double newXOffset = y * scale;
	
	x = x + (2*newXOffset);
	
	return x;
    }
    
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
	
	Image ghd = new Image("res/ghost/GhostHeadDark.png");
	images.put("ghostHeadDark", ghd);
	
	Image ghl = new Image("res/ghost/GhostHeadLight.png");
	images.put("ghostHeadLight", ghl);
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
	gc.clearRect(0, 0, getWidth(), getHeight());
	drawBackground();
	drawPlayer(t);
    }
    
    private final double backgroundScale = 2;
    private void drawBackground()
    {
	Image back = images.get("background");
	double yoffset = getBackgroundHeight() * (game.camera.y/game.boardSize.getHeight());
	double x = bl.x + backgroundExcess(yoffset) + (getBackgroundWidth(yoffset) * (game.camera.x/game.boardSize.getWidth()));
	double y = tl.y + ((game.camera.y/game.boardSize.getHeight()) * getBackgroundHeight());
	gc.drawImage(back, ((-x) * backgroundScale) + getWidth()/2, ((-y) * backgroundScale) + getHeight()/2,backgroundScale * back.getWidth(),backgroundScale * back.getHeight());
    }
    
    private void drawPlayer(double t)
    {
	gc.fillRect(this.getWidth()/2 + (game.player.x - game.camera.x) - 50, this.getHeight()/2 + (game.player.y - game.camera.y) - 50, 100, 100);
	//gc.drawImage(animations.get("player").getFrame(t), game.player.x, game.player.y, game.player.width, game.player.height);
    }
    
    public double backgroundExcess(double y)
    {
	double xoffset = tl.x - bl.x;
	
	double scale = xoffset/getBackgroundHeight();
	
	double newXOffset = y * scale;
	
	return xoffset -  newXOffset;
	
    }
    
    private void drawGhost(Ghost g, double t)
    {
	double boundary = 100;
	
	double distance = Math.abs(game.player.x - g.x) + Math.abs(game.player.y - g.y);
	
	double x = getWidth()/2 + this.getBackgroundWidth(t);
	
	Image ghl = images.get("ghostHeadLight");
	gc.drawImage(ghl, 0, 0, 200, 200);
	
	gc.setGlobalAlpha(distance/boundary);
	Image ghd = images.get("ghostHeadDark");
	gc.drawImage(ghd, 0, 0, 200, 200);
	gc.setGlobalAlpha(1);
    }
    

    
}
