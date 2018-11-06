package Tower;

import Interface.Flyable;
import java.util.ArrayList;

public class Tower
{
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable)
	{
		try
		{
			observers.add(flyable);
		} catch (Exception e)
		{
			System.out.println("Can not register a new flyable.");
		}
	}

	public void unregister (Flyable flyable)
	{
		try
		{
			observers.remove(flyable);
		} catch (Exception e)
		{
			System.out.println("Can not unregister a flyable");
		}
	}

	protected void conditionsChanged()
	{
	}
}
