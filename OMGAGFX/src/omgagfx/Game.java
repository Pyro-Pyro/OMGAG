/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omgagfx;

import java.awt.Dimension;
import java.util.ArrayList;

/**
 *
 * @author Ben
 */
public class Game {
    
    public boolean left,right,up,down,boost;
    
    public Dimension boardSize;
    
    Player player;
    GameObject camera;
    
    ArrayList<Ghost> ghosts;
    
    GameObject thing;
    
    Game()
    {
	boardSize = new Dimension(500,500);
	player = new Player(250,250, this);
	camera = new GameObject(0,0,0,0,this) {

	    @Override
	    public void update(double delta) {
		this.x = player.getX();
		this.y = player.getY();
	    }
	};
	ghosts = new ArrayList();
	
	thing = new GameObject(100,100,100,100,this) {

	    @Override
	    public void update(double delta) {
		
	    }
	};
    }
    
    public void update(double delta)
    {
	player.update(delta);
	camera.update(delta);
    }
    
}
