package avaj.Simulator;

import avaj.Interface.Flyable;
import avaj.Tower.WeatherTower;
import avaj.Exception.*;
import avaj.Aircrafts.*;
import avaj.Logger.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Simulator 
{
	private static WeatherTower weatherTower = new WeatherTower();
	private static List<Flyable> flyableList = new ArrayList<>();
	private static Logger logger = Logger.getLogger();
	
	public static void	main(String[] args) throws IOException
	{
		if (args.length <= 0 || args.length > 1)
		{
			logger.log(Level.ERROR, "Usage: avaj_launcher [namefile]");
			System.exit(-1);
		}
		try
		{
			File file = new File("simulation.txt");
			int cycle = 0;

			if (file.exists() && !file.isDirectory())
				file.delete();
			file = new File(args[0]);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();

			if (line != null)
			{
				if ((cycle = Integer.parseInt(line.split(" ")[0])) < 0)
					throw new InvalidCycleException("Invalid simulation count in scenario, can't be 0 or negative.");
			}
			while ((line = reader.readLine()) != null)
			{
				String[] values = line.split(" ");
				if (values.length != 5)
					throw new ScenarioFileFormatException("Invalid file format { Name, ID, Longitude, Latitude, Height }");
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
			logger.log(Level.ERROR, "An error has occured when running the simulation: " + e.getMessage());
			return;
		}
	}
}
