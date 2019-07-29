package Model;

public class Pipe {

	private int space_height;
	private int space;
	
	private int pipe_x;

	
	public Pipe() {
		
	}
	
	public int getPipeDownPartHeight() {
		return space_height;
	}
	
	public int getPipeUpPArtHeight() {
		return space_height-space;
	}
	
	public int getSpace() {
		return space;
	}
	
	public int getX() {
		return pipe_x;
	}
	
	public void movePipe(int speed) {
		this.pipe_x -= speed;
	}
	
	public void randomPipe() {
		pipe_x = 300;
		space = 150;
		space_height = 147;
	}
}
