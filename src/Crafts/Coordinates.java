package Crafts;

public class Coordinates
{
	private int	longitude;
	private int	latitude;
	private int	height;

	public Coordinates(int longitude, int latitude, int height)
	{
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLatitude()
	{
		return this.latitude;
	}

	public int getLongitude()
	{
		return this.longitude;
	}

	public int getHeight()
	{
		return this.height;
	}
}
