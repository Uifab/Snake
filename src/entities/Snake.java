package entities;

import game.Game;
import javafx.scene.paint.Color;

public class Snake {
	
	private static int width  = 50;
	private static int height = 50;
	private int velocity = 50;
	private Color color;
	
	private int x;
	private int y;
	
	private int moveX;
	private int moveY;

	public Snake(int inX, int inY) {
		System.out.println("New Snake at (" + inX + ", "+ inY +")");
		
		this.x = inX;
		this.y = inY;
		
		this.color = new Color(Math.random(), Math.random(), Math.random(),1);
	}
	
	
	//Get propreties
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public static int getWidth() {
		return width;
	} 
	public static int getHeight() {
		return height;
	}
	
	public int getVelocity() {
		return this.velocity;
	}
	
	
	
	public Color getColor() {
		
		return this.color;
	}
	
	
	/*
	 * Move
	 * In
	 * 		Where = 1 	- up
	 * 				2	- right
	 * 				3 	- down
	 * 				4	- left
	 * 
	 * */
	public void move() {
		
		//this.checkColision();
		
		if( this.wallHit() ) {
			System.out.println("WallHit");
			return ;
		}
		
		
		//Up
		if( this.moveY == -1 ) {
			this.y -= this.velocity;
		}
		
		if( this.moveX == 1 ) {
			//Right
			this.x += this.velocity;
		}
		
		if( this.moveY == 1 ) {
			//Down
			this.y += this.velocity;
		
		}else if( this.moveX == -1 ) {
			//Left
			this.x -= this.velocity;
		}
		
	}
	
	public void setMoveDirection(int where) {
		
		//Up
		if( where == 1 ) {
			this.moveY = -1;
			this.moveX = 0;
		}else if( where == 2 ) {
			//Right
			this.moveX = 1;
			this.moveY = 0;
		
		}else if( where == 3 ) {
			//Down
			this.moveY = 1;
			this.moveX = 0;
		
		}else if( where == 4 ) {
			//Left
			this.moveX = -1;
			this.moveY = 0;
		}
		
	}
	
	
	public boolean checkPlayer() {
		
		//this.wallHit();
		
		return false;
	}
	
	public void checkColision() {
		
		
		
	} 
	
	public boolean  wallHit() {
		
		//Top
		if( this.moveY == -1 && this.y - this.velocity < 0 ) {
			System.out.println( this.toString() );
			this.moveY = 0;
			return true;
		}
		//Right
		if( this.moveX == 1 && this.x + this.velocity > Game.getWindowWidth() - width ) {
			this.moveX = 0;
			return true;
		}
		//Bottom
		if( this.moveY == 1 && this.y + this.velocity > Game.getWindowHeight() - height ) {
			this.moveY = 0;
			return true;
		}
		//Left
		if( this.moveX == -1 && this.x - this.velocity < 0 ) {
			this.moveX = 0;
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		return "Snake( x=" + this.x + ", "
					+ "y=" + this.y + ", "
					+ "velocity=" + this.velocity + ", "
					+ "vY=" + this.moveY + ", "
					+ "vX=" + this.moveX + ")";
	}
	
}
