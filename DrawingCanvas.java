public class DrawingCanvas
{ 
	/**
	 * name: Janice Teguh
	 * username: jteguh
	 * student ID 860294
	 */
	
	private int width;		// width of canvas
	private int height;		// height of canvas
	private char character;	// background character of canvas
	
	
	public DrawingCanvas(int canvasWidth, int canvasHeight, char newCharacter) 
	{
		width = canvasWidth;
		height = canvasHeight;
		character = newCharacter;
	}
	
	
	public void printWelcomeMessage()
	{
    	System.out.printf("----WELCOME TO MY CONSOLE DRAWING APP----%n"
    			+ "Current drawing canvas settings:%n"
    			+ "- Width: %d%n"
    			+ "- Height: %d%n"
    			+ "- Background character: %s%n%n", width, height, character);  
	}
	
	
	public void printMenu()
	{
		System.out.printf("Please select an option. Type 4 to exit.%n"
        		+ "1. Draw triangles%n"
        		+ "2. Draw squares%n"
        		+ "3. Update drawing canvas settings%n"
        		+ "4. Exit%n");	
	}
	
	
	public int getWidth() 
	{
		return width;
	}
	
	
	public int getHeight() 
	{
		return height;
	}
	
	
	public char getChar() 
	{
		return character;
	}
	
	
	// returns an integer of the shortest length of a canvas
	// e.g for a 10 x 6 canvas, it will return 6
	public int shortestLength() 
	{
		if (width >= height)
		{
			return height;
		}
		else
		{
			return width;
		}
	}
	
	
	// updates canvas based on user's inputs
	// parameters: new width, new height, new background character
	public void updateCanvas(int newWidth, int newHeight, char newChar)
	{
		width = newWidth;
		height = newHeight;
		character = newChar;
		
		System.out.printf("Drawing canvas has been updated!%n%n"
				+ "Current drawing canvas settings:%n"
				+ "- Width: %d%n"
				+ "- Height: %d%n"
				+ "- Background character: %c%n%n", width, height, character);
	}
}
