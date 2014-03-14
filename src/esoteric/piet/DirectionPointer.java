package esoteric.piet;

import java.awt.Point;

public enum DirectionPointer
{
	RIGHT(0),
	DOWN(1),
	LEFT(2),
	UP(3);
	
	private final int number;
	
	DirectionPointer(int number)
	{
		this.number = number;
	}
	
	public static DirectionPointer rotate(DirectionPointer current, int steps)
	{
		return current.rotate(steps);
	}
	
	public DirectionPointer rotate(int steps)
	{
		int a = this.number + steps;
		a = a % 4;
		
		return getDirection(a);
	}
	
	public DirectionPointer getDirection(int number)
	{
		switch(number)
		{
		case 0:
			return RIGHT;
		case 1:
			return DOWN;
		case 2:
			return LEFT;
		case 3:
			return UP;
		default:
			return null;
		}
	}
}
