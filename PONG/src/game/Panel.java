package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;



public class Panel extends JPanel implements Runnable 
{
	private static boolean running= true; 
	private Thread gameThread ;
	
	public final int WIDTH=1450, HEIGHT=1000; 
	private final int PADDLEWIDTH=40, PADDLEHEIGHT=175; 
	private int mover1=(HEIGHT/2)-(PADDLEHEIGHT/2), mover2 = (HEIGHT/2)-(PADDLEHEIGHT/2); 
	private  int xspeed=-7, yspeed=7; 
	private int ballx=WIDTH/2, bally=HEIGHT/2; 
	private final int MOVESPEED=40 ; 
	private int p1score=0 , p2score=0; 
	public Paddle p1= new Paddle(WIDTH-PADDLEWIDTH,mover1,PADDLEWIDTH,PADDLEHEIGHT,2), p2=new Paddle(0,mover2,PADDLEWIDTH,PADDLEHEIGHT,1); 
	private Ball ball =new Ball( ballx, bally, 40,40); 
	private String fps="FPS:"; 
	
	private Rectangle rect = new Rectangle(420,40,60,30); 
	public Panel() 
	{
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT)); 
		this.setBackground(Color.black);
		
		gameThread = new Thread(this); 
		gameThread.start(); 
		
	}
	
	
	
	@Override 
	public void paint(Graphics g)
	{
		super.paint(g);
		SCORE(g); 
		paddles(g); 
		FPS(g); 
		ball(g); 
		
		
	}
	public void SCORE(Graphics g )
	{
		g.setColor(Color.white);
		g.setFont(new Font("Sans Seriff", Font.BOLD, 30));
		g.drawString("Player 1:  "+p1score+"  ||  Player 2:  "+p2score, WIDTH/2-175, 30);
		
	}
	public void FPS(Graphics g )
	{
		g.setColor(Color.red);
		g.setFont(new Font("Sans Seriff", Font.BOLD, 17));
		g.drawString(this.getFps(), 1, 17);
	}
	
	public void ball(Graphics g )
	{
		ball = new Ball( ballx, bally, 40,40); 
		ball.draw(g);
	}
	public void paddles(Graphics g)
	{
		p2= new Paddle(0,mover2,PADDLEWIDTH,PADDLEHEIGHT,1); 
		p1 = new Paddle(WIDTH-PADDLEWIDTH,mover1,PADDLEWIDTH,PADDLEHEIGHT,2); 
		p1.draw(g); 
		p2.draw(g); 
		
	}
	
	//boundaries for movement 
	public void moveUp1()// direction is going to be either 1 or -1 
	{
		if(mover1>0)
		{
			mover1-=MOVESPEED; 
		}
		
	}
	public void moveUp2()// direction is going to be either 1 or -1 
	{
		if(mover2>0)
		{
			mover2-=MOVESPEED; 
		}
	}
	public void moveDown1()// direction is going to be either 1 or -1 
	{
		if(mover1<HEIGHT-(PADDLEHEIGHT))
		{
			mover1+=MOVESPEED; 
		}
		
	}public void moveDown2()// direction is going to be either 1 or -1 
	{
		
		if(mover2<HEIGHT-(PADDLEHEIGHT))
		{
			mover2+=MOVESPEED; 
		}
	}


	@Override
	public void run()
	{
		long lastTime =System.nanoTime(); 
		final double ns=1000000000.0/60.0; 
		long timer = System.currentTimeMillis(); 
		double delta=0 ; 
		int frames=0; 
		int updates =0; 
			while(running)
			{
				long now = System.nanoTime(); 
				delta+=(now-lastTime)/ns; 
				lastTime = now ; 
				while(delta >=1.0)
				{
					//update
					update(); 
					updates++; 
					
					
					delta--; 
				}
				//p
				frames++; 
				
				if(System.currentTimeMillis()-timer>1000)
				{
					timer+=1000;
					this.setFps("FPS: " +frames); 
					
					frames=0; 
					updates=0; 
					 
					
					
				} 
				
				
			}
		
	}
	
	public void update()
	{
		if(ball.intersects(p1) ||ball.intersects(p2))
		{
			xspeed*=-1; 
		}
		
		// ball boundaries 
		ballx+=xspeed; 
		bally+=yspeed; 
		if(bally>(HEIGHT-40)||bally<40)
		{
			yspeed*=-1; 
		}
		if(ballx>WIDTH-40)
		{
			ballx=WIDTH/2; 
			bally=HEIGHT/2; 
			xspeed*=-1; 
			p2score++; 
		}
		if(ballx<0)
		{
			ballx=WIDTH/2; 
			bally=HEIGHT/2; 
			xspeed*=-1; 
			p1score++; 
		}
		//check collisions 
		
		
		// repaint
		repaint(); 
		
	}



	public String getFps()
	{
		return fps;
	}



	public void setFps(String fps)
	{
		this.fps = fps;
	}
	
}