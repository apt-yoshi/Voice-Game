
/*Author: Patrick Tan
 * Date: 1/9/2018
 * The final Game
 */
package edu.wpi.mams.cs.tan_project;


import java.awt.EventQueue;
import javax.swing.JFrame;
public class Game extends JFrame{
	
	
	public Game(){
		initUI();
	}
	private void initUI(){
		add(new Board());
		setTitle("Alabaster");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Functions.WIDTH, Functions.HEIGTH);
		setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Game breakout = new Game();
				breakout.setVisible(true);
			}
		});
	}

}
