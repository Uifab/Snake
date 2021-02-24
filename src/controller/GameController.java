package controller;

import entities.Snake;
import game.Game;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameController {
	
	@FXML
	private VBox vboxCanvas;
	
	private Game game;
	
	private static Snake player;
	
	@FXML
    private void initialize() {
		
		this.run();
		
	}
	
	private void run(){
		
		game = new Game();
		game.Start();
		
		Canvas c = new Canvas(Game.getWindowWidth(), Game.getWindowHeight());
			
		GraphicsContext gc = c.getGraphicsContext2D();
		
		vboxCanvas.getChildren().add(c);
		
		
		new AnimationTimer() {
			
			long lastTick = 0;

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				
				if (lastTick == 0) {
					lastTick = now;
					game.gameTick(gc);
					return;
				}
				
				if (now - lastTick > 1000000000 / 10 ) {
					lastTick = now;
					game.gameTick(gc);
				}
			}
			
		}.start();
		
		
	}
	
	public void restartGame() {
		run();
	}

	
	public void handleOnKeyPressed(KeyEvent event) {
		//Propagate events to game
		game.handleKeyPress(event);
	}
	
}
