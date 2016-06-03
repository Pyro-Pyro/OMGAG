/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omgagfx;

/**
 *
 * @author Ben
 */
public abstract class GameObject {
    
    Game game;
    
    public enum type
    {
	Player,
	Enemy
    }
    
    GameObject(double x, double y, double w, double h, Game game)
    {
	this.x = x;
	this.y = y;
	velx = 0;
	vely = 0;
	this.height = h;
	this.width = w;
	this.game = game;
    }
    
    //the x,y, x velocity, y velocity, object width and object height in game units.
    protected double x, y, velx, vely, width, height;

    public double getX() {
	return x;
    }

    public void setX(double x) {
	this.x = x;
    }

    public double getY() {
	return y;
    }

    public void setY(double y) {
	this.y = y;
    }

    public double getVelx() {
	return velx;
    }

    public void setVelx(double velx) {
	this.velx = velx;
    }

    public double getVely() {
	return vely;
    }

    public void setVely(double vely) {
	this.vely = vely;
    }

    public double getWidth() {
	return width;
    }

    public void setWidth(double width) {
	this.width = width;
    }

    public double getHeight() {
	return height;
    }

    public void setHeight(double height) {
	this.height = height;
    }
    
    public abstract void update(double delta);
    
    protected void updatePosition(double delta)
    {
	x = x + (velx*delta);
	y = y + (vely*delta);
	
	if(x < 0){x = 0;}
	if(x > game.boardSize.getWidth()){x = game.boardSize.getWidth();}
	if(y < 0){y = 0;}
	if(y > game.boardSize.getHeight()){y = game.boardSize.getHeight();}
	
    }
    
    
}
