package _01_Crazy_Digital_Painting;

import java.awt.Color;
import java.util.Random;

public class CrazyDigitalPainting {
	//1. Create two final static integers for the width and height of the display.
	final static int width = 1300;
	final static int height = 800;
	
	//2. Create a 2D array of Color objects. You will need to import
	//java.awt.Color. Initialize the size of the array using the 
	//integers created in step 1.
	Color[][] c = new Color[1300][800];
	
	
	public CrazyDigitalPainting() {
		//3. Open the crazy_digital_painting.png file and look at the image.
		Random r1 = new Random();
		Random r2 = new Random();
		Random r3 = new Random();
		int ran1 = r1.nextInt(256);
		int ran2 = r2.nextInt(256);
		int ran3 = r3.nextInt(256);
		//4. Iterate through the 2D array and initialize each Color object
		//   to a new color. The sample image was created using the following 
		//   pattern:
		//   colors[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
		for(int i = 0; i<c.length; i++) {
			for(int j=0; j<c[i].length; j++) {
				c[i][j] = new Color(i%ran1, (i*j)%ran2, j&ran3);
				
			}
		}
		
		//5. Come up with your own pattern to make a cool crazy image.
		
		//6. Use the ColorArrayDisplayer class to call the displayColorsAsImage method 
		//   to show off your picture.
		ColorArrayDisplayer.displayColorsAsImage(c);
	}
	
	public static void main(String[] args) {
		new CrazyDigitalPainting();
	}
}
