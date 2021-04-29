public class Square
{
	/**
	 * name: Janice Teguh
	 * username: jteguh
	 * student ID 860294
	 */
	
	private DrawingCanvas canvas;
	private int canvasWidth;
	private int canvasHeight;
	private char canvasCharacter;
	
	private int sideLength; 			// square's side length
	private char printCharacter;		// square's character
	private String alignment; 			// drawing alignment on canvas
	private int startingColumn;			// column index to start drawing square
	

	public Square(DrawingCanvas newCanvas)
	{
		getCanvas(newCanvas);
	}
	
	
	// initialize canvas' attributes in this class
	private void getCanvas(DrawingCanvas newCanvas) 
	{
		canvasWidth = newCanvas.getWidth();
		canvasHeight = newCanvas.getHeight();
		canvasCharacter = newCanvas.getChar();
		canvas = newCanvas;
	}
	
	
	// returns true if user-inputed square length is acceptable
	// parameter: user-inputed square length
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
	
	
	// prints a square on canvas based on user inputs
	// parameters: user-inputed square length, character, alignment
	public void drawSquare(int newLength, char newChar, String newAlignment) 
	{	
		sideLength = newLength;
		printCharacter = newChar;
		alignment = newAlignment;
		
		calculateStartingColumn();
		
		for(int rowIndex = 1, remainingLength = sideLength; rowIndex <= canvasHeight; 
				rowIndex++, remainingLength--)
		{ 
			for (int columnIndex = 1, printLength = sideLength; columnIndex <= canvasWidth; 
					columnIndex++) 
			{
				if(columnIndex < startingColumn || printLength <= 0 || remainingLength <= 0)
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
	
	
	// prints zoomed out or zoomed in square based on user input
	// parameter: scale "i" to zoom in and "o" to zoom out
	public void zoom(String scale)
	{
		if (scale.equalsIgnoreCase("i"))
		{
			if(zoomInLimitReached())
			{
				drawSquareLimit();
			}
			else
			{
				zoomIn();
			}
		}
	
		else if (scale.equalsIgnoreCase("o"))
		{
			if (zoomOutLimitReached())
			{
				drawSquareLimit();
			}
			else
			{
				zoomOut();
			}
		}
	}
	
	
	// returns true if square cannot be zoomed out again
	private boolean zoomOutLimitReached()
	{
		if (sideLength == 1)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	
	// returns true if square cannot be zoomed in again
	private boolean zoomInLimitReached()
	{
		if (sideLength >= canvas.shortestLength())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	// prints square at zoomed in or zoomed out limit
	private void drawSquareLimit()
	{
		drawSquare(sideLength, printCharacter, alignment);
	}
	
	
	// prints zoomed in square
	private void zoomIn()
	{
		++sideLength;
		drawSquare(sideLength, printCharacter, alignment);
	}
	
	
	// prints zoomed out square
	private void zoomOut()
	{
		--sideLength;
		drawSquare(sideLength, printCharacter, alignment);
	}
	
	
	// update startingColumn each time a square is printed
	private void calculateStartingColumn()
	{
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
	}
	
	
}
