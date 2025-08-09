package model;

/**
* "Animal" Class representing the animal pieces together with the declaration of the icons for each piece
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
import javax.swing.*;

/**
* Abstract Animal Class representing the animal pieces together with the declaration of the icons for each piece
*/
public abstract class Animal {
	
	protected boolean isAlive;
	protected Position position;
	protected Position prevPosition;
	protected boolean team;
	protected ImageIcon icon;
	protected int rank;
	protected boolean isTrapped;
	protected boolean isAtDen;
	
	/**
	* Constructor for the declaration of position and status of the animal pieces for the class
	* @param team		the boolean value of the team whether it is red or blue
	* @param rank		the integer value of the rank of each animal
	*/
	public Animal(boolean team, int rank)
	{
		setIsAlive(true);
		setTeam(team);
		setDefaultPosition(rank, team);
		this.rank = rank;
		setIcon(team, rank);
		setIsTrapped(false); 
		setIsAtDen(false);
	}
	
	/**
	* Constructor for the icon of the animal pieces for the gui program
	* @param team		the boolean value of the team whether it is red or blue
	* @param icon		the ImageIcon for the image that will be used for each animal
	* @param rank		the integer value of the rank of each animal
	*/
	public Animal(boolean team, ImageIcon icon, int rank)
	{
		this(team, rank);
		this.icon = icon;
	}
	
	/**
	* Method to get the position of the animal piece
	* @return Position		returns the position of the piece
	*/
	public Position getPosition() 
	{ 
		return position; 
	}	
	
	/**
	* Method to get the previous position of the animal piece
	* @return Position		returns the previous position of the piece
	*/
	public Position getPrevPosition() 
	{ 
		return prevPosition; 
	}
	
	/**
	* Method to get the status of the animal piece
	* @return boolean		returns boolean value if the animal is alive or not
	*/
	public boolean getIsAlive() 
	{ 
		return isAlive; 
	}
	
	/**
	* Method to get the team of the animal piece
	* @return boolean		returns boolean value if the animal is a part of the red or blue team
	*/
	public boolean getTeam() 
	{ 
		return team; 
	}
	
	/**
	* Method to get the icon picture of the animal piece
	* @return ImageIcon		returns the ImageIcon for the animal piece
	*/
	public ImageIcon getIcon() 
	{ 
		return icon; 
	}
	
	/**
	* Method to get the rank of the specific animal piece
	* @return int		returns the integer value of the rank of the animal
	*/
	public int getRank() 
	{ 
		return rank; 
	}
	
	/**
	* Method to get the status of the animal if trapped
	* @return boolean		returns boolean value if the animal is trapped or not
	*/
	public boolean getIsTrapped() 
	{ 
		return isTrapped; 
	}
	
	/**
	* Method to get the status of the animal if at the opponent's den
	* @return boolean		returns boolean value if the animal is at the opponent's den
	*/
	public boolean getIsAtDen() 
	{ 
		return isAtDen; 
	}
	
	/**
	* Method to set the position for each animal piece
	* @param position		Position to set the position of the animal piece in the board
	*/
	public void setPosition(Position position) 
	{
		this.position = position;
	}
	
	/**
	* Method to set the previous position for each animal piece
	* @param position		Position to set the previous position of the animal piece in the board
	*/
	public void setPrevPosition(Position position)
	{
		prevPosition = position;
	}
	
	/**
	* Method to set the default position for each animal piece at the start of the game
	* @param rank		integer value for the rank of each animal
	* @param team		boolean value if the piece is a part of the red or blue team
	*/
	public void setDefaultPosition(int rank, boolean team)
	{
		if(team == true) //red animals
		{
			if(rank == 1) {
				position = new Position(0, 2);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 2) {
				position = new Position(5, 1);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 3) {
				position = new Position(4, 2);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 4) {
				position = new Position(1, 1);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 5) {
				position = new Position(2, 2);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 6) {
				position = new Position(6, 0);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 7) {
				position = new Position(0, 0);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 8) {
				position = new Position(6, 2);
				prevPosition = new Position(position.getX(), position.getY());
			}
		}
		else //blue animals
		{
			if(rank == 1) {
				position = new Position(6, 6);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 2) {
				position = new Position(1, 7);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 3) {
				position = new Position(2, 6);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 4) {
				position = new Position(5, 7);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 5) {
				position = new Position(4, 6);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 6) {
				position = new Position(0, 8);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 7) {
				position = new Position(6, 8);
				prevPosition = new Position(position.getX(), position.getY());
			}
			else if(rank == 8) {
				position = new Position(0, 6);
				prevPosition = new Position(position.getX(), position.getY());
			}
		}
	}
	
	/**
	* Method to set if the animal piece is alive or not
	* @param alive		boolean value for the status of the animal 
	*/
	public void setIsAlive(boolean alive)
	{
		isAlive = alive;
	}
	
	/**
	* Method to set if the animal piece is alive or not
	* @param team		boolean value for the team color of the animal piece 
	*/
	public void setTeam(boolean team)
	{
		this.team = team;
	}
	
