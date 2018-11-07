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
		String weather = weatherTower.getWeather(this.coordinates);
		String idString = "JetPlane#" + this.name + "(" + this.id + "): ";

		switch (weather)
		{
			case "RAIN":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
				Logger.getLogger().log("simulation.txt", idString + "It's raining. Better watch out for lightning. (Lat +5))\n");
				break;
			case "SUN" :
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
				Logger.getLogger().log("simulation.txt", idString + "Some sun light, lets take some picutres. (Lat +10, H +2)\n");
				break;
			case "FOG":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
				Logger.getLogger().log("simulation.txt", idString + "I cant see anything! (Lat +1)\n");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
				Logger.getLogger().log("simulation.txt", idString + "It's snowing out of here (H -7)\n");
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
