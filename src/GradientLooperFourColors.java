import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Draws gradients across the width of the panel
 * @author Jacob Bagley
 */
@SuppressWarnings("serial")
public class GradientLooperFourColors extends JPanel {
	/* This method draws on the Graphics context.
	 * This is where your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics canvas) 
	{
		//ready to paint
		super.paintComponent(canvas);
		
		//account for changes to window size
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height
		
		final int GRADIENT_DIVISIONS = 256;
		final int NUM_GRADIENT_BARS = 4;

		//TODO: Your code goes here
		int xLocation = 0;
		int xThick = (int) Math.ceil((double) width /  GRADIENT_DIVISIONS);
		int yThick = (int) Math.ceil((double) height / NUM_GRADIENT_BARS);
		int colorR = 0, colorG = 0, colorB = 0;
		
		for (int i = 0; i < NUM_GRADIENT_BARS; i++) {
			
			for (int j = 0; j <= 255; j++) {
				xLocation = xThick * j;
				canvas.setColor(new Color(colorR, colorG, colorB));
				canvas.fillRect(xLocation, yThick * i, xThick, yThick);
				switch(i) {
				case 0:
					colorG++;
					colorB++;
					colorR++;
					break;
				case 1:
					colorR++;
					break;
				case 2:
					colorG++;
					break;
				case 3:
					colorB++;
					break;
				}
			}
			colorR = 0;
			colorG = 0;
			colorB = 0;
		}
	}

	/**
	 * DO NOT MODIFY
	 * Constructor for the display panel initializes
	 * necessary variables. Only called once, when the
	 * program first begins.
	 */
	public GradientLooperFourColors() 
	{
		setBackground(Color.black);
		int initWidth = 768;
		int initHeight = 512;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);
	}

	/**
	 * DO NOT MODIFY
	 * Starting point for the program
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("GradientLooperFourColors");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new GradientLooperFourColors());
		frame.pack();
		frame.setVisible(true);
	}
}