	/**
	* Method to set the icons of the animal pieces with the corresponding image
	* @param team		boolean value if the piece is a part of the red or blue team
	* @param rank		integer value for the rank of each animal
	*/
	public void setIcon(boolean team, int rank)
	{
		if(team) //red team
		{
			if(rank == 1)
				icon = new ImageIcon("RED/mouse.png");
			else if(rank == 2)
				icon = new ImageIcon("RED/cat.png");
			else if(rank == 3)
				icon = new ImageIcon("RED/dog.png");
			else if(rank == 4)
				icon = new ImageIcon("RED/wolf.png");
			else if(rank == 5)
				icon = new ImageIcon("RED/leopard.png");
			else if(rank == 6)
				icon = new ImageIcon("RED/tiger.png");
			else if(rank == 7)
				icon = new ImageIcon("RED/lion.png");
			else if(rank == 8)
				icon = new ImageIcon("RED/elephant.png");
		} 
		else //blue team
		{
			if(rank == 1)
				icon = new ImageIcon("BLUE/mouse.png");
			else if(rank == 2)
				icon = new ImageIcon("BLUE/cat.png");
			else if(rank == 3)
				icon = new ImageIcon("BLUE/dog.png");
			else if(rank == 4)
				icon = new ImageIcon("BLUE/wolf.png");
			else if(rank == 5)
				icon = new ImageIcon("BLUE/leopard.png");
			else if(rank == 6)
				icon = new ImageIcon("BLUE/tiger.png");
			else if(rank == 7)
				icon = new ImageIcon("BLUE/lion.png");
			else if(rank == 8)
				icon = new ImageIcon("BLUE/elephant.png");
		}
	}
	
	/**
	* Method to set the rank of the animal piece
	* @param rank		boolean value for the rank of the animal piece 
	*/
	public void setRank(int rank)
	{
		this.rank = rank;
	}
	
	/**
	* Method to set if the animal is trapped
	* @param isTrap		boolean value for the status if the animal is trapped or not
	*/
	public void setIsTrapped(boolean isTrap)
	{
		isTrapped = isTrap;
	}
	
	/**
	* Method to set if the animal is at the den
	* @param isDen		boolean value for the status if the animal is at the opponent den
	*/
	public void setIsAtDen(boolean isDen)
	{
		isAtDen = isDen;
	}
	
	/**
	* Method to know if the animal is at the opponent's den or not
	* @return boolean		has the default value of false unless the piece is at the opponent's den		
	*/
	public boolean isAtDen()
	{
		boolean insideDen = false;
		
		if(team) //red
		{
			if(position.getX() == 3 && position.getY() == 8)
				insideDen = true;		
		}
		else //blue
		{
			if(position.getX() == 3 && position.getY() == 0)
				insideDen = true;
		}
		
		return insideDen;
	}
	
	/**
	* Method to let the animal piece move up
	*/
	public void moveUp()
	{
		Position temp;
		
		if(team) //red
			temp = new Position(position.getX(), position.getY()+1);
		else //blue
			temp = new Position(position.getX(), position.getY()-1);
		
		if(temp.isInBounds())
			{
				setPrevPosition(position);
				setPosition(temp);
			}
		else
			setPosition(position);
	}
	
	/**
	* Method to let the animal piece move down
	*/
	public void moveDown()
	{
		Position temp;
		
		if(team) //red
			temp = new Position(position.getX(), position.getY()-1);
		else //blue
			temp = new Position(position.getX(), position.getY()+1);
		
		if(temp.isInBounds())
			{
				setPrevPosition(position);
				setPosition(temp);
			}
		else
			setPosition(position);
	}
	
	/**
	* Method to let the animal piece move right
	*/
	public void moveRight()
	{
		Position temp;
		
		if(team) //red
			temp = new Position(position.getX()-1, position.getY());
		else //blue
			temp = new Position(position.getX()+1, position.getY());

		if(temp.isInBounds())
			{
				setPrevPosition(position);
				setPosition(temp);
			}
		else
			setPosition(position);
	}
	
	/**
	* Method to let the animal piece move left
	*/
	public void moveLeft()
	{
		Position temp;
		
		if(team) //red
			temp = new Position(position.getX()+1, position.getY());
		else //blue
			temp = new Position(position.getX()-1, position.getY());

		if(temp.isInBounds())
			{
				setPrevPosition(position);
				setPosition(temp);
			}
		else
			setPosition(position);
	}
	
	/**
	* Abstract boolean method for knowing if the capture is valid or not
	* @param prey		the piece that will be captured
	* @return boolean		the boolean value if the move is valid
	*/
	//this will know if the capture move is valid in terms of movement (checks position if it just moves 1), ranking and team
	public abstract boolean isValidCapture(Animal prey);
	
	@Override
	public String toString()
	{
		String[] names = new String[]{"Mouse", "Cat", "Wolf", "Dog", "Leopard", "Tiger", "Lion", "Elephant"};
		
		if(team == true)
			return ("Red " + names[rank-1] + " is at " + position.getX() + " " + position.getY());
		else
			return ("Blue " + names[rank-1] + " is at " + position.getX() + " " + position.getY());
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Animal temp = (Animal) obj;
		
		return ((getRank() == temp.getRank()) && (getTeam() == temp.getTeam()));
	}
	
}
