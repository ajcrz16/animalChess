package model;

/**
* "Mouse" Class representing the characteristics of mouse for the game inherited from the Animal Class
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
public class Mouse extends Animal {
	
	private boolean canJumpRiver;
	private boolean canGoRiver;
	
	/**
	* Constructor for the declaration of the characteristics of mouse
	* @param team		the boolean value of the team whether it is red or blue
	* @param rank		the integer value of the rank of each animal
	*/
	public Mouse(boolean team, int rank)
	{
		super(team, rank);
		canJumpRiver = false;
		canGoRiver = true;
	}
	
	/**
	* Method to get if the mouse can jump the river or not
	* @return boolean		returns false because the mouse cannot jump beyond the river
	*/
	public boolean getCanJumpRiver()
	{
		return canJumpRiver;
	}
	
	/**
	* Method to get if the mouse can be in the river
	* @return boolean		returns false because the mouse cannot go inside the river
	*/
	public boolean getCanGoRiver()
	{
		return canGoRiver;
	}
	
	/**
	* Method to get if the mouse is in the river
	* @return boolean		returns the boolean value if the mouse is in the river or not
	*/
	public boolean isInRiver()
	{
		Position temp = this.getPosition();
		
		if((temp.getX() == 1 || temp.getX() == 2 || temp.getX() == 4 || temp.getX() == 5) && (temp.getY() == 3 || temp.getY() == 4 || temp.getY() == 5))
			return true;
		else
			return false;
	}
	
	/**
	* Boolean method for knowing if the capture of the mouse is valid or not
	* @param prey		the piece that will be captured
	* @return boolean		the boolean value if the move is valid
	*/
	public boolean isValidCapture(Animal prey)
	{
		return (!(this.equals(prey)) && (this.getTeam() != prey.getTeam()) && (prey.getRank() == 8));
	}
	
}