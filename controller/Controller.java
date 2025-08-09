package controller;

/**
* "Controller" Class representing for the overall mechanics of the game and the game proper
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
import model.GameModel;
import model.Tile;
import model.Player;
import model.Animal;
import model.Mouse;
import model.Elephant;
import model.Position;
import view.GameBoard;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

/** 
* Controller Class for the game proper
*/
public class Controller implements ActionListener {
	
	boolean isTurn;
	private GameBoard view;
	private GameModel model;
	@SuppressWarnings("unused")
	private boolean win; 
	ArrayList<Tile> available = new ArrayList<Tile>();
	JButton selectedTile = null; 
	JButton targetTile = null;
	Tile a;
	Tile b = null;
	//Player p1 = new Player("Airon", true);
	//Player p2 = new Player("Julia", false);
	Player p1;
	Player p2;
	private Tile[][] board = new Tile[7][9];
	private JButton[][] button = new JButton[7][9];
	private int x;
	private int y;
	int count = 0;
	
	/**
	* Constructor for the declaration of the window that will be visible for the game
	* @param p1		player 1 of the game
	* @param p2		player 2 of the game
	*/
	public Controller(Player p1, Player p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		win = false;
		model = new GameModel(p1, p2);
		board = model.getBoard();
		view = new GameBoard(board);
		view.setActionListener(this);
		button = view.getButtons(); 
		isTurn = model.assignRandomAnimal(p1, p2);
		if(isTurn)
		{
			p1.setIsPriority(true);
			p2.setIsPriority(false);
		}
		else
		{
			p1.setIsPriority(false);
			p2.setIsPriority(true);
		}
	}
	
	/**
	* Method for the action performed after each turn of the player and after every move it prints if a player won in the terminal
	* @param e		the ActionEvent e is used for the processing of each move
	*/
	public void actionPerformed(ActionEvent e)
	{
		if(!model.checkWinnerByAlivePieces(p1, p2) && !model.checkWinnerByDen(board)) //add winning conditions here
		{ 	
				processMove(e);
				for(int c = 0; c < 9; c++)
				{
					for(int d = 0; d <7; d++)
					{
						board[d][c].setIsHighlighted(false);
					}
				}
			System.out.println("WINNER BY: " +model.checkWinnerByAlivePieces(p1,p2) + ", " + model.checkWinnerByDen(board));
		}
		else
			showWinner(p1, p2);
	}
	
	/**
	* Method for the processing of every movement done in the board game
	* @param e		the ActionEvent e is used for the processing of each move
	*/
	public void processMove(ActionEvent e)
	{
		//this is just for simulation, but the boolean here must be directed to who wins the prioritization round!!
		int i = 0;
		int j = 0;
		ArrayList<Tile> highlighted = new ArrayList<Tile>();
		
		Object source = e.getSource();
		for( i = 0 ; i < 9; i++)
		{
			for( j = 0; j < 7; j++)
			{
				if(button[j][i] ==  source)
				{
					x = j;
					y = i;
				}	
			}	
		}
		updateSelection(x, y);
		targetTile= button[x][y];
		b = board[x][y];
		count++;
		if(isTurn == p1.getIsPriority()) //(RED'S TURN)
		{
			if(count < 3) //if count is odd, then the it is the selectedtile, if even then it is the target tile
			{ 
				switch(count)
				{
					case 1 : 
					{
						if(b.getAnimal() != null && b.getAnimal().getTeam() == isTurn) //animal != null
						{ 
							selectedTile = targetTile;
							a = b;
							button[x][y].setBorderPainted(true);
							button[x][y].setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
							board = view.highlightButtons(board, model.availableMoves(board[x][y], board));
							for(int c = 0; c < 9; c++)
							{
								for(int d = 0; d <7; d++)
								{
									if(board[d][c].getIsHighlighted())
									{
										button[d][c].setBorderPainted(true);	
										button[d][c].setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
										available.add(board[d][c]);
										highlighted.add(board[d][c]);
									}
									else 
										button[d][c].setBorderPainted(false);		
								}
							}
						}
						else //count will now be equal to one 
							count = 0;
					} break;
					case 2 : 
					{
						if(selectedTile == targetTile)
						{
							selectedTile = null;
							a = null;
							count = 0;
						}
						System.out.println("PASSABLE : " + checkTarget(available, board[x][y], board[a.getPosition().getX()][a.getPosition().getY()]) + ", SIZE: " + available.size()); //just for checking
						if(checkTarget(available, board[x][y], board[a.getPosition().getX()][a.getPosition().getY()]))
						{
							if(b.getIsOccupied())
								model.updateCapturedAnimal(p1, p2, b.getAnimal());
							board[x][y].transferAnimal(a.getAnimal());
							updateAnimalPosition(a.getAnimal());
							board[a.getPosition().getX()][a.getPosition().getY()].releaseAnimal();
							button[x][y].setIcon(board[x][y].getIcon());
							button[a.getPosition().getX()][a.getPosition().getY()].setIcon(board[a.getPosition().getX()][a.getPosition().getY()].getIcon());
							
							isTurn = !isTurn;
							p1.setIsPriority(false);
							p2.setIsPriority(true);
							count = 0;
							available.clear();
						}	
						else
							count = 0;
					} break;
				} 	
			} 
		} 
		else //(BLUE'S TURN)
		{ 
			if(count < 3)
			{ 
				switch(count)
				{
					case 1 : 
					{
						if(b.getAnimal() != null && b.getAnimal().getTeam() == isTurn)
						{
							selectedTile= targetTile;
							a = b;
							button[x][y].setBorderPainted(true);
							button[x][y].setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
							board = view.highlightButtons(board, model.availableMoves(board[x][y], board));
							for(int c = 0; c < 9; c++)
							{
								for(int d = 0; d <7; d++)
								{
									if(board[d][c].getIsHighlighted())
									{
										button[d][c].setBorderPainted(true);	
										button[d][c].setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
										available.add(board[d][c]);
										highlighted.add(board[d][c]);
									}
									else 
										button[d][c].setBorderPainted(false);		
								}
							}
						} 
						else //count will now be equal to one 
							count = 0;
							 
					} break;
					case 2 : 
					{
						if(selectedTile == button[x][y])
						{
							selectedTile = null;
							a = null;
							count = 0;
						}
						System.out.println("PASSABLE : " + checkTarget(available, board[x][y], board[a.getPosition().getX()][a.getPosition().getY()]) + ", SIZE: " + available.size()); //just for checking
						if(checkTarget(available, board[x][y], board[a.getPosition().getX()][a.getPosition().getY()]))
						{
							if(b.getIsOccupied())
								model.updateCapturedAnimal(p1, p2, b.getAnimal());
							board[x][y].transferAnimal(a.getAnimal());
							updateAnimalPosition(a.getAnimal());
							board[a.getPosition().getX()][a.getPosition().getY()].releaseAnimal();
							button[x][y].setIcon(board[x][y].getIcon());
							button[a.getPosition().getX()][a.getPosition().getY()].setIcon(board[a.getPosition().getX()][a.getPosition().getY()].getIcon());
								
							isTurn = !isTurn;
							p1.setIsPriority(true);
							p2.setIsPriority(false);
							count = 0;
							available.clear();
						}	
						else
							count = 0;
					} break;
				}
			}
		}
	}
	
