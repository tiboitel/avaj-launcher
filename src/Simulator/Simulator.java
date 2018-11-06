package Simulator;

import Interface.Flyable;
import Tower.WeatherTower;
import Crafts.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Simulator {
	private static WeatherTower weatherTower = new WeatherTower();
	private static List<Flyable> flyableList = new ArrayList<>();

	public static void	main(String[] args) throws IOException
	{
		try
		{
			File file = new File(args[0]);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			if (line != null)
			{
				if (Integer.parseInt(line.split(" ")[0]) < 0)
				{
					System.err.println("Invalid simulation count in scenario, can be 0 or negative.");
					return;
				}
			}
			while ((line = reader.readLine()) != null)
			{
				String[] values = line.split(" ");
				if (values.length != 5)
				{
					System.err.println("Invalid file format { }");
				}
				System.out.println(values[2]);
				Flyable flyable = AircraftFactory.newAircraft(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]));
				flyableList.add(flyable);
			}
			for (Flyable flyable : flyableList)
			{
				flyable.registerTower(weatherTower);
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		// Lire le scenario.
		// Instancier une tour meteo.
		// Instancier tout les volants via la Factory.
		// Enregistrer tout les volants aupres de la tour.
		// Jouer la simulation.
		System.out.println("Hello World!");
	}
}
