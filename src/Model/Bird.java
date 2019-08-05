package Model;


public class Bird {
	
	int bird_y;
	int bird_x;
	int power;
	int flap_power;
	int start_falling;
	int wing = 0;
	
	
	public Bird() {
		
	}
	
	public void falling(int speed) {
		nextWing();
		
		if(power <= 0) {
			
			if(bird_y > start_falling +100) bird_y+= 1.5*speed;
			bird_y += speed;
			
		}
		else {
			
			bird_y -= flap_power*power;
			power = 0;
			start_falling = bird_y;
		}
		
	}
	
	public int getBirdY() {
		return bird_y;
	}
	
	public int getBirdX() {
		return bird_x;
	}
	
	public void reset() {
		bird_x = 200;
		bird_y = 300;
		flap_power = 4;
	}
	
	public void nextWing() {
		
		if(wing == 1) wing = 2;
		else
		if(wing == 2) wing = 3;
		else
		if(wing == 3) wing = 0;
		else
		if(wing == 0) wing = 1;
		
	}
	
	public int getWing() {
		return wing;
	}
	
	public void flap(int speed) {
		power = power + flap_power*speed;
	}
	
	
	
}