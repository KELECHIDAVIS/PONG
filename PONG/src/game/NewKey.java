package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NewKey implements KeyListener
{
	private Panel panel; 
	
	public NewKey(Panel panel)
	{
		this.panel = panel ; 
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		//heres where you move the paddles 
		
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_W: 
			panel.moveUp1();
			break; 
		case KeyEvent.VK_S: 
			panel.moveDown1();
			break; 
		case KeyEvent.VK_UP: 
			panel.moveUp2();
			break; 
		case KeyEvent.VK_DOWN: 
			panel.moveDown2();
			break; 
			
		}
		
			

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

}
