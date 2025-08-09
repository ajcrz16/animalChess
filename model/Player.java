package model;

/**
* "Player" Class representing the characteristics of the player for the game
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
import java.util.*;

/**
* Player Class for the game proper
*/
public class Player {
	
	private String name;
	private boolean team;
	private boolean isWinner; //set to true so that when one concedes or wins the game, the one left with "true" value is the winner, while the losing player will have "false" value
	private boolean isPriority;
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	
	/**
	* Constructor for the characteristics of the player
	* @param name		the name of the player
	* @param team		if the player plays the red or the blue side
	*/
	public Player(String name, boolean team)
	{
		setName(name);
		setTeam(team);
		setIsWinner(true);
		restart();
	}
	
	/**
	* Method to get the name of the player
	* @return String		returns the name of the player
	*/
	public String getName()
	{
		return name;
	}
	
	/**
	* Method to get the team of the player
	* @return boolean		returns the boolean value if the player plays the red pieces or blue pieces
	*/
	public boolean getTeam()
	{
		return team;
	}
	
	/**
	* Method to get the winner of the game
	* @return boolean		returns the boolean value if there is a winner for the current game
	*/
	public boolean getIsWinner()
	{
		return isWinner;
	}
	
	/**
	* Method to get the priority player of the game
	* @return boolean		returns the boolean value if player 1 or 2 is the priority player
	*/
	public boolean getIsPriority()
	{
		return isPriority;
	}
	
	/**
	* ArrayList Animal Method to get the animals for each player
	* @return ArrayList		returns the animals with the corresponding team for each player
	*/
	public ArrayList<Animal> getAnimal()
	{
		return animals;
	}
	
	/**
	* Method to get the animal with its rank
	* @param rank			gives the rank of each animal
	* @return Animal		returns the animal with its rank
	*/
	public Animal getAnimal(int rank)
	{
		return animals.get(rank - 1);
	}
	
	/**
	* Method to set the name of the player
	* @param name		sets the String name of the player
	*/
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	* Method to set the winner of the game
	* @param winner		sets the boolean value if a player won the game
	*/
	public void setIsWinner(boolean winner)
	{
		isWinner = winner;
	}
	
	/**
	* Method to set the priority player of the game
	* @param priority		sets the boolean value if a player is the priority player of the game
	*/
	public void setIsPriority(boolean priority)
	{
		isPriority = priority;
	}
	
	/**
	* Method to set the team of the game with red and blue side
	* @param team		sets the boolean value if the player is playing the red or blue side
	*/
	public void setTeam(boolean team)
	{
		this.team = team;
	}
	
	/**
	* Method for showing the player that the animal can move one tile from its original position
	* @param animal		shows the animal and its tiles
	* @param position	shows the position of the animal in the board
	* @return boolean	returns if the animal can move one step or not
	*/
	public boolean oneStepOnly(Animal animal, Position position)
	{
		Position temp = animal.getPosition();
		boolean oneStep = false;
		
		if(temp.getX() == position.getX())
		{
			if((temp.getY() - position.getY() == 1) || (temp.getY() - position.getY() == -1))
				oneStep = true;
			else 
				oneStep = false;
		}
		else if(temp.getY() == position.getY())
		{
			if((temp.getX() - position.getX() == 1) || (temp.getX() - position.getX() == -1) )
				oneStep = true;
			else 
				oneStep = false;
		}
		
		return oneStep;
	}
	
	/**
	* Method for knowing the move of the player
	* @param animal		shows the animal and its tiles
	* @param position	shows the position of the animal in the board
	*/
	public void knowMove(Animal animal, Position position)
	{
		Position temp = animal.getPosition();
		
		if(animal.getTeam()) //red team
		{
			if(temp.getX() == position.getX()) // vertical movements
			{
				if(oneStepOnly(animal, position))
				{
					if(temp.getY() > position.getY())
						animal.moveDown();
					else
						animal.moveUp();
				}
					
			}
			else if(temp.getY() == position.getY()) //horizontal movements
			{
				if(oneStepOnly(animal, position))
				{
					if(temp.getX() > position.getX())
						animal.moveRight();
					else
						animal.moveLeft();
				}
			}
		}
		else //blue team
		{
			if(temp.getX() == position.getX())
			{
				if(oneStepOnly(animal, position))
				{
					if(temp.getY() > position.getY())
						animal.moveUp();
					else
						animal.moveDown();
				}
			}
			else if(temp.getY() == position.getY())
			{
				if(oneStepOnly(animal, position))
				{
					if(temp.getX() > position.getX())
						animal.moveLeft();
					else
						animal.moveRight();
				}
			}
		}
	}
	
	/**
	* Method to know if the game will be stopped
	*/
	public void concede()
	{
		setIsWinner(false);
	}
	
	/**
	* Method to restart the player's moves together with the board
	*/
	public void restart()
	{
		int count = 0;
		
		while(count < 8)
		{
			if(count == 0)
				animals.add(new Mouse(team, count+1));
			else if(count == 1)
				animals.add(new Cat(team, count+1));
			else if(count == 2)
				animals.add(new Wolf(team, count+1));
			else if(count == 3)
				animals.add(new Dog(team, count+1));
			else if(count == 4)
				animals.add(new Leopard(team, count+1));
			else if(count == 5)
				animals.add(new Tiger(team, count+1));
			else if(count == 6)
				animals.add(new Lion(team, count+1));
			else if(count == 7)
				animals.add(new Elephant(team, count+1));
			count++;
		}
	}
	
}