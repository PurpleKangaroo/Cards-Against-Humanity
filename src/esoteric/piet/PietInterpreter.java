package esoteric.piet;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Stack;

import javax.imageio.ImageIO;

import esoteric.piet.PietColor.BlackColorException;

public class PietInterpreter
{
	private Dimension codelSize;
	private BufferedImage code;
	private Point location;
	private DirectionPointer direction;
	private CodelChooser chooser;
	private PietColor lastColor;
	private Stack<Byte> pietStack;
	
	public PietInterpreter(BufferedImage code, Dimension codelSize)
	{
		this.code = code;
		location = new Point(0, 0);
		pietStack = new Stack<Byte>();
		this.codelSize = codelSize;
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
		return Command.getCommand(this.lastColor, PietColor.getPietColor(code.getRGB((int) location.getX(), (int) location.getY())));
	}
	
	private void incrementLocation()
	{
		
	}
	
}
