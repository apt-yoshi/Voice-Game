package edu.wpi.mams.cs.tan_project;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Board extends JPanel implements Functions {

	private Timer timer;
	private String message = "Game Over";
	private Ball ball;
	private Wall wall;
	private boolean ingame = true;
	private ArrayList<Wall> walls;

	public Board() {
		initBoard();
	}

	private void initBoard() {
		setFocusable(true);

		setDoubleBuffered(true);
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), DELAY, PERIOD);

	}

	public void addNotify() {

		super.addNotify();
		try {
			gameInit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void gameInit() throws Exception {
		ball = new Ball();
		walls = new ArrayList<Wall>();
		for(int i = 20; i < 550; i += 10) {
			walls.add(new Wall(i,10,10,10));
			walls.add(new Wall(10,i,10,10));
			walls.add(new Wall(i,550,10,10));
			walls.add(new Wall(550,i,10,10));
		}
		wall = new Wall(10, 10, 10,10);
		
		
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		 if (ingame) {
	            
	            drawObjects(g2d);
	        } 
		 else {

	            gameFinished(g2d);
	        }

	        Toolkit.getDefaultToolkit().sync();

	}

	private void drawObjects(Graphics2D g2d) {
		
//		g2d.setColor(Color.black);
//		g2d.fillOval(300, 550,ball.getwidth(), ball.getheight());
		g2d.setColor(Color.blue);
		g2d.fillOval(ball.getX(), ball.getY(),ball.getwidth(), ball.getheight());
		g2d.setColor(Color.black);
//		for(int i = 20; i < 600; i += 10) {
//			g2d.fillRect(i, 10, 10, 10);
//			g2d.fillRect(10, i, 10, 10);	
//		}
		for(int i = 0; i < walls.size(); i ++) {
			g2d.fillRect(walls.get(i).getX(), walls.get(i).getY(), walls.get(i).getWidth(), walls.get(i).getHeight());
		}
		
	}

	private void gameFinished(Graphics2D g2d) {

		Font font = new Font("Verdana", Font.BOLD, 18);
		FontMetrics metr = this.getFontMetrics(font);

		g2d.setColor(Color.BLACK);
		g2d.setFont(font);
		g2d.drawString(message,
				(Functions.WIDTH - metr.stringWidth(message)) / 2,
				Functions.WIDTH / 2);
	}
	
	private class ScheduleTask extends TimerTask{
		public void run(){
			try {
				ball.move();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
			
	         checkCollision();
	         repaint();
		}
	}

	private void stopGame() {
		ingame = false;
		timer.cancel();
	}

	private void checkCollision() {
//		int j = 0;
//		if (ball.getY()+ball.getheight() > Functions.BOTTOM_EDGE) {
//			ball.setXDir(1);
//			ball.setYDir(1);
//		}
		for(int i=0; i<walls.size();i++) {
			if(walls.get(i).getX()+walls.get(i).getWidth() == ball.getX() && walls.get(i).getY() == ball.getY()) {
				ball.setX(walls.get(i).getX()+walls.get(i).getWidth());
				ball.setY(walls.get(i).getY()+walls.get(i).getHeight());
			}
			if(walls.get(i).getX()+walls.get(i).getWidth() == ball.getX() && !(walls.get(i).getY()==ball.getY())) {
				
			}
			if(walls.get(i).getX()+walls.get(i).getWidth() == ball.getX() && !(walls.get(i).getY()==ball.getY())) {
	
			}
			
		}
		
	}

}
