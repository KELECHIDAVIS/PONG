package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle extends Rectangle 
{
	private int id=0;  // this decides which player the paddle is 
	
	
	private int ySpeed; 
	public Paddle(int x,int y,int width,int height,int id) 
	{
		super(x,y,width,height); 
		this.id = id ; 
		
	}
	public void draw(Graphics g)
	{
		
		if(this.id ==1)
		{
			g.setColor(Color.RED); 
		}else
		{
			g.setColor(Color.BLUE); 
		}
		
		g.fillRect(x, y, width, height);
		
	}
}
