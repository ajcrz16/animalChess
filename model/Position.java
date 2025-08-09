package model;

/**
* "Position" Class representing the position of the tiles in the game
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
public class Position {
	
	private int abscissa;
	private int ordinate;
	
	/**
	* Constructor for the characteristics of the player
	* @param x		the position of the piece in the abscissa
	* @param y		the position of the piece in the ordinate
	*/
	public Position(int x, int y)
	{
		setAbscissa(x);
		setOrdinate(y);
	}
	
	/**
	* Method for getting the x value
	* @return int		returns the int value of the abscissa
	*/
	public int getX()
	{
		return abscissa;
	}
	
	/**
	* Method for getting the y value
	* @return int		returns the int value of the ordinate
	*/
	public int getY()
	{
		return ordinate;
	}
	
	/**
	* Method for setting the abscissa
	* @param x		the position of the piece in the abscissa
	*/
	public void setAbscissa(int x)
	{
		abscissa = x;
	}
	
	/**
	* Method for setting the ordinate
	* @param x		the position of the piece in the ordinate
	*/
	public void setOrdinate(int y)
	{
		ordinate = y;
	}
	
	/**
	* Method for knowing if the position is in bounds
	* @return boolean		returns the boolean value of the position if it is valid or not
	*/
	public boolean isInBounds()
	{
		return((abscissa >= 0 && abscissa < 7) && (ordinate >= 0 && ordinate < 9));
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Position temp = (Position) obj;
		
		return (getX() == temp.getX() && getY() == temp.getY());
	}
	
}
