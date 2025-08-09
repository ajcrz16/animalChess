package model;

/**
* "Lion" Class representing the characteristics of lion for the game inherited from the Animal Class and implements the interface of the RiverJumpException because the lion can jump through the river
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
public class Lion extends Animal implements RiverJumpException {
	private boolean canJumpRiver;
	private boolean canGoRiver;
	
	/**
	* Constructor for the declaration of the characteristics of lion
	* @param team		the boolean value of the team whether it is red or blue
	* @param rank		the integer value of the rank of each animal
	*/
	public Lion(boolean team, int rank)
	{
		super(team, rank);
		canJumpRiver = true;
		canGoRiver = false;
	}
	
	/**
	* Method to get if the lion can jump the river or not
	* @return boolean		returns true because the leopard can jump beyond the river
	*/
	public boolean getCanJumpRiver()
	{
		return canJumpRiver;
	}
	
	/**
	* Method to get if the lion can be in the river
	* @return boolean		returns false because the lion cannot go inside the river
	*/
	public boolean getCanGoRiver()
	{
		return canGoRiver;
	}
	
	/**
	* Boolean method for knowing if the capture of the lion is valid or not
	* @param prey			the piece that will be captured
	* @return boolean		the boolean value if the move is valid
	*/
	public boolean isValidCapture(Animal prey)
	{
		return (!(this.equals(prey)) && (this.getTeam() != prey.getTeam()) && (this.getRank() >= prey.getRank()));
	}
	
	/**
	* Method to show the jump of the lion through the river
	* @param Position		returns the target tile and position of the lion piece of the player
	*/
	public Position riverJump() //to know if the next Tile of the currentPosition is the river, if X then +2, else +3 
	{
		Position currPosition = this.getPosition();
		Position pTempXRight;
		Position pTempXLeft;
		Position pTempYUp;
		Position pTempYDown;
		
		Tile tTempA, tTempB, tTempC, tTempD;
		Position target = new Position(-1, -1);
		
		if(team) //red
		{
			pTempXRight = new Position(currPosition.getX()-1, currPosition.getY());
			pTempXLeft = new Position(currPosition.getX()+1, currPosition.getY());
			pTempYUp = new Position(currPosition.getX(), currPosition.getY()+1);
			pTempYDown = new Position(currPosition.getX(), currPosition.getY()-1);
			
			tTempA = new Tile(pTempXRight);
			tTempB = new Tile(pTempXLeft);
			tTempC = new Tile(pTempYUp);
			tTempD = new Tile(pTempYDown);
			
			if(pTempXRight.isInBounds() && tTempA.getIsRiverLocation())
				target = new Position(currPosition.getX()-2, currPosition.getY());
			else if(pTempXLeft.isInBounds() && tTempB.getIsRiverLocation())
				target = new Position(currPosition.getX()+2, currPosition.getY());
			else if(pTempYUp.isInBounds() && tTempC.getIsRiverLocation())
				target = new Position(currPosition.getX(), currPosition.getY()+3);
			else if(pTempYDown.isInBounds() && tTempD.getIsRiverLocation())
				target = new Position(currPosition.getX(), currPosition.getY()-3);
		}
		else //blue
		{
			pTempXRight = new Position(currPosition.getX()+1, currPosition.getY());
			pTempXLeft = new Position(currPosition.getX()-1, currPosition.getY());
			pTempYUp = new Position(currPosition.getX(), currPosition.getY()-1);
			pTempYDown = new Position(currPosition.getX(), currPosition.getY()+1);
			
			tTempA = new Tile(pTempXRight);
			tTempB = new Tile(pTempXLeft);
			tTempC = new Tile(pTempYUp);
			tTempD = new Tile(pTempYDown);
			
			if(pTempXRight.isInBounds() && tTempA.getIsRiverLocation())
				target = new Position(currPosition.getX()+2, currPosition.getY());
			else if(pTempXLeft.isInBounds() && tTempB.getIsRiverLocation())
				target = new Position(currPosition.getX()-2, currPosition.getY());
			else if(pTempYUp.isInBounds() && tTempC.getIsRiverLocation())
				target = new Position(currPosition.getX(), currPosition.getY()-3);
			else if(pTempYDown.isInBounds() && tTempD.getIsRiverLocation())
				target = new Position(currPosition.getX(), currPosition.getY()+3);
		}
			
		return target;	
	}
	
}