/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omgagfx;

import javafx.scene.canvas.Canvas;

/**
 *
 * @author Ben
 */
public class Renderer extends Canvas{
    
    Game game;
    
    Renderer(Game game)
    {
	super();
	this.game = game;
    }
    
}
