import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;

import javafx.stage.Stage;
import keeptoo.KGradientPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtUserName2;
	private JTextField txtPassword2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ClientDAO clientDAO = new ClientDAO();
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setkEndColor(new Color(0, 102, 255));
		gradientPanel.setkStartColor(new Color(0, 204, 255));
		gradientPanel.setBounds(0, 0, 431, 123);
		contentPane.add(gradientPanel);
		gradientPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập để truy cập vào TP Chat Client");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tuan\\Desktop\\Icon\\F\\6_00000.png"));
		lblNewLabel.setBounds(26, 0, 395, 123);
		gradientPanel.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 134, 411, 416);
		contentPane.add(tabbedPane);
		
		JPanel pn1 = new JPanel();
		tabbedPane.addTab("Đăng nhập", null, pn1, null);
		pn1.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(118, 25, 244, 32);
		pn1.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lb1 = new JLabel("Username:");
		lb1.setBounds(43, 34, 65, 14);
		pn1.add(lb1);
		
		JLabel lb2 = new JLabel("Password:");
		lb2.setBounds(43, 97, 65, 14);
		pn1.add(lb2);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(118, 88, 244, 32);
		pn1.add(txtPassword);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {

					@Override
					public void run() {

						// TODO Auto-generated method stub
						try {
							if(clientDAO.loginGate(txtUserName.getText(), txtPassword.getText())) {
								ClientDesign frame = new ClientDesign(txtUserName.getText());
								frame.setVisible(true);
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu");
							}
							
							

						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Không kết nối được đến Server");
						}
						
					}
				});
			}
		});
		btnLogin.setBounds(149, 173, 107, 23);
		pn1.add(btnLogin);
		
		JPanel pn2 = new JPanel();
		tabbedPane.addTab("Đăng kí", null, pn2, null);
		pn2.setLayout(null);
		
		txtUserName2 = new JTextField();
		txtUserName2.setColumns(10);
		txtUserName2.setBounds(120, 24, 244, 32);
		pn2.add(txtUserName2);
		
		JLabel lb4_1 = new JLabel("Username:");
		lb4_1.setBounds(45, 33, 65, 14);
		pn2.add(lb4_1);
		
		JLabel lb5 = new JLabel("Password:");
		lb5.setBounds(45, 96, 65, 14);
		pn2.add(lb5);
		
		txtPassword2 = new JTextField();
		txtPassword2.setColumns(10);
		txtPassword2.setBounds(120, 87, 244, 32);
		pn2.add(txtPassword2);
		
		JButton btnSignUp = new JButton("Đăng kí");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(clientDAO.signUpGate(txtUserName2.getText(), txtPassword2.getText())) {
						JOptionPane.showMessageDialog(null, "Đăng kí thành công");
					}
					else {
						JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại , vui lòng chọn tên đăng nhập khác");
					}
				} catch (HeadlessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSignUp.setBounds(159, 162, 89, 23);
		pn2.add(btnSignUp);
	}
}
