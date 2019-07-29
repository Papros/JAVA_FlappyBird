package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import Model.Stage;

public class MyPanel extends JPanel {
	
	Stage stage;
	MyFrame MyOwnFrame;
	private Image background; 
	private Image bird; 
	private Image pipe;
	private Image pipe2;
	private Image pipe_end;
	
	private boolean kon = false;
	private int width = 425;
	private int height = 700;
	
	int bird_size = (int)(width/4);
	int pipe_widht = (int)(width*0.37*0.5);
	int pipe_end_w = (int)(width*0.18), pipe_end_h = height / 15;
	int ground = (int)(height/4.67);
	int margin = (int) ( pipe_end_w - pipe_widht) / 2;
	
	public MyPanel(Stage s){
		this.stage = s;
		setPreferredSize(new Dimension(width,height));
	}
	
	public void start() {
		
		wczytaj();
		
	}
	
	
	
	private void checkWindowsSize() {
		int a = MyOwnFrame.getHeight();
		int b = MyOwnFrame.getWidth();
		if(a != height || b != width) {
			height = (int) (a / 1.6);
			width = b;
			start();
		}
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(background,0,0,this);
		g2d.drawImage(bird,0,stage.getBird().getBirdY(),this);
		pipe = pipe.getScaledInstance(pipe_widht, stage.getPipe().getPipeDownPartHeight(), 1);
		pipe2 = pipe2.getScaledInstance(pipe_widht,stage.getPipe().getPipeUpPArtHeight(),1);
		
		g2d.drawImage(pipe,stage.getPipe().getX(),height-stage.getPipe().getPipeDownPartHeight()-ground,this);
		g2d.drawImage(pipe2,stage.getPipe().getX(),stage.getPipe().getPipeUpPArtHeight()-ground,this);
		
		g2d.drawImage(pipe_end,stage.getPipe().getX()-margin,height-stage.getPipe().getPipeDownPartHeight()-ground,this);
		g2d.drawImage(pipe_end,stage.getPipe().getX()-margin,stage.getPipe().getPipeUpPArtHeight()-pipe_end_h,this);
		//g2d.drawImage(pipe_end,298,100,this);
	}
	
	
	
	public void setFrame(MyFrame fr) {
	this.MyOwnFrame = fr;
	}
	
	
	public void odswiez() {
		repaint();
	}
	
	
	private void wczytaj(){
		
		
		try {	
			background =  ImageIO.read(MyPanel.class.getResource("/images/background.png")).getScaledInstance(width, height,1);
			bird = ImageIO.read(MyPanel.class.getResource("/images/bird.png")).getScaledInstance( bird_size,bird_size,1);
			pipe = ImageIO.read(MyPanel.class.getResource("/images/pipe.png")).getScaledInstance(pipe_widht,400,1);
			pipe2 = ImageIO.read(MyPanel.class.getResource("/images/pipe.png")).getScaledInstance(pipe_widht, 400,1);
			pipe_end = ImageIO.read(MyPanel.class.getResource("/images/pipe_end.png")).getScaledInstance(pipe_end_w, pipe_end_h,1);

			
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		
	}
	
	
	private Image ubierz(int n) {
		
		return bird;
	}

}
