package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends Rectangle 
{
	
	
	public Ball(int x, int y , int width ,int height )
	{
		super(x,y,width,height); 
		
	}
	public  void draw(Graphics g) 
	{
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}
}
