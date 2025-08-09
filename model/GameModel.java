package model;

import view.PlayRandom;

/**
* "GameModel" Class for representing the game board for the animal chess 
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
import java.util.*;

/**
* GameModel Class that implements the interface PriorityDraw class for every turn
*/
public class GameModel implements PriorityDraw {

	private Tile[][] board = new Tile[7][9];
	private Player player1;
	private Player player2;
	private Player winner;
	PlayRandom random;
	
	/**
	* Constructor for the declaration of the game model for the whole run
	* @param p1		represents Player 1
	* @param p2		represents Player 2
	*/
	public GameModel(Player p1, Player p2)
	{
		Position temp; 
		Tile tTemp;
		int x, y;
		
		for(x = 0; x < 9; x++)
		{
			for(y = 0; y < 7; y++)
			{
				temp = new Position(y, x);
				tTemp = new Tile(temp);
				board[y][x] = tTemp;
			}
		}
		setPlayer1(p1);
		setPlayer2(p2);
		setWinner(null);
	}
	
	/**
	* Method Tile[][] for getting the board to the game
	* @return board		returns the board
	*/
	public Tile[][] getBoard()
	{
		return board;
	}
	
	/**
	* Method Player for getting player 1
	* @return Player		returns player 1
	*/
	public Player getPlayer1()
	{
		return player1;
	}
	
	/**
	* Method Player for getting player 2
	* @return Player		returns player 2
	*/
	public Player getPlayer2()
	{
		return player2;
	}
	
	/**
	* Method Player for getting the winner for the game
	* @return Player		returns the winner of the game
	*/
	public Player getWinner()
	{
		return winner;
	}
	
	/**
	* Method for setting the winner of the game
	* @param player		sets the player as the winner of the game
	*/
	public void setWinner(Player player)
	{
		winner = player;
	}
	
	/**
	* Method for setting player 1 of the game
	* @param player		sets the player 1 of the game
	*/
	public void setPlayer1(Player player)
	{
		player1 = player;
	}
	
	/**
	* Method for setting player 2 of the game
	* @param player		sets the player 2 of the game
	*/
	public void setPlayer2(Player player)
	{
		player2 = player;
	}
	
	/**
	* Method for getting a random number for the start of the game wherein the players will be given animals for the priority player
	* @return int		gets number between 1-8 for the rankings of each animal
	*/
	public int randomNumber()
	{
		Random rand = new Random();
		int num = 0;
		
		do {
			num = rand.nextInt(8);
		} while (num == 0);
		
		return num;
	}
	
	/**
	* Method for setting the animals from 1-8 that corresponds to their ranking
	* @param number		from the randomizer method
	* @return temp		returns if the certain animal was drawn
	*/
	public Animal randomAnimal(int number)
	{
		Animal temp = new Mouse(true, number);
		
		if(number ==1)
			temp = new Mouse(true, number);
		else if(number == 2)
			temp = new Cat(true, number);
		else if(number == 3)
			temp = new Wolf(true, number);
		else if(number == 4)
			temp = new Dog(true, number);
		else if(number == 5)
			temp = new Leopard(true, number);
		else if(number == 6)
			temp = new Tiger(true, number);
		else if(number == 7)
			temp = new Lion(true, number);
		else if(number == 8)
			temp = new Elephant(true, number);
		
		return temp;
	}
	
	/**
	* Method for assigning the random animal to each player
	* @param p1		player 1 of the game
	* @param p2		player 2 of the game
	* @return boolean		returns the boolean value if player 1 or 2 is the priority player
	*/
	public boolean assignRandomAnimal(Player p1, Player p2) //to be called
	{
		boolean priority;
		Animal playerOne = randomAnimal(randomNumber());  
		Animal playerTwo = randomAnimal(randomNumber());;
		String message = new String(); 
		int x = 0;
		Animal show1 = new Mouse(true, 1);
		Animal show2 = new Mouse(false, 1); 
		
		while(playerOne.equals(playerTwo))
		{
			playerOne = randomAnimal(randomNumber());
			playerTwo = randomAnimal(randomNumber());
		}
		if(playerOne.getRank() > playerTwo.getRank())
		{
			player1.setIsPriority(true);
			player2.setIsPriority(false);
			message = player1.getName();
			priority = true; //red is the priority
			for(x = 0; x < p1.getAnimal().size(); x++)
			{
				if(p1.getAnimal().get(x).getRank() == playerOne.getRank())
				{
					show1 = p1.getAnimal().get(x);
					x = p1.getAnimal().size();
				}
			}
			for(x = 0; x < p2.getAnimal().size(); x++)
			{
				if(p2.getAnimal().get(x).getRank() == playerTwo.getRank())
				{
					show2 = p2.getAnimal().get(x);
					x = p2.getAnimal().size();
				}
			}
		}
		else
		{
			player1.setIsPriority(false);
			player2.setIsPriority(true);
			message = player2.getName();
			priority = false; //blue is the priority
			for(x = 0; x < p1.getAnimal().size(); x++)
			{
				if(p1.getAnimal().get(x).getRank() == playerOne.getRank())
				{
					show1 = p1.getAnimal().get(x);
					x = p1.getAnimal().size();
				}
			}
			for(x = 0; x < p2.getAnimal().size(); x++)
			{
				if(p2.getAnimal().get(x).getRank() == playerTwo.getRank())
				{
					show2 = p2.getAnimal().get(x);
					x = p2.getAnimal().size();
				}
			}
		}
		
		random = new PlayRandom(show1, show2, priority);  //delete this, and put this to Controller instead
		random.setVisible(true);
	
		System.out.println (priority + " " + message + ", you are the priority player!");
		
		return priority;
	} 
	
