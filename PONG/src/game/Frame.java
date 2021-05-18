package game;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame// implements KeyListener
{
	public Frame()
	{
		Panel panel = new Panel();
		this.setTitle("PONG"); 
		//setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-(panel.WIDTH/2), (Toolkit.getDefaultToolkit().getScreenSize().height/2)-(panel.HEIGHT/2));
		this.setVisible(true); 
		
		this.setFocusable(true);
		this.addKeyListener(new NewKey(panel));
		this.add(panel); 
		this.pack(); 
		this.setResizable(false); 
		
		
	}


}
