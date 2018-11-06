package com.avaj.Interface;

import com.avaj.Tower.WeatherTower;

public interface Flyable
{
	public void	registerTower(WeatherTower weatherTower);
	public void	updateConditions();
}
