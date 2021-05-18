package game;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainTest
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Africa"); 
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel(); 
		
		panel.setPreferredSize(new Dimension(1000,500));
		
		
		
		frame.getContentPane().add(panel); 
		frame.addKeyListener(new NewKey());
		frame.pack(); 
	}

}
