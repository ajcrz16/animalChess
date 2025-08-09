package model;

/**
* "Tile" Class representing for tiles for the game
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
import javax.swing.ImageIcon;

/**
* Tile Class for the board of the game
*/
public class Tile {
	
	private Animal animal;
	private Position position;
	private ImageIcon icon;
	private boolean isOccupied;
	private boolean isHighlighted;
	private boolean isSelected;
	private boolean isRiverLocation;
	private boolean isTrapLocation;
	private boolean isBlueDenLocation;
	private boolean isRedDenLocation;
	
	/**
	* Constructor for the characteristics of the tiles
	* @param position		gets the position of the tile chosen
	*/
	public Tile(Position position) 
	{
		this.position = position;
		setIsOccupied(true);
		setIsSelected(false); 
		setIsHighlighted(false);
		assignDefaultAnimal(position);
		setDefaultIcon();
	}
	
	/**
	* Method to get the animal of the current tile
	* @return Animal		returns the animal for the tile
	*/
	public Animal getAnimal()
	{
		return animal;
	}
	
	/**
	* Method to get the position of the animal piece for the tile
	* @return Position		returns the position of the piece
	*/
	public Position getPosition()	
	{
		return position;
	}
	
	/**
	* Method to get the icon of the animal piece 
	* @return ImageIcon		returns the icon of the animal piece
	*/
	public ImageIcon getIcon()
	{
		return icon;
	}
	
	/**
	* Method to get if the tile is occupied or not
	* @return boolean		returns the position of the piece
	*/
	public boolean getIsOccupied()
	{
		return isOccupied;
	}
	
	/**
	* Method to get if the tile is highlighted for every turn
	* @return boolean		returns the boolean value if the tile is highlighted
	*/
	public boolean getIsHighlighted()
	{
		return isHighlighted;
	}
	
	/**
	* Method to get if the tile is selected in every turn
	* @return boolean		returns the boolean value if the tile is selected
	*/
	public boolean getIsSelected()
	{
		return isSelected;
	}
	
	/**
	* Method to get if the location of the river is the chosen tile
	* @return boolean		returns the boolean value if the tile is the river location
	*/
	public boolean getIsRiverLocation()
	{
		return isRiverLocation;
	}
	
	/**
	* Method to get if the location of the trap is the chosen tile
	* @return boolean		returns the boolean value if the tile is the trap location
	*/
	public boolean getIsTrapLocation()
	{
		return isTrapLocation;
	}
	
	/**
	* Method to get if the location of the blue den is the chosen tile
	* @return boolean		returns the boolean value if the tile is the blue den location
	*/
	public boolean getIsBlueDenLocation()
	{
		return isBlueDenLocation;
	}
	
	/**
	* Method to get if the location of the red den is the chosen tile
	* @return boolean		returns the boolean value if the tile is the red den location
	*/
	public boolean getIsRedDenLocation()
	{
		return isRedDenLocation;
	}
	
	/**
	* Method to set the animal for each tile
	* @param animal		to set the position of the animal in each tile
	*/
	public void setAnimal(Animal animal)
	{
		this.animal = animal;
	}
	
	/**
	* Method to set the icons of the animal pieces with the corresponding image
	* @param icon		shows the image of the tiles
	*/
	public void setIcon(ImageIcon icon)
	{
		this.icon = icon;
	}
	
	/**
	* Method to set the default icons for the tiles which are the river, trap, den, and grass
	*/
	public void setDefaultIcon()
	{
		if(getIsOccupied())
			icon = animal.getIcon();
		else
		{
			if(getIsRiverLocation())
				icon = new ImageIcon("NEUTRAL/river.png");
			if(getIsTrapLocation())
				icon = new ImageIcon("NEUTRAL/trap.png");
			if(getIsBlueDenLocation()|| getIsRedDenLocation())
				icon = new ImageIcon("NEUTRAL/den.png");
			if(!getIsRiverLocation() && !getIsTrapLocation() && !getIsBlueDenLocation() && !getIsRedDenLocation())	
				icon = new ImageIcon("NEUTRAL/grass.png"); //grass
		}		
	}
	
	/**
	* Method to set the selected tile
	* @param select			sets the tile that is selected for the turn
	*/
	public void setIsSelected(boolean select)
	{
		isSelected = select;
	}
	
	/**
	* Method to set the highlighted tile
	* @param highlighted		sets the tile that will be highlighted for the turn
	*/
	public void setIsHighlighted(boolean highlighted)
	{
		isHighlighted = highlighted;
	}
	
	/**
	* Method to set the occupied tile
	* @param occupied		sets the tile that is occupied for the turn
	*/
	public void setIsOccupied(boolean occupied)
	{
		isOccupied = occupied;
	}
	
	/**
	* Method to set the position of the river tile
	* @param pos		sets the position of the river in the board
	*/
	public void setIsRiverLocation(Position pos)
	{
		if(pos.getX() == 1)
		{
			if(pos.getY() == 3 || pos.getY() == 4 || pos.getY() == 5)
				isRiverLocation = true;
		}
		else if(pos.getX() == 2)
		{
			if(pos.getY() == 3 || pos.getY() == 4 || pos.getY() == 5)
				isRiverLocation = true;
			else
				isRiverLocation = false;
		}
		else if(pos.getX() == 4)
		{
			if(pos.getY() == 3 || pos.getY() == 4 || pos.getY() == 5)
				isRiverLocation = true;
			else
				isRiverLocation = false;
		}
		else if(pos.getX() == 5)
		{
			if(pos.getY() == 3 || pos.getY() == 4 || pos.getY() == 5)
				isRiverLocation = true;
			else
				isRiverLocation = false;
		}
		else
			isRiverLocation = false;
	}
	
