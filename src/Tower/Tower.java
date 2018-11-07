package Tower;

import Interface.Flyable;
import java.util.ArrayList;
import java.util.Iterator;

public class Tower
{
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();
	private	ArrayList<Flyable> unregistered = new ArrayList<Flyable>();

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
		if (unregistered.contains(flyable))
			return ;
		unregistered.add(flyable);
	}
	
	protected void conditionsChanged()
	{
		Iterator<Flyable> itr = observers.iterator();
		while (itr.hasNext())
		{
			Flyable flyable= itr.next();
			flyable.updateConditions();
		}
		observers.remove(unregistered);
	}
}
