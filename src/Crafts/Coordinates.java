package avaj.Crafts;

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
		if (height > 100)
			height = 100;
		if (height <= 0)
			height = 0;
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