	/**
	* Method for checking if there is a winner with the condition of the opponent having no animals left in the board
	* @param player1		the pieces of player 1
	* @param player2		the pieces of player 2
	* @return boolean		returns boolean if there is winner by the condition
	*/
	public boolean checkWinnerByAlivePieces(Player player1, Player player2)
	{
		int cP1 = 0;
		int cP2 = 0;
		int x = 0; 
		boolean hasWinner = false;
		ArrayList<Animal> p1 = player1.getAnimal();
		ArrayList<Animal> p2 = player2.getAnimal();
				
		for(x = 0; x < p1.size(); x++)
		{
			if(p1.get(x).getIsAlive())
				cP1++;
			if(p2.get(x).getIsAlive())
				cP2++;
		}
		if(cP1 == 0) //return 2, so that it will show that player2 wins the game since player1 has no alive pieces 
		{
			hasWinner = true;
			player1.setIsWinner(false);
			setWinner(player2);
		}
		else if(cP2 == 0)
		{
			hasWinner = true;
			player2.setIsWinner(false);
			setWinner(player1);
		}
		
		return hasWinner;
	}
	
	/**
	* Method for checking if there is a winner with the condition of the reaching the opponent's den
	* @param board			the location of den from the board	
	* @return boolean		returns boolean if there is winner by the condition
	*/
	public boolean checkWinnerByDen(Tile[][] board)
	{
		int x= 0;
		int y = 0;
		boolean hasWinner = false;
		
		for(x = 0; x < 9; x++)
		{
			for(y = 0; y < 7; y++)
			{
				if(board[y][x].getIsBlueDenLocation() && board[y][x].getIsOccupied())
				{
					hasWinner = true;
					player1.setIsWinner(false);
				}
				else if(board[y][x].getIsRedDenLocation() && board[y][x].getIsOccupied())
				{
					hasWinner = true;
					player2.setIsWinner(false);
				}
					
			}
		}
			
		return hasWinner;
	}

	/**
	* Method for placing the animal to the next position if the player moves the animal
	* @param animal			the animal and its corresponding tile and position
	*/
	public void placeAnimal(Animal animal)//if the animal moves, this will change the position of the recorded animal
	{
		Position temp = animal.getPosition();
		Tile bTemp;
		Position checker;
		int x,y;
		
		for(x = 0; x < 9; x++)
		{
			for(y = 0; y < 7; y++)
			{
				checker = board[y][x].getPosition();
				if(temp.equals(checker))
				{
					bTemp = board[y][x];
					bTemp.setAnimal(animal);
					bTemp.setIsOccupied(true);
					board[y][x] = bTemp;
					y = 7;
					x = 9;
				}
			}
		}
		
		refreshTileStatus();
	}
	
