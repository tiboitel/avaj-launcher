package avaj.Interface;

import avaj.Tower.WeatherTower;

public interface Flyable
{
	public void	registerTower(WeatherTower weatherTower);
	public void	updateConditions();
}
