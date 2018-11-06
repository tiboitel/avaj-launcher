package Simulator;

import Interface.Flyable;
import Tower.WeatherTower;
import Crafts.*;
import java.io.*;
import java.util.*;

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
					return ;
				}
			}
			while ((line = reader.readLine()) != null)
			{
				// Split line to getting all flyer attribute.
				System.out.println(line);
			}
		}
		catch (Exception e)
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
