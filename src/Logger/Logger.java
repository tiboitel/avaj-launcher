package avaj.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger
{
	private static Logger logger = null;

	public static synchronized Logger getLogger()
	{
		if (logger == null)
			logger = new Logger();
		return logger;
	}

	public void log(Level level, String message)
	{
		switch (level)
		{
			case STANDARD:
				System.out.println(message);
				break;
			case ERROR:
				System.err.println(message);
				break;
		}
	}

	public void log(String file, String message)
	{
		try
		{
			File		fd = new File(file);
			FileWriter	writer = new FileWriter(fd, true);

			writer.write(message);
			writer.flush();
		} catch (Exception e)
		{
			log(Level.ERROR, "Couln't write into the file: " + file);
		}
	}
}
