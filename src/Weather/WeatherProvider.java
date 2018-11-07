package Weather;

import Interface.Flyable;
import Crafts.Coordinates;
import java.util.Random;
import Logger.*;

public class WeatherProvider
{
	private static WeatherProvider weatherProvider = null;
	private String[] weather;

	public WeatherProvider()
	{
		this.weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};
	}

	public static WeatherProvider getProvider()
	{
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		int seed = new Random().nextInt(weather.length);
		String currentWeather = (weather[seed]);	
		return currentWeather;
	}
}

