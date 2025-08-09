/**
* "Driver" Class for the GUI Implementation of the Main Menu
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
import controller.Controller;
import model.Player;
import view.InstructionsWindow;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* StartMenu Class for the GUI Program of the Machine Project
*/
public class Driver {

	private JFrame frmAnimalChess;
	private JTextField txtAnimalChess;

	/**
	* Constructor for the declaration of the main menu
	* @param p1		player 1 of the game
	* @param p2		player 2 of the game
	*/
	public Driver(Player p1, Player p2) 
	{
		initialize(p1, p2);
	}
	
	/**
	* Method for the initialization and implementation of the GUI by using Swing
	* @param p1		player 1 of the game
	* @param p2		player 2 of the game
	*/
	private void initialize(Player p1, Player p2) {
		frmAnimalChess = new JFrame();
		frmAnimalChess.setTitle("ANIMAL CHESS");
		frmAnimalChess.setResizable(false);
		frmAnimalChess.setBounds(100, 100, 630, 810);
		frmAnimalChess.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAnimalChess.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(10, 11, 604, 749);
		frmAnimalChess.getContentPane().add(panel);
		panel.setLayout(null); 
		
		txtAnimalChess = new JTextField();
		txtAnimalChess.setEditable(false);
		txtAnimalChess.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnimalChess.setFont(new Font("Quicksand Bold", Font.PLAIN, 75));
		txtAnimalChess.setOpaque(false);
		txtAnimalChess.setBorder(null);
		txtAnimalChess.setBounds(10, 117, 584, 126);
		txtAnimalChess.setText("ANIMAL CHESS");
		panel.add(txtAnimalChess);
		txtAnimalChess.setColumns(10);
		
		JButton btnStart = new JButton("PLAY");
		btnStart.setRequestFocusEnabled(false);
		btnStart.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStart.setFont(new Font("Warung Kopi", Font.PLAIN, 35));
		btnStart.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Controller game = new Controller(p1, p2);
				frmAnimalChess.setVisible(false); 
			}
		}); 
		btnStart.setBounds(189, 326, 219, 71);
		panel.add(btnStart);
		
		JButton btnOptions = new JButton("INSTRUCTIONS");
		btnOptions.setRequestFocusEnabled(false);
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btnOptions.setEnabled(false);
				InstructionsWindow frame1 = new InstructionsWindow();
				frame1.setVisible(true);
			}
		});
		btnOptions.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOptions.setFont(new Font("Warung Kopi", Font.PLAIN, 31));
		btnOptions.setBounds(189, 431, 219, 71);
		panel.add(btnOptions);  
		 
		JButton btnQuit = new JButton("QUIT");
		btnQuit.setRequestFocusEnabled(false);
		btnQuit.setHorizontalTextPosition(SwingConstants.CENTER); 
		btnQuit.setFont(new Font("Warung Kopi", Font.PLAIN, 35));
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(189, 533, 219, 71);
		panel.add(btnQuit);
		
		JLabel bgimg = new JLabel(new ImageIcon("NEUTRAL/menubg.png"));
		bgimg.setLocation(0, 0);
		bgimg.setSize(new Dimension(624, 781));
		frmAnimalChess.getContentPane().add(bgimg);
	}
	
	/**
	* Main method
	* @param args		the string for the main method
	*/
	public static void main(String[] args) {
		Player p1 = new Player("Airon", true);
		Player p2 = new Player("Julia", false);
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Driver window = new Driver(p1, p2);
				window.frmAnimalChess.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				}
			}
		});
	}
	
} 
