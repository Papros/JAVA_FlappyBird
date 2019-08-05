package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Stage;

public class Controller implements KeyListener{
	
	Stage stage;
	boolean released;
	
	public Controller(Stage st) {
		released = true;
		stage = st;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		stage.letsstart();
		System.out.print("start");
		if(released) {
		//stage.getBird().flap(7);
		stage.newEvent();
		released = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		released = true;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}