/*
 * 
 */
package omgagfx;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Benjamin Johnson
 */
public class OMGAGFX extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
	stage.setTitle("OMGAG");
	
	Group root = new Group();
	Scene scene = new Scene(root);
	stage.setScene(scene);
	Game game = new Game();
	Renderer render = new Renderer(game, 1500, 900);
	root.getChildren().add(render);
	
	final long startNanoTime = System.nanoTime();
	
	scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

	    @Override
	    public void handle(KeyEvent event) {
		switch(event.getCode())
		{
		    case UP: game.up = true; break;
		    case DOWN: game.down = true; break;
		    case RIGHT: game.right = true; break;
		    case LEFT: game.left = true; break;
		    case W: game.up = true; break;
		    case A: game.left = true; break;
		    case S: game.down = true; break;
		    case D: game.right = true; break;
		}
	    }
	});
	
	scene.setOnKeyReleased(new EventHandler<KeyEvent>(){

	    @Override
	    public void handle(KeyEvent event) {
		switch(event.getCode())
		{
		    case UP: game.up = false; break;
		    case DOWN: game.down = false; break;
		    case RIGHT: game.right = false; break;
		    case LEFT: game.left = false; break;
		    case W: game.up = false; break;
		    case A: game.left = false; break;
		    case S: game.down = false; break;
		    case D: game.right = false; break;
		}
		
	    }
	});
	
	AnimationTimer at = new AnimationTimer(){
	    
	    long lastTime = System.currentTimeMillis(); 
	    long lastUpdate = 0;
	    int fps = 0;
	    
	    
	    @Override
	    public void handle(long currentNanoTime) {
		double t = (currentNanoTime - startNanoTime) / 1000000000.0;
		
		long currentMilTime = System.currentTimeMillis();
		//delta is in seconds
		double delta = (double)(currentMilTime - lastTime)/1000;
		lastTime = currentMilTime;
		
		fps++;
		
		game.update(delta);
		render.render(t);
		System.out.println(delta);
		
		if(lastUpdate - currentNanoTime < -1000000000)
		{
		    System.out.println("FPS: " + fps);
		    fps = 0;
		    lastUpdate = currentNanoTime;
		}
		
	    }
	};
	
	at.start();
	
	stage.show();
    }
    
}
