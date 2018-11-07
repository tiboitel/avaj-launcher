package Simulator;

import Interface.Flyable;
import Tower.WeatherTower;
import Crafts.*;
import Logger.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Simulator {
	private static WeatherTower weatherTower = new WeatherTower();
	private static List<Flyable> flyableList = new ArrayList<>();
	private static Logger logger = Logger.getLogger();
	public static void	main(String[] args) throws IOException
	{
		try
		{
			int cycle = 0;
			File file = new File(args[0]);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();

			if (line != null)
			{
				if ((cycle = Integer.parseInt(line.split(" ")[0])) < 0)
				{
					logger.log(Level.ERROR, "Invalid simulation count in scenario, can be 0 or negative.");
					return;
				}
			}
			while ((line = reader.readLine()) != null)
			{
				String[] values = line.split(" ");
				if (values.length != 5)
				{
					logger.log(Level.ERROR, "Invalid file format { Name, ID, Longitude, Latitude, Height }");
				}
				Flyable flyable = AircraftFactory.newAircraft(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]));
				flyableList.add(flyable);
			}
			for (Flyable flyable : flyableList)
			{
				flyable.registerTower(weatherTower);
			}
			for (int i = 0; i < cycle; i++)
			{
				logger.log("simulation.txt", "Simulation: " + i + "\n");
				weatherTower.changeWeather();
			}
				
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
