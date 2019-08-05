package Model;

import View.MyFrame;
import java.awt.EventQueue;

	public class Game {
		
		public static void main(String[] args) {
		
			Stage s = new Stage();
			
			MyFrame frame = new MyFrame(s);
			
			while(true) {
			s.restart();
			s.game_loop();
			}
	}

}
