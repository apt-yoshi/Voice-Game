package edu.wpi.mams.cs.tan_project;


/*Author: Patrick Tan
 * Date: 5/9/2017
 * These are constants responsible for much of the actions in the game
 */
public interface Functions {
	//dimensions of the board
	public static final int WIDTH = 600;
    public static final int HEIGTH = 600;
    //extent at which the ball can go
    public static final int BOTTOM_EDGE = 590;
    //N of bricks
    public static final int N_OF_BRICKS = 30;
    //coordinates of paddle
    public static final int INIT_PADDLE_X = 300;
    public static final int INIT_PADDLE_Y = 660;
    //coordinates of ball
    public static final int INIT_BALL_X = 300;
    public static final int INIT_BALL_Y = 540;    
    //the two below could be left out
    //delay in execution millsecs.
    public static final int DELAY = 1000;
    //time between game cycles
    public static final int PERIOD = 10;
}
