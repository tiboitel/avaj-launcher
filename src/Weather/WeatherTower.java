package com.avaj.Weather;

import com.avaj.Crafts.Coordinates;
import com.avaj.Tower.Tower;

public class WeatherTower extends Tower
{
	public string	getWeather(Coordinates coordinates)
	{
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	public void	changeWeather()
	{
		this.conditionsChanged();
	}
}
