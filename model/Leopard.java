package model;

/**
* "Leopard" Class representing the characteristics of leopard for the game inherited from the Animal Class
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
public class Leopard extends Animal {
	
	private boolean canJumpRiver;
	private boolean canGoRiver;
	
	/**
	* Constructor for the declaration of the characteristics of leopard
	* @param team		the boolean value of the team whether it is red or blue
	* @param rank		the integer value of the rank of each animal
	*/
	public Leopard(boolean team, int rank)
	{
		super(team, rank);
		canJumpRiver = false;
		canGoRiver = false;
	}
	
	/**
	* Method to get if the leopard can jump the river or not
	* @return boolean		returns false because the leopard cannot jump beyond the river
	*/
	public boolean getCanJumpRiver()
	{
		return canJumpRiver;
	}
	
	/**
	* Method to get if the leopard can be in the river
	* @return boolean		returns false because the leopard cannot go inside the river
	*/
	public boolean getCanGoRiver()
	{
		return canGoRiver;
	}
	
	/**
	* Boolean method for knowing if the capture of the leopard is valid or not
	* @param prey		the piece that will be captured
	* @return boolean		the boolean value if the move is valid
	*/
	public boolean isValidCapture(Animal prey)
	{
		return (!(this.equals(prey)) && (this.getTeam() != prey.getTeam()) && (this.getRank() >= prey.getRank()));
	}
	
}