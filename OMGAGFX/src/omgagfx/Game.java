/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omgagfx;

import java.awt.Dimension;

/**
 *
 * @author Ben
 */
public class Game {
    
    public boolean left,right,up,down;
    
    public Dimension boardSize;
    
    Player player;
    
    Game()
    {
	boardSize = new Dimension(500,500);
	player = new Player(250,250, this);
    }
    
    public void update(double delta)
    {
	player.update(delta);
    }
    
}
