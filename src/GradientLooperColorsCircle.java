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
public class GradientLooperColorsCircle extends JPanel {
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
		
		final int CIRCLES = 6;

		//TODO: Your code goes here
		int yLocation = 0;
		int xLocation = 0;
		
		int circWidth = width;
		int circHeight = height;
		int circDelta = 2;
		
		int cR = 256, cG = 256, cB = 256,colorDelta = 8;
		
		for (int i = 0; i < CIRCLES; i++) {
			
			for (int j = 0; j <= 255; j +=colorDelta) {
				
				switch(i) {
					case 0:
						cR -=colorDelta;
						cG = 0;
						cB = 0;
						break;
					case 1:
						cR -=colorDelta;
						cG -=colorDelta;
						cB = 0;
						break;
					case 2:
						cR = 0;
						cG -=colorDelta;
						cB = 0;
						break;
					case 3:
						cR = 0;
						cG -=colorDelta;
						cB -=colorDelta;
						break;
					case 4:
						cR = 0;
						cG = 0;
						cB -=colorDelta;
						break;
					case 5:
						cR -=colorDelta;
						cG = 0;
						cB -=colorDelta;
						break;
				}
				
				canvas.setColor(new Color(cR, cG, cB));
				canvas.fillOval(xLocation, yLocation, circWidth, circHeight);
				
				circWidth -= circDelta;
				circHeight -= circDelta;
				
				xLocation = xLocation + circDelta / 2;
				yLocation = yLocation + circDelta / 2;
			}
		cR = 256;
		cG = 256;
		cB = 256;
			
			
			
			
		}

		

		/*
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
		*/
	}

	/**
	 * DO NOT MODIFY
	 * Constructor for the display panel initializes
	 * necessary variables. Only called once, when the
	 * program first begins.
	 */
	public GradientLooperColorsCircle() 
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
		JFrame frame = new JFrame ("GradientLooperColorsCircle");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new GradientLooperColorsCircle());
		frame.pack();
		frame.setVisible(true);
	}
}
