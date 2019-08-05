package Model;

import View.MyPanel;

public class Stage{
	
	private Bird flappy;
	private Pipe pipe;
	private int speed, f_speed;
	private int event;
	private MyPanel painter;
	

	boolean start = false;
	
	public int bird_size = 50;
	public int bird_w = 135;
	public int pipe_w = 185;
	public int pipe_e_w = 195;
	public int pipe_end_h = 70;
	public int ground = 214;
	
	public Stage() {
		
		restart();
		}
	
	public void restart() {
		
		speed =  7;
		f_speed = 3;
		pipe = new Pipe();
		pipe.randomPipe();
		
		flappy = new Bird();
		flappy.reset();
		
	}
	
	public void setPainter(MyPanel p) {
		painter = p;
	}

	
	public Bird getBird() {
		return flappy;
	}
	
	public Pipe getPipe() {
		return pipe;
	}
	
	public void letsstart() {
		start = true;
	}
	
	public void game_loop() {
		
		boolean lose = false;
		start = false;
		double FRM = 16;
		double prev = System.currentTimeMillis();
		double current;
		double frm=0;
		double st = 0;
		
		int x = flappy.getBirdX();
		int y = flappy.getBirdY();
		
		
		flappy.bird_x = 0;
		
		while(!start && !lose) {
			
			
			current = System.currentTimeMillis();
			double elapse = current - prev;	
			
			
			lose = painter.checkColision();
			
			if(flappy.getBirdY() >  y && frm>FRM) event++;
			
			if(event>0) processInput();
			else updateF( (frm > FRM? 1:0) );
			
			if( frm > FRM && flappy.bird_x < x) {
				flappy.bird_x += speed;
			}
			
			frm = ( frm > FRM? 0 : frm + elapse);

			painter.odswiez();
			
			
			prev = current;
			
		}
		
		flappy.reset();
		
		while(!lose) {		
			lose = painter.checkColision();
			current = System.currentTimeMillis();
			double elapse = current - prev;	
			updateP( (frm > FRM? 1:0) );
			if(event>0) processInput();
			else updateF( (frm > FRM? 1:0) );
			frm = ( frm > FRM? 0 : frm + elapse);

			painter.odswiez();
			
			
			prev = current;
		}
	
		f_speed = f_speed*2;
		speed = 4 ;
		flappy.flap(7);
		painter.odswiez();
		
		while(flappy.bird_y < 1000) {
			
			current = System.currentTimeMillis();
			double elapse = current - prev;	
			
			updateF( (frm > FRM? 1:0) );
			updateP( (frm > FRM? 1:0) );
			painter.odswiez();
			
			frm = ( frm > FRM? 0 : frm + elapse);
			
			prev = current;
		}
		
	}
	
	public void processInput() {
		flappy.flap(speed*event);
		event = 0;
	}
	
	public void newEvent() {
		event++;
	}
	
	
	public void updateP(double sp) {
		
		pipe.movePipe((int)(sp*speed));
		
		
	
	}
	
	public void updateF(double sp) {
		flappy.falling((int)(sp*f_speed));
	}
	
	
	
	
}