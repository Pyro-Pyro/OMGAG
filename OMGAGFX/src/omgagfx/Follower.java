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
public class Follower extends GameObject{
    
    GameObject target;
    double acceleration, decelleration;

    public Follower(double x, double y, double w, double h, Game game) {
	super(x, y, w, h, game);
    }
    
    public void setTarget(GameObject target)
    {
	this.target = target;
    }
    public void setAcceleration(double acc)
    {
	this.acceleration = acc;
    }
    public void setDecelleration(double dec)
    {
	this.decelleration = dec;
    }

    @Override
    public void update(double delta) {
	
	if(this.getX() > target.getX())
	    {
		if(velx > 0)
		{
		    this.velx = velx - (decelleration*delta);
		}
		else
		{
		    this.velx = velx - (acceleration*delta);
		}
		    
	    }
	    else if(this.getX() < target.getX())
	    {
		if(velx < 0)
		{
		    this.velx = velx + (decelleration*delta);
		}
		else
		{
		    this.velx = velx + (acceleration*delta);
		}
	    }
	    
	    if(this.getY() > target.getY())
	    {
		if(vely > 0)
		{
		    this.vely = vely - (decelleration*delta);
		}
		else
		{
		    this.vely = vely - (acceleration*delta);
		}
	    }
	    else if(this.getY() < target.getY())
	    {
		if(vely < 0)
		{
		    this.vely = vely + (decelleration*delta);
		}
		else
		{
		    this.vely = vely + (acceleration*delta);
		}
	    }
	    
	    this.updatePosition(delta);
    }
    
    
}
