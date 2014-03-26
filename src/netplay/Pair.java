package netplay;

import java.util.ArrayList;

public class Pair<E> extends ArrayList<E>
{
	
	public Pair()
	{
		super();
	}
	
	public boolean add(E element)
	{
		for(int i = 1; i < size(); i++)
		{
			super.remove(i);
		}
		return super.add(element);
	}
	
	public void add(int index, E element)
	{
		E a = super.get((index - 1) % 2);
		super.removeAll(this);
		super.add(index - 1 >= 0 ? a : element);
		super.add(index - 1 >= 0 ? element : a);
	}
	
	public void setFirst(E element)
	{
		this.add(0, element);
	}
	
	public void setSecond(E element)
	{
		this.add(1, element);
	}
	
	public E getFirst()
	{
		return super.get(0);
	}
	
	public E getSecond()
	{
		return super.get(1);
	}
	
}
