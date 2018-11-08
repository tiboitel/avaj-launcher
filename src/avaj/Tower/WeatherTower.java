package avaj.Tower;

import avaj.Aircrafts.Coordinates;
import avaj.Weather.WeatherProvider;

public class WeatherTower extends Tower
{
	public void	changeWeather()
	{
		conditionsChanged();
	}

	public String	getWeather(Coordinates coordinates)
	{
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}
}
