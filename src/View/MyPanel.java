package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import Model.Stage;

public class MyPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Stage stage;
	MyFrame MyOwnFrame;
	private Image background; 
	private Image bird; 
	private Image pipe;
	private Image pipe2;
	private Image pipe_end;
	
	private Image[] wing = new Image[4];
	
	private int width = 600;// 425;
	private int height =1000;// 700;
	
	int bird_size,bird_width;
	int pipe_width;
	int pipe_end_w,pipe_end_h; 
	int ground;
	int margin;
	
	int pipe_down;
	int pipe_up;
	int space;
	int bird_h;
	int bird_x;
	int pipe_x;
	
	public MyPanel(Stage s){
		this.stage = s;
		setPreferredSize(new Dimension(width,height));
		
		
		bird_size = (height*stage.bird_size/1000);
		bird_width = (width*stage.bird_w/1000);
		pipe_width = (int)(width*stage.pipe_w/1000);
		pipe_end_w = (int)(width*stage.pipe_e_w/1000);
		pipe_end_h = height *  stage.pipe_end_h/1000;
		ground = (int)(height*stage.ground/1000);
		margin = (int) ( pipe_end_w - pipe_width) / 2;
		
	}
	
	public void start() {
		
		wczytaj();
		
	}
	
	public boolean checkColision() {
			
			
			if( stage.getBird().getBirdY()+stage.bird_size >1000- stage.ground   ) {
			
				return true;
			}
			
			if( stage.getPipe().getX() <= stage.getBird().getBirdX() +stage.bird_w
					&& (
					  bird_h < pipe_up 
							|| bird_h+bird_size > pipe_up+space )  ){
					
					return true;
			}
			
			
			return false;
		}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		pipe_down =(1000-stage.getPipe().getPipeUpPArtHeight()-stage.getPipe().getSpace())*(height-ground)/1000;
		pipe_up = stage.getPipe().getPipeUpPArtHeight()*(height-ground)/1000;
		space = stage.getPipe().getSpace()*height/1000;
		bird_h = stage.getBird().getBirdY()*height/1000;
		bird_x = stage.getBird().getBirdX()*width/1000;
		pipe_x = stage.getPipe().getX()*width/1000;
		
		if(pipe_down+space+pipe_up>height-ground) pipe_down = pipe_down - (pipe_down+space+pipe_up+ground- height);
		
		
		g2d.drawImage(background,0,0,this);
		
		pipe = pipe.getScaledInstance(pipe_width,pipe_up, 1);
		pipe2 = pipe2.getScaledInstance(pipe_width,pipe_down,1);
		
		g2d.drawImage(pipe2,pipe_x,pipe_up+space,this);
		g2d.drawImage(pipe,pipe_x,0,this);
		
		g2d.drawImage(pipe_end,pipe_x-margin,pipe_up-pipe_end_h,this);
		g2d.drawImage(pipe_end,pipe_x-margin,pipe_up+space ,this);
		
		g2d.drawImage(bird,bird_x,bird_h,this);
		
		g2d.drawImage(wing[stage.getBird().getWing()],bird_x,bird_h,this);
		/*
		g2d.setColor(Color.red);
		g2d.drawLine(bird_x,bird_h,700,bird_h);
		g2d.drawLine(bird_x,bird_h+bird_size,700,bird_h+bird_size);
		g2d.setColor(Color.blue);
		
		g2d.drawLine(0,pipe_up,7000,pipe_up);
		g2d.drawLine(0,pipe_up+space,7000,pipe_up+space);
		
		g2d.drawLine(pipe_x, 0, pipe_x, 700);
		 */
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
			bird = ImageIO.read(MyPanel.class.getResource("/images/bird.png")).getScaledInstance( bird_width,bird_size,1);
			pipe = ImageIO.read(MyPanel.class.getResource("/images/pipe.png")).getScaledInstance(pipe_width,400,1);
			pipe2 = ImageIO.read(MyPanel.class.getResource("/images/pipe.png")).getScaledInstance(pipe_width, 400,1);
			pipe_end = ImageIO.read(MyPanel.class.getResource("/images/pipe_end.png")).getScaledInstance(pipe_end_w, pipe_end_h,1);

			wing[0] = ImageIO.read(MyPanel.class.getResource("/images/wing_1.png")).getScaledInstance( bird_width,bird_size,1);
			wing[1] = ImageIO.read(MyPanel.class.getResource("/images/wing_2.png")).getScaledInstance( bird_width,bird_size,1);
			wing[2] = ImageIO.read(MyPanel.class.getResource("/images/wing_3.png")).getScaledInstance( bird_width,bird_size,1);
			wing[3] = ImageIO.read(MyPanel.class.getResource("/images/wing_2.png")).getScaledInstance( bird_width,bird_size,1);
		
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		
	}
	
	
	@SuppressWarnings("unused")
	private Image ubierz(int n) {
		
		return bird;
	}

}
