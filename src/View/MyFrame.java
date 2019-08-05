package View;

import Control.Controller;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import Model.Stage;

public class MyFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image ImageIcon;
	MyPanel obrazPanel;
	Stage stage;
	Controller kontroler;

	public MyFrame(Stage st) {
		super("Flappy Bird");
		this.stage = st;
		ImageIcon = Toolkit.getDefaultToolkit().getImage(MyFrame.class.getResource("/images/icon.png"));
		obrazPanel = new MyPanel(st);
		obrazPanel.setFrame(this);
		obrazPanel.start();
		st.setPainter(obrazPanel);
		kontroler = new Controller(st);
		addKeyListener(kontroler);
		setResizable(true);
		add(obrazPanel);
		initComponents();;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocation(0,0);
		st.game_loop();
	}
	

	private void initComponents() {  //wczytywanie ikony programu
		setIconImage(ImageIcon); 
	}
	
}