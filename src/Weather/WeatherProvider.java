package Weather;

import Interface.Flyable;
import Crafts.Coordinates;

public class WeatherProvider
{
	private WeatherProvider weatherProvider;
	private String		weather;

	public WeatherProvider()
	{
	}

	public WeatherProvider getProvider()
	{
		return this.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		return this.weather;
	}
}

