package Crafts;

import Interface.Flyable;
import Crafts.*;

public class AircraftFactory
{
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		
		switch (type)
		{
			case "Helicopter":
				return new Helicopter(name, coordinates);
			case "JetPlane":
				return new JetPlane(name, coordinates);
			case "Baloon":
				return new Baloon(name, coordinates);
			default:
				return null;
		}
	}
}
