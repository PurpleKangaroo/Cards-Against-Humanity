package esoteric.piet;

public enum Command
{
	PUSH(0, 1),
	POP(0, 2),
	ADD(1, 0),
	SUBTRACT(1, 1),
	MULTIPLY(1, 2),
	DEVIDE(2, 0),
	MOD(2, 1),
	NOT(2, 2),
	GREATER(3, 0),
	POINTER(3, 1),
	SWITCH(3, 2),
	DUPLICATE(4, 0),
	ROLL(4, 1),
	IN_NUMBER(4, 2),
	IN_CHAR(5, 0),
	OUT_NUMBER(5, 1),
	OUT_CHAR(5, 2);
	
	public final int hueChange;
	public final int lightnessChange;
	
	Command(int hueChange, int lightnessChange)
	{
		this.hueChange = hueChange;
		this.lightnessChange = lightnessChange;
	}
	
	public static Command getCommand(PietColor oldColor, PietColor newColor)
	{
		return getCommand(PietColor.hueChange(oldColor, newColor), PietColor.lightnessChange(oldColor, newColor));
	}
	
	public static Command getCommand(int hueChange, int lightnessChange)
	{
		try
		{
			return (Command.values())[hueChange * 3 + (lightnessChange % 3)];
		}
		catch(Throwable t)
		{
			throw new InvalidCommandError();
		}
		
	}
	
	public static class InvalidCommandError extends PietError
	{
		
	}
}
