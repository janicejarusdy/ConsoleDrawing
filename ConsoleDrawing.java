import java.util.Scanner;

/*
 * This is a simple console drawing program to draw isosceles right-angled 
 * triangles and squares on a drawing canvas.
 * name: Janice Teguh
 * username: jteguh
 * student ID 860294
 */

public class ConsoleDrawing
{
	private static Scanner keyboard = new Scanner(System.in);
	private static DrawingCanvas canvas;
	private static String drawAnother; // (y/n) to draw another triangle/square

	
	public static void main(String[] args)
    {
    	int canvasWidth = Integer.parseInt(args[0]);
    	int canvasHeight = Integer.parseInt(args[1]);
    	char canvasCharacter = args[2].charAt(0);
    
    	canvas = new DrawingCanvas(canvasWidth, canvasHeight, canvasCharacter);
    	canvas.printWelcomeMessage();
    	
    	String option; // user's option from the menu
    	do
    	{
    		canvas.printMenu();
    		option = keyboard.next();
    		switch(option) {
    			case "1":
    				createTriangle();
    				break;	
    			case "2":
    				createSquare();
    				break;
    			case "3":
    				System.out.print("Canvas width: ");
    				canvasWidth = keyboard.nextInt();
    				
    				System.out.print("Canvas height: ");
    				canvasHeight= keyboard.nextInt();
    				
    				System.out.print("Background character: ");
    				canvasCharacter = keyboard.next().charAt(0);
    				
    				canvas.updateCanvas(canvasWidth, canvasHeight, canvasCharacter);
    				break;
    			case "4":	
    				System.out.println("Goodbye!");
    				System.exit(0);
    				break;
    			default: 
    				System.out.println("Unsupported option. Please try again!");
    				break;
    		} 
    	}
    	while(option != "4");
    }
    
	
	// create a new triangle based on user's inputs until terminated.
    public static void createTriangle()
    {
    	do 
    	{
    		int sideLength;
    		Triangle triangle = new Triangle(canvas);
    		do 
    		{
    			System.out.println("Side length:");
    			sideLength = keyboard.nextInt();	
    		}
    		while(!triangle.acceptedLength(sideLength));
    		
    		System.out.println("Printing character:");
    		char printCharacter = (keyboard.next()).charAt(0);
    		
    		System.out.println("Alignment (left, middle, right):");   // case-insensitive
    		String alignment = keyboard.next();

    		triangle.drawTriangle(sideLength, printCharacter, alignment);

    		String rotation;
    		do 
    		{
    			System.out.println("Type R/L to rotate clockwise/anti-clockwise. "
    					+ "Use other keys to continue.");   // case insensitive
    			rotation = keyboard.next();
    			
    			if (rotation.equalsIgnoreCase("r") || rotation.equalsIgnoreCase("l"))
    			{
    				triangle.rotate(rotation);
    			}	
    		}
    		while(rotation.equalsIgnoreCase("r")||rotation.equalsIgnoreCase("l"));
    		
    		do 
    		{
    			System.out.println("Draw another triangle (Y/N)?");   // case-insensitive
        		drawAnother = keyboard.next();
        		
        		if (!(drawAnother.equalsIgnoreCase("y") || drawAnother.equalsIgnoreCase("n")))
        		{
        			System.out.println("Unsupported option. Please try again!");
        		}
    		}
    		while(!(drawAnother.equalsIgnoreCase("y") || drawAnother.equalsIgnoreCase("n")));
    	} 
    	while(drawAnother.equalsIgnoreCase("y"));	
    }
    
    
    // create a new square based on user's inputs until terminated
    public static void createSquare()
    {
    	do
    	{
    		int sideLength;
    		Square square = new Square(canvas);
    		do 
    		{
    			System.out.println("Side length:");
    			sideLength = keyboard.nextInt();	
    		}
    		while(!square.acceptedLength(sideLength));
    		
    		System.out.println("Printing character:");
    		char printCharacter = keyboard.next().charAt(0);
    		
    		System.out.println("Alignment (left, middle, right):");  // case-insensitive
    		String alignment = keyboard.next();

    		square.drawSquare(sideLength, printCharacter, alignment);
    		
    		String scale; // user's input to zoom in or out
    		do
    		{
    			System.out.println("Type I/O to zoom in/out. "     
    					+ "Use other keys to continue.");   // case-insensitive
    			scale = keyboard.next();
    			
    			square.zoom(scale);
    		}
    		while(scale.equalsIgnoreCase("i") || scale.equalsIgnoreCase("o"));
    		
    		do 
    		{
    			System.out.println("Draw another square (Y/N)?");	// case-insensitive
        		drawAnother = keyboard.next();	
        		
        		if (!(drawAnother.equalsIgnoreCase("y") || drawAnother.equalsIgnoreCase("n")))
        		{
        			System.out.println("Unsupported option. Please try again!");
        		}
    		}
    		while(!(drawAnother.equalsIgnoreCase("y") || drawAnother.equalsIgnoreCase("n")));	
    	}
    	while((drawAnother.equalsIgnoreCase("y")));
    }   
}
   	
 
 
