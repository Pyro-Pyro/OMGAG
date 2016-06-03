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
public class Player extends GameObject{
    
    
    
    Player(int x, int y, Game game)
    {
	super(x,y,50,50,game);
	//acc = 5;
	speed = 50;
    }
    
    //maximum velocity in game units per second
    private double speed;
    
    @Override
    public void update(double delta) {
	
	if(game.boost)
	{
	    speed = 100;
	}
	else
	{
	    speed = 50;
	}
	
	if(game.up && !game.down)
	{
	    vely = -speed;
	}
	else if(game.down && !game.up)
	{
	    vely = speed;
	}
	else
	{
	    vely = 0;
	}
	
	
	if(game.left && !game.right)
	{
	    velx = -speed;
	}
	else if(game.right && !game.left)
	{
	    velx = speed;
	}
	else
	{
	    velx = 0;
	}
	
	
	/*if(game.up && !game.down)
	{
	    vely = vely - (delta * acc);
	}
	else if(game.down && !game.up)
	{
	    vely = vely + (delta * acc);
	}
	else if(game.left && !game.right)
	{
	    velx = velx - (delta * acc);
	}
	else if(game.right && !game.left)
	{
	    velx = velx + (delta * acc);
	}
	
	if(velx > maxVel)
	{
	    velx = maxVel;
	}
	if(velx < -maxVel)
	{
	    velx = -maxVel;
	}
	if(vely > maxVel)
	{
	    vely = maxVel;
	}
	if(vely < -maxVel)
	{
	    vely = -maxVel;
	}*/
	
	
	updatePosition(delta);
    }
    
}
