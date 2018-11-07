package Crafts;

import Crafts.Aircraft;
import Interface.Flyable;
import Tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
	}

	public void registerTower(WeatherTower weatherTower)
	{
	}
}
