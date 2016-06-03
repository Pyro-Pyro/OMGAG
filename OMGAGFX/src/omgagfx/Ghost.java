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
public class Ghost extends Follower {

    public Ghost(double x, double y,Game game) {
	super(x, y, 10, 10, game);
	this.setTarget(game.player);
	this.setAcceleration(20);
	this.setDecelleration(50);
    }
    
    @Override
    public void update(double delta)
    {
	super.update(delta);
	
	
    }
    
    
    
}
