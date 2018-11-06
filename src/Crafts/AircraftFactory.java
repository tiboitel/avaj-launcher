package Crafts;

import Interface.Flyable;

public class AircraftFactory
{
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		
		switch (type)
		{
			default:
				return null;
		}
	}
}
