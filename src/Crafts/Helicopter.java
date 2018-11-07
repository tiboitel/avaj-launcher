package Crafts;

import Crafts.Aircraft;
import Interface.Flyable;
import Tower.WeatherTower;
import Logger.*;

public class Helicopter extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
		String	weather = weatherTower.getWeather(this.coordinates);
		String idString = "Helicopter#" + this.name + "(" + this.id + "): ";

		switch (weather)
		{
			case "RAIN":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				Logger.getLogger().log("simulation.txt", idString + "It's raining. Better watch out for lightning. (H -5)\n");
				break;
			case "SUN" :
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				Logger.getLogger().log("simulation.txt", idString + "Some sun light, lets take some pictures. (Long +2, H +4)\n");
				break;
			case "FOG":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
				Logger.getLogger().log("simulation.txt", idString + "I cant see anything! (H -3)\n");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
				Logger.getLogger().log("simulation.txt", idString + "It's snowing out of here (H -15)\n");
				break;
		}
		if (this.coordinates.getHeight() <= 0)
		{
			Logger.getLogger().log("simulation.txt", "Tower says: " + idString + " unregistered from weather tower.\n");
			weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower)
	{
		String idString = "Helicopter#" + this.name + "(" + this.id + "):";

		Logger.getLogger().log("simulation.txt", "Tower says: " + idString + " registered from weather tower.\n");
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}
