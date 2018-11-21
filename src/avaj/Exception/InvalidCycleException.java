package avaj.Exception;

import java.io.*;
import java.lang.Exception;

public class InvalidCycleException extends Exception
{
	public InvalidCycleException(String message)
	{
		super(message);
	}
}
