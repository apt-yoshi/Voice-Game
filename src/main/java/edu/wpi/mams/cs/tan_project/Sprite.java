package edu.wpi.mams.cs.tan_project;


/*Author: Patrick Tan
 * Date: 5/9/2017
 * What a sprite yo
 */
import java.awt.Image;
import java.awt.Rectangle;

public class Sprite {
	protected int x;
    protected int y;
    
    protected int width;
    protected int height;
    
    Rectangle rect;
    
    protected Image image;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getwidth() {
		return width;
	}
	public void setwidth(int width) {
		this.width = width;
	}
	public int getheight() {
		return height;
	}
	public void setheight(int height) {
		this.height = height;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
}