	/**
	* Method for setting the players to player 1 and player 2
	* @param p1		sets player 1 to the game
	* @param p2		sets player 2 to the game
	*/
	public void setPlayers(Player p1, Player p2)
	{
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/**
	* Method for checking the target tile of each animal piece
	* @param coveredArea		the covered area for each movement
	* @param selected			the selected tile for movement
	* @param firstClick			the tile that will be clicked first for each turn
	* @return boolean			returns the boolean value if the piece can transfer or not
	*/
	public boolean checkTarget(ArrayList<Tile> coveredArea, Tile selected, Tile firstClick)
	{
		Animal animal;
		int count =0;
		boolean canTransfer = false;
		
		for(count = 0 ; count < coveredArea.size(); count++)
		{
			if(selected == coveredArea.get(count))
			{
				if(selected.getIsOccupied())
				{
					if(selected.getAnimal().getTeam() != isTurn) //if the second-clicked tile has an animal from opposite team
					{
						if(firstClick.getAnimal().getRank() >= selected.getAnimal().getRank())  
						{
							if(firstClick.getIsTrapLocation()) //if Trapped
							{
								canTransfer = false;
								count = coveredArea.size();
							}
							else if(selected.getIsRiverLocation())
							{
								canTransfer = false;
								count = coveredArea.size();
							}
							else
							{
								if(firstClick.getAnimal() instanceof Elephant && selected.getAnimal() instanceof Mouse) //elephant cant capture mouse
								{
									if(selected.getIsTrapLocation())
									{
										canTransfer = true;
										count = coveredArea.size();
										animal = selected.getAnimal();
										animal.setIsAlive(false);
										selected.setAnimal(animal);
									}
									else
									{
										canTransfer = false;
										count = coveredArea.size();
									}
								}
								else if((firstClick.getIsRiverLocation() && firstClick.getAnimal() instanceof Mouse) && (!selected.getIsRiverLocation() && selected.getAnimal() instanceof Mouse)) //mouse cannot capture another mouse when it is in river
								{
									canTransfer = false;
									count = coveredArea.size();
								}
								else if((!firstClick.getIsRiverLocation() && firstClick.getAnimal() instanceof Mouse) && (selected.getIsRiverLocation() && selected.getAnimal() instanceof Mouse)) //mouse cannot capture another mouse when the another mouse is outside the river
								{
									canTransfer = false;
									count = coveredArea.size();
								}
								else
								{
									canTransfer = true;
									count = coveredArea.size();
									animal = selected.getAnimal();
									animal.setIsAlive(false);
									selected.setAnimal(animal);
								}
							}
							}
						else if(firstClick.getAnimal() instanceof Mouse && selected.getAnimal() instanceof Elephant) //mouse captures elephant
						{
							if((firstClick.getIsRiverLocation() && (firstClick.getAnimal() instanceof Mouse))) //if Mouse is in the river, it cannot capture elephant
							{
								canTransfer = false;
								count = coveredArea.size();
							}
							else if(firstClick.getIsTrapLocation())
							{
								canTransfer = false;
								count = coveredArea.size();
							}
							else
							{
								canTransfer = true;
								count = coveredArea.size();
								animal = selected.getAnimal();
								animal.setIsAlive(false);
								selected.setAnimal(animal);
							}
						}
					else if((firstClick.getAnimal().getRank() < selected.getAnimal().getRank()) && selected.getIsTrapLocation()) //if a lower-ranked animal tries to capture a trapped animal
					{
						canTransfer = true;
						count = coveredArea.size();
						animal = selected.getAnimal();
						animal.setIsAlive(false);
						selected.setAnimal(animal);
					}
					}
				}
				else if(!selected.getIsOccupied())//if not occupied
				{
					if(selected.getIsBlueDenLocation() && firstClick.getAnimal().getTeam() == false)
					{
						canTransfer = true;
						count = coveredArea.size();		
					}
					else if(selected.getIsRedDenLocation() && firstClick.getAnimal().getTeam() == true)
					{
						canTransfer = true;
						count = coveredArea.size();	
					}
					else if(selected.getIsRiverLocation() && (firstClick.getAnimal() instanceof Mouse)) //only mouse can be placed on the river firstClick.getAnimal().getRank() == 1
					{
						canTransfer = true;
						count = coveredArea.size();	
						System.out.println(firstClick.getAnimal() instanceof Mouse);
					}
					else if(!selected.getIsRedDenLocation() && !selected.getIsBlueDenLocation() && !selected.getIsRiverLocation())
					{
						canTransfer = true;
						count = coveredArea.size();
					}
				}
			}
		
			System.out.println("Team: " +firstClick.getAnimal().getTeam()+"||    BLUE DEN Resrtriction: " + (selected.getIsBlueDenLocation() && firstClick.getAnimal().getTeam() == true) + "||     RED DEN Restriction: " + (selected.getIsRedDenLocation() &&  firstClick.getAnimal().getTeam() == false));
		}
		
		return canTransfer;
	}
	
	/**
	* Method for showing the winner after the game ended
	* @param p1		player 1 of the game
	* @param p2		player 2 of the game
	*/
	public void showWinner(Player p1, Player p2)
	{
		JFrame winner;
        JPanel btnPanel = new JPanel();
        JButton quit = new JButton("QUIT");
        quit.setFont(new Font("Warung Kopi", Font.PLAIN, 15));
        JButton restart = new JButton("RESTART");
        restart.setFont(new Font("Warung Kopi", Font.PLAIN, 15));
        Player one = new Player(p1.getName(), p1.getTeam());
        Player two = new Player(p2.getName(), p2.getTeam());

        btnPanel.setLayout(new FlowLayout());
        btnPanel.setBounds(0, 128, 284, 35);
        btnPanel.add(quit);
        btnPanel.add(restart);
        btnPanel.setOpaque(false);

        if(p1.getIsWinner() == true && p2.getIsWinner() == false)
            view.setWinner("Congratulations, " + p1.getName() + "!");
        else if(p1.getIsWinner() == false && p2.getIsWinner() == true)
            view.setWinner("Congratulations, " + p2.getName() + "!"); 
        winner = view.getWinnerFrame();
        winner.add(btnPanel, BorderLayout.SOUTH);
        winner.setAlwaysOnTop(true);
        winner.setVisible(true);
        restart.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		@SuppressWarnings("unused")
				Controller controller = new Controller(one, two);
        		winner.dispose();
        	}
        }); 
        quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }); 
	}
	
	/**
	* Method for setting if player 1 or 2 won the game
	* @param p1		player 1 of the game
	* @param p2		player 2 of the game
	*/
	public void setWin(Player p1, Player p2)
	{
		if(p1.getIsWinner() != p2.getIsWinner())
			win = true;
	}
	
	/**
	* Method for updating the position of each piece
	* @param animal		the value of each animal for every turn
	*/
	public void updateAnimalPosition(Animal animal)
	{
		int x;
		
		if(animal.getTeam()) //red
		{
			for(x = 0 ;x < p1.getAnimal().size(); x++)
			{
				if(p1.getAnimal().get(x).getRank() == animal.getRank())
					p1.getAnimal().get(x).setPosition(new Position(animal.getPosition().getX(), animal.getPosition().getY()));
			}
		}
		else //blue
		{
			for(x = 0 ;x < p1.getAnimal().size(); x++)
			{
				if(p2.getAnimal().get(x).getRank() == animal.getRank())
					p2.getAnimal().get(x).setPosition(new Position(animal.getPosition().getX(), animal.getPosition().getY()));
			}
		}
	}
	
	/**
	* Method for updating the selection of the tiles in every turn
	* @param x		the x value of the tile
	* @param y		the y value of the tile
	*/
	public void updateSelection(int x, int y)
	{
			int i, j; 
	 
			for(i = 0; i < 9; i++)
				for(j = 0; j < 7; j++)
				{
					board[j][i].setIsSelected(false);
				}
	 
			board[x][y].setIsSelected(true);
	}
	
}