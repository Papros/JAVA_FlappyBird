package Model;

import java.util.Random;

public class Pipe {

	private int up_part;
	private int space;
	
	private int pipe_x;

	
	public Pipe() {
		space = 250;
	}
	
	public int getPipeDownPartHeight() {
		return up_part+space;
	}
	
	public int getPipeUpPArtHeight() {
		return up_part;
	}
	
	public int getSpace() {
		return space;
	}
	
	public int getX() {
		return pipe_x;
	}
	
	public void setPipeX(int x) {
		pipe_x = x;
	}
	
	public void movePipe(int speed) {
		this.pipe_x -= speed;
		if(pipe_x<=-20) randomPipe();
	}
	
	public void randomPipe() {
		 pipe_x = 1000;
	
		 Random generator = new Random();
		 up_part = generator.nextInt(400)+200;
		 
	}
}
