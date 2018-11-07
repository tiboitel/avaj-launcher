package Tower;

import Crafts.Coordinates;
import Weather.WeatherProvider;

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
