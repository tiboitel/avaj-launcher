package com.avaj.Tower;

import com.avaj.Crafts.Coordinates;

public class WeatherTower
{
	private void	changeWeather()
	{
	}

	public String	getWeatherCoordinates(Coordinates coordinates)
	{
		String	weatherCoordinates = String.valueOf(coordinates.getLattitude());
		return weatherCoordinates;
	}
}
