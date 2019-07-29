package Model;

public class Stage{
	
	private Bird flappy;
	private Pipe pipe;
	
	
	public Stage() {
		
		pipe = new Pipe();
		pipe.randomPipe();
		
		flappy = new Bird();
		flappy.reset();
	}
	
	public void play() {
		flappy.falling(5);
		pipe.movePipe(3);
	}
	
	public Bird getBird() {
		return flappy;
	}
	
	public Pipe getPipe() {
		return pipe;
	}
	
	
}