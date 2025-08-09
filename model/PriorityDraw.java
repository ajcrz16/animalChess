package model;

/**
* "PriorityDraw" Interface for the priority player of the whole game
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
public interface PriorityDraw {
	
	/**
	* Method for the random animal that will give the random number
	* @param number			the number of the rank of each animal
	* @return Animal		returns the animal with the rank
	*/
	public Animal randomAnimal(int number);
	
	/**
	* Integer method for the random number that was given to the player
	* @return int		returns the int value of the random number
	*/
	public int randomNumber();
	
}
