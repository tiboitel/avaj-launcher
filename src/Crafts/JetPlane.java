package Crafts;

import Crafts.Aircraft;
import Interface.Flyable;
import Tower.WeatherTower;
import Logger.*;

public class JetPlane extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;
	
	JetPlane(String name, Coordinates coordinates)
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
				Logger.getLogger().log(Level.STANDARD, "It's raining. Better watch out for lightning. (H -5)\n");
				break;
			case "SUN" :
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				Logger.getLogger().log(Level.STANDARD, "Some sun light, lets take some picutres. (Long +2, H +4)\n");
				break;
			case "FOG":
				break;
			case "SNOW":
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