	/**
	* Method to set the position of the trap tile
	* @param pos		sets the position of the traps in the board
	*/
	public void setIsTrapLocation(Position pos)
	{
		if(pos.getX() == 2)
		{
			if(pos.getY() == 0 || pos.getY() == 8)
				isTrapLocation = true;
			else 
				isTrapLocation = false;
		}
		else if(pos.getX() == 3)
		{
			if(pos.getY() == 1 || pos.getY() == 7)
				isTrapLocation = true;
			else 
				isTrapLocation = false;
		}
		else if(pos.getX() == 4)
		{
			if(pos.getY() == 0 || pos.getY() == 8)
				isTrapLocation = true;
			else 
				isTrapLocation = false;
		}
		else 
			isTrapLocation = false;
	}
	
	/**
	* Method to set the position of the blue den tile
	* @param pos		sets the position of the blue den in the board
	*/
	public void setIsBlueDenLocation(Position pos) //where blue pieces will be stored to win
	{
		if(pos.getX() == 3 && pos.getY() == 0)
			isBlueDenLocation = true;
		else 
			isBlueDenLocation = false;
	}
	
	/**
	* Method to set the position of the red den tile
	* @param pos		sets the position of the red den in the board
	*/
	public void setIsRedDenLocation(Position pos)
	{
		if(pos.getX() == 3 && pos.getY() == 8)
			isRedDenLocation = true;
		else
			isRedDenLocation = false;
	}
	
	/**
	* Method to set the position of the animals at the start of the game
	* @param pos		sets the position of the animals in the board
	*/
	public void assignDefaultAnimal(Position pos)
	{
		setIsRiverLocation(pos);
		setIsTrapLocation(pos);
		setIsBlueDenLocation(pos);
		setIsRedDenLocation(pos);
		
		if(pos.getX() == 0 && pos.getY() == 2)
		{
			Animal temp = new Mouse(true, 1);
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 5 && pos.getY() == 1)
		{
			Animal temp = new Cat(true, 2);
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 4 && pos.getY() == 2)
		{
			Animal temp = new Wolf(true, 3);
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 1 && pos.getY() == 1)
		{
			Animal temp = new Dog(true, 4);
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 2 && pos.getY() == 2)
		{
			Animal temp = new Leopard(true, 5);
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 6 && pos.getY() == 0)
		{
			Animal temp = new Tiger(true, 6);
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 0 && pos.getY() == 0)
		{
			Animal temp = new Lion(true, 7);
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 6 && pos.getY() == 2)
		{
			Animal temp = new Elephant(true, 8);
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 6 && pos.getY() == 6)
		{
			Animal temp = new Mouse(false, 1);	
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 1 && pos.getY() == 7)
		{
			Animal temp = new Cat(false, 2);	
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 2 && pos.getY() == 6)
		{
			Animal temp = new Wolf(false, 3);	
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 5 && pos.getY() == 7)
		{
			Animal temp = new Dog(false, 4);	
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 4 && pos.getY() == 6)
		{
			Animal temp = new Leopard(false, 5);	
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 0 && pos.getY() == 8)
		{
			Animal temp = new Tiger(false, 6);	
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 6 && pos.getY() == 8)
		{
			Animal temp = new Lion(false, 7);	
			setAnimal(temp);
			setIsOccupied(true);
		}
		else if(pos.getX() == 0 && pos.getY() == 6)
		{
			Animal temp = new Elephant(false, 8);
			setAnimal(temp);
			setIsOccupied(true);
		}
		else
		{
			setAnimal(null);
			setIsOccupied(false);
		}
	}
	
	/**
	* Method to transfer the animals after each turn
	* @param animal		gets the animal for the transfer
	*/
	public void transferAnimal(Animal animal)
	{
		animal.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY()));
		setAnimal(animal);
		setIsOccupied(true);
		setIcon(animal.getIcon());
		animal.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY()));
		
		if(getIsBlueDenLocation() && animal.getTeam() == true)
			animal.setIsAtDen(true);
		else if(getIsRedDenLocation() && animal.getTeam() == false)
			animal.setIsAtDen(true);
		if(getIsTrapLocation())
			animal.setIsTrapped(true);
		else
			animal.setIsTrapped(false);
	}
	
	/**
	* Method to release the animals after each turn
	*/
	public void releaseAnimal()
	{
		setAnimal(null);
		setIsOccupied(false);
		
		if(this.getIsRiverLocation()) 
			setIcon(new ImageIcon("NEUTRAL/river.png"));
		else if(this.getIsTrapLocation())
			setIcon(new ImageIcon("NEUTRAL/trap.png"));
		else if(this.getIsBlueDenLocation() || this.getIsRedDenLocation())
			setIcon(new ImageIcon("NEUTRAL/den.png"));
		else 
			setIcon(new ImageIcon("NEUTRAL/grass.png"));
	}
	
	/**
	* Method to validate if the mouse is in the river tile
	* @return boolean		returns the boolean value if the mouse is in the river
	*/
	public boolean mouseInRiver()
	{
		return (getIsRiverLocation() && getIsOccupied());
	}
	
	@Override
	public String toString()
	{
		return ("POSITION: " + position.getX() + ", " + position.getY() );
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Tile temp = (Tile) obj;
		
		return (this.getPosition().equals(temp.getPosition()));
		
	}
	
}