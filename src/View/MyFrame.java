package View;

import Control.Controller;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import Model.Stage;

public class MyFrame extends JFrame{
	
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
		kontroler = new Controller(st);
		//addKeyListener(kontroler);
		//addMouseListener(kontroler);
		setResizable(true);
		add(obrazPanel);
		initComponents();;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocation(0,0);
	}
	

	private void initComponents() {  //wczytywanie ikony programu
		setIconImage(ImageIcon); 
	}
	
}