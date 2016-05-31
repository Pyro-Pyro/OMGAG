/*
 * 
 */
package omgagfx;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
	
	Canvas canvas = new Canvas(1000,1000);
	root.getChildren().add(canvas);
	
	GraphicsContext gc = canvas.getGraphicsContext2D();
	
	gc.setFill(Color.BLUE);
	gc.setStroke(Color.BLACK);
	gc.setLineWidth(2);
	Font font = Font.font("Times New Roman", FontWeight.THIN, 48);
	gc.setFont(font);
	gc.fillText("OMGAG TEST", 60, 50);
	gc.strokeText("OMGAG TEST", 60, 50);
	
	Animation a = new Animation();
	a.frameDuration = 0.05;
	Image[] ia = new Image[40];
	for (int i = 0; i < 40; i++) {
	    String s = "res/walking animation/main walk00";
	    if(i < 9)
	    {
		s += '0';
	    }
	    int j = i + 1;
	    s = s + j + ".png";
	    System.out.println(s);
	    ia[i] = new Image(s);
	}
	a.frames = ia;
	
	final long startNanoTime = System.nanoTime();
	
	AnimationTimer at = new AnimationTimer(){
	    
	    
	    long LastUpdate = 0;
	    int fps = 0;
	    
	    @Override
	    public void handle(long currentNanoTime) {
		double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
		
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		fps++;
		gc.drawImage(a.getFrame(t), 50, 50, 200, 200);
		
		if(LastUpdate - currentNanoTime < -1000000000)
		{
		    System.out.println("FPS: " + fps);
		    fps = 0;
		    LastUpdate = currentNanoTime;
		}
		
	    }
	};
	
	at.start();
	
	stage.show();
    }
    
}