	/**
	* Method for showing the availableMoves of the animals per turn
	* @param tile				the tile for the turn
	* @param boardTile			the tiles from the whole game board
	* @return ArrayList			returns the highlighted tiles for each turn
	*/
	public ArrayList<Tile> availableMoves(Tile tile, Tile[][] boardTile) //returns the in-bounded positions of the selected Tile [RESTRICTIONS WILL BE ADDED]
	{
		ArrayList<Tile> highlightedTiles = new ArrayList<Tile>();
		Position temp = tile.getPosition();
		Tile tTemp;
		int x = 0;
		int nMouseChecker = 0;
		
		Position suggest1 = new Position(temp.getX()+1, temp.getY());
		Position suggest2 = new Position(temp.getX()-1, temp.getY());
		Position suggest3 = new Position(temp.getX(), temp.getY()+1);
		Position suggest4 = new Position(temp.getX(), temp.getY()-1);
		

		if(suggest1.isInBounds())
		{
			tTemp = new Tile(suggest1);
			if(tTemp.getIsRiverLocation() && (tile.getAnimal() instanceof Tiger || tile.getAnimal() instanceof Lion))
			{
				for(x = 0; x < 2; x++)
				{
					if(boardTile[suggest1.getX()+x][suggest1.getY()].getAnimal() instanceof Mouse)
						nMouseChecker++;
				}
				if(nMouseChecker == 0)
					highlightedTiles.add(board[suggest1.getX()+2][suggest1.getY()]);
			}
			else
				highlightedTiles.add( (board[suggest1.getX()][suggest1.getY()]));
				
		}
		if(suggest2.isInBounds())
		{
			nMouseChecker = 0;
			tTemp = new Tile(suggest2);
			if(tTemp.getIsRiverLocation() && (tile.getAnimal() instanceof Tiger || tile.getAnimal() instanceof Lion))
			{
				for(x = 0; x < 2; x++)
				{
					if(boardTile[suggest2.getX()-x][suggest2.getY()].getAnimal() instanceof Mouse)
						nMouseChecker++;
				}
				if(nMouseChecker == 0)
					highlightedTiles.add(board[suggest2.getX()-2][suggest2.getY()]);
			}
			else
				highlightedTiles.add((board[suggest2.getX()][suggest2.getY()]));
			
		}
		if(suggest3.isInBounds())
		{
			nMouseChecker = 0;
			tTemp = new Tile(suggest3);
			if(tTemp.getIsRiverLocation() && (tile.getAnimal() instanceof Tiger || tile.getAnimal() instanceof Lion))
			{	
				for(x = 0; x < 3; x++)
				{
					if(boardTile[suggest3.getX()][suggest3.getY()+x].getAnimal() instanceof Mouse)
						nMouseChecker++;
				}
				if(nMouseChecker == 0)
					highlightedTiles.add(board[suggest3.getX()][suggest3.getY()+3]);
			}
			else
				highlightedTiles.add((board[suggest3.getX()][suggest3.getY()]));
				
		}
		if(suggest4.isInBounds())
		{
			nMouseChecker = 0;
			tTemp = new Tile(suggest4);
			if(tTemp.getIsRiverLocation() && (tile.getAnimal() instanceof Tiger || tile.getAnimal() instanceof Lion))
			{
				for(x = 0; x < 3; x++)
				{
					if(boardTile[suggest4.getX()][suggest4.getY()-x].getAnimal() instanceof Mouse)
						nMouseChecker++;
				}
				if(nMouseChecker == 0)
					highlightedTiles.add(board[suggest4.getX()][suggest4.getY()-3]);
			}
			else
				highlightedTiles.add((board[suggest4.getX()][suggest4.getY()]));
		}
		
		return highlightedTiles;
	}
	
	/**
	* Method to update each tile after every turn
	*/
	public void refreshTileStatus() //to make all tiles always updated
	{
		int count = 0;
		int x, y;
		Tile bTemp;
		Animal aTemp;
		Position pTemp;
		
		for(count = 1; count < 16; count++)
		{
			if(count < 9)
				aTemp = player1.getAnimal(count);
			else 
				aTemp = player2.getAnimal(count);
			
			pTemp = aTemp.getPrevPosition();

			for(x = 0; x < 9; x++)
			{
				for(y = 0; y < 7; y++)
				{
					bTemp = board[y][x];
					if(pTemp.equals(bTemp.getPosition()))
					{
						bTemp.setAnimal(null);
						bTemp.setIsOccupied(false);
					}
					board[y][x] = bTemp;
				}
			}
		}
	}
	
	/**
	* Method for updating the captured animal after the turn
	* @param player1		the move of player 1 and the pieces
	* @param player2		the move of player 2 and the pieces
	* @param animal			the animals for their rankings and positions
	*/
	public void updateCapturedAnimal(Player player1, Player player2, Animal animal)
	{
		ArrayList<Animal> animals;
		int x = 0;
		
		if(animal.getTeam()) //if red piece
		{
			animals = player1.getAnimal();
			for(x = 0; x < animals.size(); x++)
			{
				if(animals.get(x).getRank() ==  animal.getRank())
				{
					animal.setIsAlive(false);
					animals.set(x, animal);
				}
			}
		}
		else //if blue piece
		{
			animals = player2.getAnimal();	
			for(x = 0; x < animals.size(); x++)
			{
				if(animals.get(x).getRank() ==  animal.getRank())
				{
					animal.setIsAlive(false);
					animals.set(x, animal);
				}
			}
		}
	} 
	
	/**
	* Method for updating the board after each move and turn from the players
	*/
	public void updateBoard() //the animals position will move, then the new position will be used to change their position on the Tile as well. (PRIORITY OVER THE "placeAnimal" method)
	{
		ArrayList<Animal> animals = new ArrayList<Animal>();
		Position temp;
		int x;
		
		for(x = 0; x < 16; x++)
		{
			if(x < 8)
				animals.add(player1.getAnimal().get(x));
			else
				animals.add(player2.getAnimal().get(x));
			if(animals.get(x).getIsAlive())
			{
				temp = animals.get(x).getPosition();
				board[temp.getX()][temp.getY()].transferAnimal(animals.get(x));
			}
		}
		refreshTileStatus();
	}
	
}