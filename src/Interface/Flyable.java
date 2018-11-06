package Interface;

import Tower.WeatherTower;

public interface Flyable
{
	public void	registerTower(WeatherTower weatherTower);
	public void	updateConditions();
}
