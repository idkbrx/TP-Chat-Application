import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Emoji extends JFrame {

	int emojiPos;

	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emoji frame = new Emoji();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Emoji() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnEmoji1 = new JButton("");
		btnEmoji1.setIcon(new ImageIcon("C:\\Users\\Tuan\\Desktop\\rsz_4pepe.png"));
		btnEmoji1.setBounds(10, 11, 81, 79);
		contentPane.add(btnEmoji1);
		
		JButton btnEmoji2 = new JButton("");
		btnEmoji2.setBounds(101, 11, 81, 79);
		contentPane.add(btnEmoji2);
		
		JButton btnEmoji3 = new JButton("");
		btnEmoji3.setBounds(192, 11, 81, 79);
		contentPane.add(btnEmoji3);
		
		JButton btnEmoji4 = new JButton("");
		btnEmoji4.setBounds(283, 11, 81, 79);
		contentPane.add(btnEmoji4);
		
		JButton btnEmoji5 = new JButton("");
		btnEmoji5.setBounds(374, 11, 81, 79);
		contentPane.add(btnEmoji5);
		
		JButton btnEmoji6 = new JButton("");
		btnEmoji6.setBounds(465, 11, 81, 79);
		contentPane.add(btnEmoji6);
		
		JButton btnEmoji7 = new JButton("");
		btnEmoji7.setBounds(556, 11, 81, 79);
		contentPane.add(btnEmoji7);
		
		JButton btnEmoji8 = new JButton("");
		btnEmoji8.setBounds(647, 11, 81, 79);
		contentPane.add(btnEmoji8);
		
		JButton btnEmoji9 = new JButton("");
		btnEmoji9.setBounds(10, 101, 81, 79);
		contentPane.add(btnEmoji9);
		
		JButton btnEmoji10 = new JButton("");
		btnEmoji10.setBounds(101, 101, 81, 79);
		contentPane.add(btnEmoji10);
		
		JButton btnEmoji11 = new JButton("");
		btnEmoji11.setBounds(192, 101, 81, 79);
		contentPane.add(btnEmoji11);
		
		JButton btnEmoji12 = new JButton("");
		btnEmoji12.setBounds(283, 101, 81, 79);
		contentPane.add(btnEmoji12);
		
		JButton btnEmoji13 = new JButton("");
		btnEmoji13.setBounds(374, 101, 81, 79);
		contentPane.add(btnEmoji13);
		
		JButton btnEmoji14 = new JButton("");
		btnEmoji14.setBounds(465, 101, 81, 79);
		contentPane.add(btnEmoji14);
		
		JButton btnEmoji15 = new JButton("");
		btnEmoji15.setBounds(556, 101, 81, 79);
		contentPane.add(btnEmoji15);
		
		JButton btnEmoji16 = new JButton("");
		btnEmoji16.setBounds(647, 101, 81, 79);
		contentPane.add(btnEmoji16);
		
		btnEmoji1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 1;
			}
		});
		
		btnEmoji2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 2;
			}
		});
		
		btnEmoji3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 3;
			}
		});
		
		btnEmoji4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 4;
			}
		});
		
		btnEmoji5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 5;
			}
		});
		
		btnEmoji6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 6;
			}
		});
		
		btnEmoji7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 7;
			}
		});
		
		btnEmoji8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 8;
			}
		});
		
		btnEmoji9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 9;
			}
		});
		
		btnEmoji10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 10;
			}
		});
		
		btnEmoji11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 11;
			}
		});
		
		btnEmoji12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 12;
			}
		});
		
		btnEmoji13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 13;
			}
		});
		
		btnEmoji14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 14;
			}
		});
		
		btnEmoji15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 15;
			}
		});
		
		btnEmoji16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPos = 16;
			}
		});
		

		


		

		

	}
}
