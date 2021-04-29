public class Triangle
{	
	/**
	 *name: Janice Teguh
	 * username: jteguh
	 * student ID 860294 
	 */
	
	private DrawingCanvas canvas;
	private int canvasWidth;
	private int canvasHeight;
	private char canvasCharacter;
	
	private int sideLength; 			// triangle's side length
	private char printCharacter;		// triangle's character
	private String alignment; 			// drawing alignment on canvas
	private int startingColumn;			// column index to start drawing triangle
	
	private int degrees;				// degrees of rotation
	private int CLOCKWISE = 90; 
	private int ANTI_CLOCKWISE = -90;
	private int FULL_ROTATION = 360;
	
	private int rowIndex;
	private int columnIndex;
	private int currentLength;			// length of triangle to be printed in one row
	private int printLength;			// remaining triangle characters to be printed in the current row
	
	
	public Triangle (DrawingCanvas newCanvas)
	{
		getCanvas(newCanvas);
	}
	
	
	// initialize canvas attributes in this class
	private void getCanvas(DrawingCanvas newCanvas) 
	{
		canvas = newCanvas;
		canvasWidth = newCanvas.getWidth();
		canvasHeight = newCanvas.getHeight();
		canvasCharacter = newCanvas.getChar();
	}
	
	
	// returns true if user-inputed triangle length is acceptable
	// parameter: user-inputed triangle length
	public boolean acceptedLength(int newLength)
	{
		if (newLength > canvas.shortestLength())
		{
			System.out.printf("Error! The side length is too long (Current canvas size is %dx%d). "
					+ "Please try again.%n", canvasWidth, canvasHeight);
			return false;
		}
		else
		{
			sideLength = newLength;
			return true;
		}
	}
	

	// prints a triangle on canvas 
	// parameter: user-inputed length, character, and alignment
	public void drawTriangle(int newLength, char newChar, String newAlignment) 
	{	
		sideLength = newLength;
		printCharacter = newChar;
		alignment = newAlignment;

		if (alignment.equalsIgnoreCase("right")) 
		{
			startingColumn = canvasWidth - sideLength + 1;
		}
		else if (alignment.equalsIgnoreCase("middle")) 
		{
			startingColumn = (canvasWidth - sideLength) / 2 + 1;
		}
		else 
		{
			startingColumn = 1;
		}
		
		for(rowIndex = 1, currentLength = sideLength; rowIndex <= canvasHeight; 
				rowIndex++, currentLength--)
		{ 
			for (columnIndex = 1, printLength = currentLength; columnIndex <= canvasWidth; 
					columnIndex++) 
			{
				if(columnIndex < startingColumn || printLength <= 0)
				{
					System.out.print(canvasCharacter);
				}
				else 
				{
					System.out.print(printCharacter);
					--printLength;
				}
			}
			System.out.println();
		}	
	}
	
	
	// prints rotated triangle based on degrees of rotation
	// parameter: rotation "r" to rotate clockwise and
	// "l" to rotate anti-clockwise
	public void rotate(String rotation)
	{
		updateDegrees(rotation);
		
		if (degrees == 0)
		{
			drawTriangle(sideLength, printCharacter, alignment);;
		}
		else if (degrees == 90 || degrees == -270) 
		{
			rotate90();
		}
		else if (degrees == 180 || degrees == -180) 
		{
			rotate180();
		}
		else if(degrees == 270 || degrees == -90)
		{
			rotate270();
		}
	}
	
	
	// update degrees of rotation based on user input
	// parameter: rotation "r" to add 90 degrees and "l" to subtract 90 degrees
	private void updateDegrees(String rotation)
	{
		if (rotation.equalsIgnoreCase("r")||rotation.equalsIgnoreCase("l"))
		{
		 	if(rotation.equalsIgnoreCase("r")) 
		 	{
		 		degrees += CLOCKWISE;
		 	}
		 	else if (rotation.equalsIgnoreCase("l")) 
		 	{
		 		degrees += ANTI_CLOCKWISE;
		 	}
		}
		
		do
		{
			checkDegrees();
		}
		while(degrees >= FULL_ROTATION || degrees <= -FULL_ROTATION);
	}
	
	
	// keep degrees of rotation <= 360 degrees and >= -360 degrees
	private void checkDegrees()
	{
		if (degrees >= FULL_ROTATION)
		{
			degrees -= FULL_ROTATION;
		}
		else if (degrees <= -FULL_ROTATION)
		{
			degrees += FULL_ROTATION;
		}
	}
	

	// prints triangle that is rotated 90 degrees clockwise
	private void rotate90() 
	{
		int startingColumn90;   // column index to start printing 90-degree rotated triangle
		
		for(rowIndex = 1, currentLength = sideLength, startingColumn90 = startingColumn; rowIndex <= canvasHeight; 
				rowIndex++, currentLength--, startingColumn90++)
		{
			for (columnIndex = 1, printLength = currentLength; columnIndex <= canvasWidth; 
					columnIndex++) 
			{
				if(columnIndex < startingColumn90 || printLength <= 0)
				{
					System.out.print(canvasCharacter);
				}
				else 
				{
					System.out.print(printCharacter);
					--printLength;
				}
			}
			System.out.println();
		}
	}
	
	
	// prints triangle that is rotated 180 degrees clockwise
	private void rotate180() 
	{
		int startingColumn180;  // column index to start printing 180-degree rotated triangle
		
		for(rowIndex = 1, currentLength = 1, startingColumn180 = startingColumn + sideLength - 1;
				rowIndex <= canvasHeight; 
				rowIndex++, startingColumn180--, currentLength++)
		{ 
			for (columnIndex = 1, printLength = currentLength; columnIndex <= canvasWidth; 
					columnIndex++) 
			{
				if(columnIndex < startingColumn180 || printLength <= 0 || currentLength > sideLength)
				{
					System.out.print(canvasCharacter);
				}
				else
				{
					System.out.print(printCharacter);
					--printLength;
				}
			}
			System.out.println();
		}	
	}
	
	
	// prints triangle that is rotated 270 degrees clockwise
	private void rotate270()
	{
		for(rowIndex = 1, currentLength = 1; rowIndex <= canvasHeight; 
				rowIndex++, currentLength++)
		{ 
			for (columnIndex = 1, printLength = currentLength; columnIndex <= canvasWidth; 
					columnIndex++) 
			{
				if(columnIndex < startingColumn || printLength <= 0 || currentLength > sideLength)
				{
					System.out.print(canvasCharacter);
				}
				else
				{
					System.out.print(printCharacter);
					--printLength;
				}
			}
			System.out.println();
		}	
	}
}
