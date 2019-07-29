package Model;

import View.MyFrame;
import java.awt.EventQueue;

	public class Game {
		
		public static void main(String[] args) {
		
			Stage s = new Stage();
			
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MyFrame(s);
			}
		});
	}

}
