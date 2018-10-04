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
public class GradientLooperColorsVertical extends JPanel {
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
		final int NUM_GRADIENT_BARS = 7;

		//TODO: Your code goes here
		
		int yLocation = 0;
		int yThick = (int) Math.ceil((double) height /  GRADIENT_DIVISIONS);
		int xThick = (int) Math.ceil((double) width / NUM_GRADIENT_BARS);
		int colorR = 255, colorG = 255, colorB = 255;
		
		for (int i = 0; i < NUM_GRADIENT_BARS; i++) {
			for (int j = 0; j <= 255; j++) {
				yLocation = yThick * j;
				canvas.setColor(new Color(colorR, colorG, colorB));
				canvas.fillRect(xThick * i, yLocation, xThick, yThick);
				switch(i) {
					case 0:
						colorR--;
						colorG--;
						colorB--;
						break;
					case 1:
						colorR--;
						break;
					case 2:
						colorR--;
						colorG--;
						break;
					case 3:
						colorG--;
						break;
					case 4:
						colorG--;
						colorB--;
						break;
					case 5:
						colorB--;
						break;
					case 6:
						colorR--;
						colorB--;
						break;
				}
			}
			colorR = 255;
			colorG = 255;
			colorB = 255;
		}
	}

	/**
	 * DO NOT MODIFY
	 * Constructor for the display panel initializes
	 * necessary variables. Only called once, when the
	 * program first begins.
	 */
	public GradientLooperColorsVertical() 
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
		JFrame frame = new JFrame ("GradientLooperColorsVertical");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new GradientLooperColorsVertical());
		frame.pack();
		frame.setVisible(true);
	}
}
