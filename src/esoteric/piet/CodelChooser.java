package esoteric.piet;

public enum CodelChooser
{
	RIGHT,
	LEFT;
	
	public static CodelChooser switchChooser(CodelChooser a)
	{
		return a.switchChooser();
	}
	
	public CodelChooser switchChooser()
	{
		if(this.equals(RIGHT))
		{
			return LEFT;
		}
		else
		{
			return RIGHT;
		}
	}
	
	public static CodelChoice getChoice(CodelChooser a, DirectionPointer dir)
	{
		return a.getChoice(dir);
	}
	
	public CodelChoice getChoice(DirectionPointer dir)
	{
		if(dir.equals(DirectionPointer.RIGHT))
		{
			if(this.equals(LEFT))
			{
				return CodelChoice.UPPERMOST;
			}
			else return CodelChoice.LOWERMOST;
		}
		
		else if(dir.equals(DirectionPointer.LEFT))
		{
			if(this.equals(RIGHT))
			{
				return CodelChoice.UPPERMOST;
			}
			else return CodelChoice.LOWERMOST;
		}
		
		else if(dir.equals(DirectionPointer.UP))
		{
			if(this.equals(LEFT))
			{
				return CodelChoice.LEFTMOST;
			}
			else return CodelChoice.RIGHTMOST;
		}
		
		else if(dir.equals(DirectionPointer.DOWN))
		{
			if(this.equals(RIGHT))
			{
				return CodelChoice.LEFTMOST;
			}
			else return CodelChoice.RIGHTMOST;
		}
		
		else return null;
	}
	
	enum CodelChoice
	{
		LEFTMOST,
		RIGHTMOST,
		LOWERMOST,
		UPPERMOST;
	}
}
