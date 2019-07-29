package Model;


public class Bird {
	
	int bird_y;
	
	public Bird() {
		
	}
	
	public void falling(int speed) {
		this.bird_y -= speed;
	}
	
	public int getBirdY() {
		return bird_y;
	}
	
	public void reset() {
		bird_y = 200;
	}
	
	
	
}