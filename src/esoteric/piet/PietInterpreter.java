package esoteric.piet;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Stack;

import esoteric.piet.PietColor.BlackColorException;

public class PietInterpreter
{
	private int codelSize;
	private BufferedImage code;
	private Point location;
	private DirectionPointer direction;
	private CodelChooser chooser;
	private PietColor lastColor;
	private Stack<Byte> pietStack;
	
	public PietInterpreter(BufferedImage code, int codelSize)
	{
		this.code = code;
		location = new Point(0, 0);
		pietStack = new Stack<Byte>();
		this.codelSize = codelSize;
		chooser = CodelChooser.LEFT;
		direction = DirectionPointer.RIGHT;
	}
	
	public String interpretToText()
	{
		try
		{
			while(true)
			{
				Command command = getCommand();
			}
		}
		catch(BlackColorException e)
		{
			
		}
		Command a = getCommand();
	}
	
	private Command getCommand()
	{
		return Command.getCommand(this.lastColor, getPietColor());
	}
	
	private PietColor getPietColor()
	{
		return PietColor.getPietColor(code.getRGB((int) location.getX(), (int) location.getY()));
	}
	
	private void incrementLocation()
	{
		lastColor = getPietColor();
		
		if(direction.equals(DirectionPointer.LEFT))
		{
			do
			{
				while(sameColor(-1 * codelSize, 0))
				{
					location  = new Point((int) location.getX() - codelSize, (int) location.getY());			
				}
				if(chooser.equals(CodelChooser.LEFT))
				{
					while(sameColor(1, codelSize))
					{
						location  = new Point((int) location.getX(), (int) location.getY() + codelSize);
					}
				}
				else
				{
					while(sameColor(1, -1 * codelSize))
					{
						location  = new Point((int) location.getX(), (int) location.getY() - codelSize);
					}
				}
				
			}
			while(sameColor(-1 * codelSize, 0) || (sameColor(1, codelSize) && chooser.equals(CodelChooser.LEFT)) || (sameColor(1, -1 * codelSize) && chooser.equals(CodelChooser.LEFT)));		
		}
		else if(direction.equals(DirectionPointer.RIGHT))
		{
			do
			{
				while(sameColor(codelSize, 0))
				{
					location  = new Point((int) location.getX() + codelSize, (int) location.getY());			
				}
				if(chooser.equals(CodelChooser.RIGHT))
				{
					while(sameColor(-1, codelSize))
					{
						location  = new Point((int) location.getX(), (int) location.getY() + codelSize);
					}
				}
				else
				{
					while(sameColor(-1, -1 * codelSize))
					{
						location  = new Point((int) location.getX(), (int) location.getY() - codelSize);
					}
				}
				
			}
			while(sameColor(codelSize, 0) || (sameColor(-1, -1 * codelSize) && chooser.equals(CodelChooser.LEFT)) || (sameColor(-1, codelSize) && chooser.equals(CodelChooser.LEFT)));		
		}
		else if(direction.equals(DirectionPointer.DOWN))
		{
			do
			{
				while(sameColor(0, codelSize))
				{
					location  = new Point((int) location.getX(), (int) location.getY() + codelSize);			
				}
				if(chooser.equals(CodelChooser.RIGHT))
				{
					while(sameColor(-1 * codelSize, 1))
					{
						location  = new Point((int) location.getX() - codelSize, (int) location.getY());
					}
				}
				else
				{
					while(sameColor(codelSize, 1))
					{
						location  = new Point((int) location.getX() + codelSize, (int) location.getY());
					}
				}
				
			}
			while(sameColor(0, codelSize) || (sameColor(codelSize, 1) && chooser.equals(CodelChooser.LEFT)) || (sameColor(-1 * codelSize, 1) && chooser.equals(CodelChooser.LEFT)));		
		}
	}
	
	private boolean sameColor(int xIncr, int yIncr)
	{
		return lastColor.equals(PietColor.getPietColor(code.getRGB((int) location.getX() + xIncr, (int) location.getY() + yIncr))) && (location.getX() + xIncr) < code.getWidth() && (location.getY() + yIncr) < code.getHeight();
	}
	
}
