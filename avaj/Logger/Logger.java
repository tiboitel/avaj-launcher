package avaj.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import avaj.Logger.*;

public class Logger
{
	private static Logger logger = null;

	public static synchronized Logger getLogger()
	{
		if (logger == null)
			logger = new Logger();
		return logger;
	}

	public void log(Level output_fd, String message)
	{
		switch (output_fd)
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
		Level output_fd = Level.ERROR;
		try
		{
			File		fd = new File(file);
			FileWriter	writer = new FileWriter(fd, true);

			writer.write(message);
			writer.flush();
		} catch (Exception e)
		{
			log(output_fd, "Couln't write into the file: " + file);
		}
	}
}
