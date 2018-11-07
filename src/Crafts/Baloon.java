package Crafts;

import Crafts.Aircraft;
import Interface.Flyable;
import Tower.WeatherTower;
import Logger.*;

public class Baloon extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
		String	weather = weatherTower.getWeather(this.coordinates);
		switch (weather)
		{
			case "RAIN":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				Logger.getLogger().log("simulation.txt", "It's raining. Better watch out for lightning. (H -5)\n");
				break;
			case "SUN" :
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				Logger.getLogger().log("simulation.txt", "Some sun light, lets take some picutres. (Long +2, H +4)\n");
				break;
			case "FOG":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
				Logger.getLogger().log("simulation.txt", "I cant see anything! (H -3)\n");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
				Logger.getLogger().log("simulation.txt", "It's snowing out of ehere (H -15)\n");
				break;
		}
		if (this.coordinates.getHeight() <= 0)
		{
			weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}
