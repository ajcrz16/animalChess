package view;

import model.Tile;
import model.Position;

/**
* "GameBoard" Class for representing the game board for the animal chess 
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.Font;

/**
* GameBoard Class for the game proper
*/
public class GameBoard {
		
	JFrame win;
	JLabel backg;
	JLabel winMessage = new JLabel();
	JFrame f = new JFrame("Animal Chess");
    JButton[][] button = new JButton[7][9];
    JPanel content = new JPanel();
    JPanel buttonsPanel = new JPanel();  
	
    /**
	* Constructor for the initialization and implementation of the game board
	* @param board		displays the setup of the gameboard with the corresponding JFrame
	*/
	public GameBoard(Tile[][] board)
	{
		setup(board);
	    content.add(buttonsPanel, BorderLayout.CENTER);
	    f.setContentPane(content);	
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    f.setSize(630,810);
	    f.setResizable(false);
	    f.setVisible(true);
	}
	
	/**
	* Method for the initialization and implementation of the game board
	* @param tiles		the different tiles by implementing JButton
	*/
	public void setup(Tile[][] tiles)
	{
		int i,j;
		ImageIcon icon = null;
		content.setLayout(new BorderLayout());
		buttonsPanel.setLayout(new GridLayout(9,7,3,3));   
		
	    for(i=0;i<9;i++)
	    {
	    	for(j=0;j<7;j++)
	    	{
	    		button[j][i] = new JButton();
	    		Image img = tiles[j][i].getIcon().getImage();
	    		if(tiles[j][i].getIsHighlighted())
	    			button[j][i].setBackground(Color.YELLOW);
	    		else
	    		{
	    				button[j][i].setBorder(BorderFactory.createEmptyBorder());
	    				button[j][i].setBorderPainted(true);
	    				Image nImg = img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
	    				icon = new ImageIcon(nImg);	
	    				button[j][i].setIcon(icon);
	    		}
	    		buttonsPanel.add(button[j][i]);
	    	}
	    }
	    buttonsPanel.repaint();
	    buttonsPanel.revalidate();
	}
	
	/**
	* Method Tile[][] for the initialization of the highlighted tiles for every move
	* @param tiles		the different tiles by implementing JButton
	* @param buttons	the arraylist of the different buttons in the board
	* @return tiles		returns the tiles after every move
	*/
	public Tile[][] highlightButtons(Tile[][] tiles, ArrayList<Tile> buttons) //this will highlight the tiles that are suggested 
	{
		int x;
		Tile tTemp;
		Position temp;
	
		for(x = 0; x < buttons.size(); x++)
		{
			tTemp = buttons.get(x);
			temp = tTemp.getPosition();
			tiles[temp.getX()][temp.getY()].setIsHighlighted(true);
		}	
	
		return tiles;
	}
	
	/**
	* Method for setting an ActionListener for every move
	* @param listener		the representation of each JButton for every tile
	*/
	public void setActionListener(ActionListener listener)//adds action listener to every JButtons which represents 1 tile
	{
		int x, y;
		
		for(x = 0; x < 9 ; x++)
		{
			for(y = 0; y < 7; y++)
				button[y][x].addActionListener(listener);
		}
	}
	
	/**
	* Method for setting the winner for the game
	* @param name		the name of the winner
	*/
	public void setWinner(String name)
	{
		winMessage.setText(name);
	}
	
	/**
	* Method JButton[][] for getting the buttons for each turn
	* @return JButton		returns the button after each turn
	*/
	public JButton[][] getButtons()
	{
		return button;
	}
	
	/**
	* Method JFrame for getting the pop-up frame if a player won
	* @return JFrame		returns the frame congratulations if a player won the game
	*/
	public JFrame getWinnerFrame()
	{
		win = new JFrame("CONGRATULATIONS!");
		win.setLocation(400, 300);
		win.setSize(300, 200);
		win.setResizable(false); 
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		win.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setFocusable(false);
		panel.setBounds(0, 0, 300, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		winMessage.setHorizontalAlignment(SwingConstants.CENTER);
		winMessage.setOpaque(false);
		winMessage.setFont(new Font("Warung Kopi", Font.PLAIN, 20));
		winMessage.setBounds(0, 46, 284, 35);
		panel.add(winMessage);
		win.setVisible(true);
		
		JLabel backg = new JLabel();
		backg.setBounds(0, 0, 434, 261);
		backg.setIcon(new ImageIcon("NEUTRAL/menubg.png"));
		panel.add(backg); 
		
		return win;
	}
	
}