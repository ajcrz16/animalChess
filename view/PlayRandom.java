package view;

import model.Animal;

/**
* "PlayRandom" Class for the GUI Implementation if the Play JButton will be clicked
* @author Airon John Cruz
* @author Julia Ann King
* @since 1.0
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

/**
* PlayRandom Class for the GUI Program of the Machine Project
*/
@SuppressWarnings("serial")
public class PlayRandom extends JFrame {

	private JPanel contentPane;
	
	/**
	* Constructor for the declaration of the game when the Play JButton is clicked
	* @param animal1		random animal for player 1 of the game
	* @param animal2		random animal for player 2 of the game
	* @param priority		the priority player of the game
	*/
	public PlayRandom(Animal animal1, Animal animal2, Boolean priority) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 322, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 0, 309, 311);
		contentPane.add(panel);
		panel.setLayout(null);
		 
		JLabel RandomBlue = new JLabel();
		RandomBlue.setIcon(animal2.getIcon());
		RandomBlue.setBounds(182, 38, 80, 80);
		panel.add(RandomBlue);
		
		JLabel RandomRed = new JLabel();
		RandomRed.setIcon(animal1.getIcon());
		RandomRed.setBounds(44, 38, 80, 80);
		panel.add(RandomRed);
		
		JLabel RandomP1 = new JLabel("PLAYER 1");
		RandomP1.setHorizontalTextPosition(SwingConstants.CENTER);
		RandomP1.setHorizontalAlignment(SwingConstants.CENTER);
		RandomP1.setFont(new Font("Warung Kopi", Font.PLAIN, 25));
		RandomP1.setBounds(35, 137, 103, 24);
		panel.add(RandomP1);
		
		JLabel RandomP2 = new JLabel("PLAYER 2");
		RandomP2.setHorizontalTextPosition(SwingConstants.CENTER);
		RandomP2.setHorizontalAlignment(SwingConstants.CENTER);
		RandomP2.setFont(new Font("Warung Kopi", Font.PLAIN, 25));
		RandomP2.setBounds(170, 137, 103, 24);
		panel.add(RandomP2);
		
		if(priority)
		{
			JLabel FirstP1 = new JLabel("PLAYER 1 YOU ARE THE PRIORITY PLAYER!");
			FirstP1.setFont(new Font("Warung Kopi", Font.PLAIN, 17));
			FirstP1.setHorizontalTextPosition(SwingConstants.CENTER);
			FirstP1.setHorizontalAlignment(SwingConstants.CENTER);
			FirstP1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			FirstP1.setBackground(UIManager.getColor("Button.background"));
			FirstP1.setOpaque(true);
			FirstP1.setBounds(13, 185, 278, 33);
			panel.add(FirstP1);
		}
		else
		{		
			JLabel FirstP2 = new JLabel("PLAYER 2 YOU ARE THE PRIORITY PLAYER!");
			FirstP2.setOpaque(true);
			FirstP2.setHorizontalTextPosition(SwingConstants.CENTER);
			FirstP2.setHorizontalAlignment(SwingConstants.CENTER);
			FirstP2.setFont(new Font("Warung Kopi", Font.PLAIN, 17));
			FirstP2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			FirstP2.setBackground(SystemColor.menu);
			FirstP2.setBounds(13, 185, 278, 33);
			panel.add(FirstP2);
		}
		
		JLabel imgbg = new JLabel();
		imgbg.setIcon(new ImageIcon("NEUTRAL/menubg.png"));
		imgbg.setBounds(0, 0, 309, 311);
		contentPane.add(imgbg);
	}
	
} 