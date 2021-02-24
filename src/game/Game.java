package game;


import entities.Apple;
import entities.Snake;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Point2D;

public class Game {
	
	//Player
	private Snake player;
	private Apple apple;
	
	//Game settings
	private static int windowWidth = 800;
	private static int windowHeight = 800;
	
	
	//Game Background
	private Color background = Color.WHITE;
	
	public Game() {
		
	}
	
	public void Start() {
		
		player = new Snake(100, 100);
		apple = new Apple();
		
		
	}
	
	public void Restart() {
		System.out.println("Restart");
		Start();
	}
	
	
	public void handleKeyPress( KeyEvent event ){
		
		System.out.println( "Key pressed " + event.getCode() );
		
		if( event.getCode().equals(KeyCode.R) ) {
			this.Restart();
		}
		
		//In game
		if( this.player != null ) {
			
			
			if( event.getCode().equals( KeyCode.UP ) ) {
				this.player.setMoveDirection(1);
				
			}else if( event.getCode().equals( KeyCode.RIGHT ) ) {
				this.player.setMoveDirection(2);
				
			}else if( event.getCode().equals( KeyCode.DOWN ) ) {
				this.player.setMoveDirection(3);
				
			}else if( event.getCode().equals( KeyCode.LEFT ) ) {
				this.player.setMoveDirection(4);
				
			}
		}
		
	}
	
	
	//Where the magic happens
	public void gameTick(GraphicsContext gc) {
		
		player.move();
		player.eat(apple);
		
		
		//Check player
		if( player.checkPlayer() ) {
			this.Restart();
		}
		
		this.printBackground(gc);
		
		//Print player
		player.printSnake(gc);
		
		apple.printApple(gc);
		
		this.printScore(gc,player.getScore());
		
	}
	
	public void printBackground(GraphicsContext gc) {
		
		int i,j;
		
		
		for( i = 0; i < getWindowHeight(); i += Snake.getHeight()  ) {
			for( j = 0; j < getWindowWidth(); j+= Snake.getWidth()  ) {
				if( (i + j)/Snake.getHeight() % 2 == 1  )
					gc.setFill(Color.ALICEBLUE);
				else
					gc.setFill(Color.WHITE);
				
				gc.fillRect(i, j, Snake.getHeight(), Snake.getWidth());
				
			}
		}
		
	}
	
	
	//Get window width
	public static int getWindowWidth() {
		return windowWidth;
	}
	//Get window height
	public static int getWindowHeight() {
		return windowHeight;
	}
	
	
	public static Point2D getRandomPoint() {
		
		int x = (int)(Math.random() * Game.windowWidth / Snake.getWidth()) * Snake.getWidth();
		int y = (int)(Math.random() * Game.windowHeight/ Snake.getHeight())* Snake.getHeight();
		
		Point2D randomPoint = new Point2D( x, y);
		
		return randomPoint;
	}
	
	
	public void printScore( GraphicsContext gc, int score ) {
		
		gc.setTextAlign(TextAlignment.RIGHT);;
        gc.strokeText("Score : "+score, 770, 30);
		
	}

}
