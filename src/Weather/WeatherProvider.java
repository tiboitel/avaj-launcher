package com.avaj.Weather;

import com.avaj.Crafts.Coordinates;
import com.avaj.Interface.Flyable;

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

