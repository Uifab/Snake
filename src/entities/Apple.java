package entities;

import game.Game;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Apple {
	
	private int x;
	private int y;
	private Color color = Color.RED;
	
	private static int width  = 50;
	private static int height = 50;
	
	public Apple(int inX, int inY) {
		x = inX;
		y = inY;
	}
	
	public Apple(Point2D point) {
		
		x = (int) point.getX();
		y = (int) point.getY();
		
	}
	public Apple() {
		Point2D point = Game.getRandomPoint();
		x = (int) point.getX();
		y = (int) point.getY();
	}
	
	
	public Point2D getPoint() {
		return new Point2D( this.x, this.y );
	}
	
	public void printApple(GraphicsContext gc) {
		
		gc.setFill( this.color );
		gc.fillRect( this.x, this.y, this.width, this.height );
		
	}
	
	public void respawn() {
		Point2D point = Game.getRandomPoint();
		x = (int) point.getX();
		y = (int) point.getY();
	}
	
	public String toString() {
		return "Apple( ("+x+", "+y+"), ";
	}
	
}
