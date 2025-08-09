package view;

/**
* "InstructionWindow" Class for the GUI Implementation of the Instructions Frame of the game
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

/**
* InstructionsWindow Class for the GUI Program of the Machine Project
*/
@SuppressWarnings("serial")
public class InstructionsWindow extends JFrame {
	
	/**
	* Method for the text field used in the frame
	*/
	private JTextField txtInstructions;

	/**
	* Constructor for the declaration of the instructions window of the game
	*/
	public InstructionsWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAutoRequestFocus(false);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 550, 750);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 0, 614, 780);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtInstructions = new JTextField();
		txtInstructions.setFocusable(false);
		txtInstructions.setEditable(false);
		txtInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		txtInstructions.setFont(new Font("Quicksand Bold", Font.PLAIN, 50));
		txtInstructions.setText("INSTRUCTIONS");
		txtInstructions.setOpaque(false);
		txtInstructions.setBorder(null);
		txtInstructions.setBounds(10, 28, 524, 48);
		panel.add(txtInstructions);
		txtInstructions.setColumns(10);
		
		JTextPane txtpnAnimalChessIs = new JTextPane();
		txtpnAnimalChessIs.setFocusable(false);
		txtpnAnimalChessIs.setEditable(false);
		txtpnAnimalChessIs.setFont(new Font("Warung Kopi", Font.PLAIN, 16));
		txtpnAnimalChessIs.setOpaque(false);
		txtpnAnimalChessIs.setBorder(null);
		txtpnAnimalChessIs.setText("Animal Chess is a turn-based two-player board game. The game board has 9 rows and 7 columns, where each space on the board is either a land, a trap, an animal den, or a river.\r\n\r\nAt the start of the game, each player will get a random animal. The one with the higher-ranked animal is the priority player. The players will choose a color for their pieces (red/blue). The players will take turns in moving their pieces on the board. Each player can move their pieces one space, horizontally or vertically.\r\n\r\nThere are two ways to win:\r\n    1. When a player successfully moves any of the animal pieces to the opponent's den.\r\n    2. When a player captures all the animal pieces of the opponent. ");
		txtpnAnimalChessIs.setBounds(10, 87, 524, 270);
		panel.add(txtpnAnimalChessIs);
		
		JLabel rankingimg = new JLabel();
		rankingimg.setFocusable(false);
		rankingimg.setIcon(new ImageIcon("C:\\Users\\julia\\Desktop\\DARIAKULT\\MCO2PROJECTFINAL\\img\\NEUTRAL\\rankingpic.png"));
		rankingimg.setBounds(20, 357, 510, 62);
		panel.add(rankingimg);
		
		JTextPane txtpnMovementThe = new JTextPane();
		txtpnMovementThe.setEditable(false);
		txtpnMovementThe.setFocusable(false);
		txtpnMovementThe.setOpaque(false);
		txtpnMovementThe.setFont(new Font("Warung Kopi", Font.PLAIN, 16));
		txtpnMovementThe.setText("Movement: \r\n- The mouse is the only animal that is allowed to move on the river.\r\n- Both the lion and tiger can jump from the land before the river to the land after the river, horizontally or vertically, as long as there is no mouse along the way\r\n- A player may not move his own piece to his own animal den.\r\n\r\nCapturing:\r\n- A player may capture an opponent's piece with a higher rank that is on one of his traps.\r\n- An elephant may not capture a mouse while the mouse can capture an elephant.\r\n- A mouse on the river may not capture an elephant or another mouse on land.\r\n- A mouse on the river may capture another mouse on the river.\r\n- A mouse on land may not capture a mouse on the river.");
		txtpnMovementThe.setBounds(10, 424, 524, 286);
		panel.add(txtpnMovementThe);
		
		JLabel bgimg1 = new JLabel();
		bgimg1.setIcon(new ImageIcon("NEUTRAL/menubg.png"));
		bgimg1.setBounds(0, 0, 614, 780);
		getContentPane().add(bgimg1);
	}
	
}