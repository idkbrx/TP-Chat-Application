import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import keeptoo.KGradientPanel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.image.*;

public class Server extends JFrame {
	
	private JPanel contentPane;
	public static int clientSize;
	public static ArrayList<ClientIdentifier> clientIdentifier;
	
	static JTextArea textArea = new JTextArea();
	static int clientAccess = 0;
	JLabel pn3Status = new JLabel("Disable");
	static JLabel pn4Status = new JLabel("0");
	static ServerDAO serverDAO = new ServerDAO();
	
	static String iconPath = "C:\\Users\\Tuan\\eclipse-workspace\\TCPDesign2\\Icon\\";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Server.clientIdentifier = new ArrayList<>();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void addFromDB(Socket socket , String user) throws SQLException, IOException {
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		serverDAO.getLog();
	

		for (int i = 0 ; i < serverDAO.getServersLog().size() ; i++) {
			String sender = serverDAO.getServersLog().get(i).getSender();
			String log = serverDAO.getServersLog().get(i).getLog();
			if(sender.equals("Server")) {
				dos.writeUTF("TP_SV_REPONSE");
				dos.writeUTF(log);
			}
			else {
				dos.writeUTF("SV_LOG_MESSAGE");
				dos.writeUTF(sender);
				dos.writeUTF(log);
			}
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		

		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.WHITE);
		pn1.setBounds(0, 0, 1184, 48);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JButton btnConnect = new JButton("Start");
		btnConnect.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnConnect.setBounds(1061, 11, 113, 26);
		pn1.add(btnConnect);
		
		JLabel icon1 = new JLabel("TP Chat Server");
		icon1.setIcon(new ImageIcon(iconPath+"3.png"));
		icon1.setBounds(28, 0, 165, 48);
		pn1.add(icon1);
		
		JButton btnDeleteChatLog = new JButton("Delete Chat Log");
		btnDeleteChatLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if (JOptionPane.showConfirmDialog(null, "Bạn có chắc rằng bạn muốn xóa chatlog?", "Xác nhận?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						try {
							serverDAO.deleteChatLog();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						textArea.setText("");
						JOptionPane.showMessageDialog(null, "Đã xóa chat log");
					}
			}
		});
		btnDeleteChatLog.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnDeleteChatLog.setBounds(186, 11, 130, 26);
		pn1.add(btnDeleteChatLog);
		
		JButton btnWipeDatabase = new JButton("Wipe All Database");
		btnWipeDatabase.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnWipeDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Thao tác này sẽ xóa toàn bộ chatlog cũng như tài khoản của người dùng đã đăng ký, tiếp tục?", "Xác nhận?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					try {
						serverDAO.wipeAllDatabase();
						textArea.setText("");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Đã Wipe Database");
				}
			}
		});
		btnWipeDatabase.setBounds(326, 11, 130, 26);
		pn1.add(btnWipeDatabase);
		
		KGradientPanel pn2 = new KGradientPanel();
		pn2.setkEndColor(new Color(0, 102, 255));
		pn2.setkStartColor(new Color(0, 204, 255));
		pn2.setBounds(0, 49, 1184, 101);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lbpn21 = new JLabel("Dashboard");
		lbpn21.setForeground(Color.WHITE);
		lbpn21.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		lbpn21.setBounds(174, 11, 177, 53);
		pn2.add(lbpn21);
		
		JLabel lbpn22 = new JLabel("Dashboard to help you manage your chat server");
		lbpn22.setForeground(Color.WHITE);
		lbpn22.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lbpn22.setBounds(174, 48, 461, 27);
		pn2.add(lbpn22);
		
		JLabel lbIcon2 = new JLabel("");
		lbIcon2.setIcon(new ImageIcon(iconPath+"5.png"));
		lbIcon2.setBounds(56, -15, 108, 131);
		pn2.add(lbIcon2);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.WHITE);
		pn3.setBounds(10, 161, 573, 134);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lbIcon3 = new JLabel("");
		lbIcon3.setIcon(new ImageIcon(iconPath+"1.png"));
		lbIcon3.setBounds(45, 11, 100, 112);
		pn3.add(lbIcon3);
		
		JLabel lb3Status = new JLabel("Server Status");
		lb3Status.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lb3Status.setBounds(438, 96, 125, 27);
		pn3.add(lb3Status);
		
		
		pn3Status.setFont(new Font("Tahoma", Font.PLAIN, 35));
		pn3Status.setBounds(155, 27, 408, 69);
		pn3.add(pn3Status);
		
		JPanel pn4 = new JPanel();
		pn4.setBackground(Color.WHITE);
		pn4.setBounds(601, 161, 573, 134);
		contentPane.add(pn4);
		pn4.setLayout(null);
		
		JLabel lbIcon4 = new JLabel("");
		lbIcon4.setIcon(new ImageIcon(iconPath+"2.png"));
		lbIcon4.setBounds(61, 11, 100, 112);
		pn4.add(lbIcon4);
		
		JLabel lb4Status = new JLabel("Client Connected");
		lb4Status.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lb4Status.setBounds(408, 96, 155, 27);
		pn4.add(lb4Status);
		
		
		pn4Status.setFont(new Font("Tahoma", Font.PLAIN, 35));
		pn4Status.setBounds(184, 28, 379, 69);
		pn4.add(pn4Status);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 306, 1164, 244);
		contentPane.add(scrollPane);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setForeground(Color.WHITE);
		
		
		textArea.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(textArea);
		
		
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					Thread t1 = new Thread(new Runnable() {
					    @Override
					    public void run() {
					        try {
					    		ServerSocket server = new ServerSocket(1);
					    		if (true) {
					    			pn3Status.setText("Enable");
					    			JOptionPane.showMessageDialog(null, "Đã kết nối thành công");
					    		}
					    		while(true) {
					    			Socket socket = server.accept();
					    			
					    			DataInputStream in = new DataInputStream(socket.getInputStream());
					    			String userName = in.readUTF();
					    			
		
					    			textArea.append("Server: " +userName+ " vào phòng"+"\n");

					    
					    			
				
					    			
					    			ClientIdentifier cID = new ClientIdentifier(userName,socket);
					    			Server.clientIdentifier.add(cID);
					    		
					    			clientAccess = Server.clientIdentifier.size();
					    			pn4Status.setText(String.valueOf(clientAccess));
					    			
					    			try {
										addFromDB(socket,userName);
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					    			ServerCommunication serverCommunication = new ServerCommunication(socket);
					    			
					    			serverCommunication.ServerReponse(userName +" vào phòng"); 

					    			try {
										serverDAO.saveLog("Server",userName+ " vào phòng");
										
									} catch (SQLException e) {
										e.printStackTrace();
									}
					    			
					    			serverCommunication.UpdateActiveUsers();
					    			
					    			

					    			ReadServer read = new ReadServer(socket,textArea);
					    			read.start();
					    		}
							} catch (IOException e) {
								JOptionPane.showMessageDialog(null, "Server đã đang hoạt động");
							}
					    }
					});  
					t1.start();
				}
			
		});	
	}
}

class ServerCommunication extends Thread{
	Socket server;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	public ServerCommunication(Socket server) throws IOException {
		this.server = server;
		dis = new DataInputStream(server.getInputStream());
		dos = new DataOutputStream(server.getOutputStream());	
	}
	
	
	public void ServerReponse(String message) throws IOException {
		for (int i = 0 ; i < Server.clientIdentifier.size() ; i++) {	
			Socket socket = Server.clientIdentifier.get(i).getSocket();
			DataOutputStream dosTemp = new DataOutputStream(socket.getOutputStream());
			dosTemp.writeUTF("TP_SV_REPONSE");
			dosTemp.writeUTF(message);
		}
	}
	
	public void UpdateActiveUsers() throws IOException {

		for (int i = 0 ; i < Server.clientIdentifier.size() ; i++) {	
			Socket socket = Server.clientIdentifier.get(i).getSocket();
			DataOutputStream dosTemp = new DataOutputStream(socket.getOutputStream());
			dosTemp.writeUTF("TP_UPDATE_ACTIVE_USERS");
			for (int j = 0 ; j < Server.clientIdentifier.size() ; j++) {
				dosTemp.writeUTF(Server.clientIdentifier.get(j).getUserName());
			}
			dosTemp.writeUTF("TP_UPDATE_ACTIVE_USERS_EXITED");
		}
	}
	
	public void SendMessage(String message) throws IOException, SQLException {

		for(int i = 0 ; i < Server.clientIdentifier.size() ; i++) {
			Socket item = Server.clientIdentifier.get(i).getSocket();
			if (item.getPort() != server.getPort()) {
				DataOutputStream dosTemp = new DataOutputStream(item.getOutputStream());
				dosTemp.writeUTF("SV_FORWARD_TEXT");
				dosTemp.writeUTF(message);	  
			}
		}
		
		String sender;
		String messOnly;
	    int index = message.lastIndexOf(':');
	    sender = message.substring(0, index);
	    messOnly = message.substring(index+2,message.length());
	
	    Server.textArea.append(message +"\n");	
		Server.serverDAO.saveLog(sender, messOnly);
		
	}
	
	public void SendEmoji(String sender , String emoji) throws IOException {
		for (int i = 0 ; i < Server.clientIdentifier.size() ; i++) {
			Socket item = Server.clientIdentifier.get(i).getSocket();
			if(item.getPort() != server.getPort()) {
				DataOutputStream dosTemp = new DataOutputStream(item.getOutputStream());
				dosTemp.writeUTF("TP_FORWARD_EMOJI");
				dosTemp.writeUTF(sender);
				dosTemp.writeUTF(emoji);
			}
		}
	}
	
	
	public void SendImage(String sender , int length , byte[] message) throws IOException {
        for (int i = 0 ; i < Server.clientIdentifier.size() ; i++) {
        	Socket item = Server.clientIdentifier.get(i).getSocket();
        	if(item.getPort() != server.getPort()) {
				DataOutputStream dosTemp = new DataOutputStream(item.getOutputStream());
		        dosTemp.writeUTF("TP_IMAGE_TRANSFER");
		        dosTemp.writeUTF(sender);
		        dosTemp.writeInt(length); 
		        dosTemp.write(message); 
        	}
        }
	}
	
	public void SendFileRequest(String sender , String receiver ,String fileName) throws IOException {
		for (int i = 0 ; i < Server.clientIdentifier.size() ; i++) {
			if(receiver.equals(Server.clientIdentifier.get(i).getUserName())) {
				Socket socket = Server.clientIdentifier.get(i).getSocket();
				DataOutputStream dosTemp = new DataOutputStream(socket.getOutputStream());
				dosTemp.writeUTF("SV_FORWARD_REQUEST");
				dosTemp.writeUTF(sender);
				dosTemp.writeUTF(receiver);	
				dosTemp.writeUTF(fileName);
				break;
				
			}
		}
	}
	
	public void SendFileRequestFeedback(String sender , String receiver, String feedback) throws IOException {
		for (int i = 0 ; i < Server.clientIdentifier.size() ; i++) {
			if (sender.equals(Server.clientIdentifier.get(i).getUserName())) {
				Socket socket = Server.clientIdentifier.get(i).getSocket();
				DataOutputStream dosTemp = new DataOutputStream(socket.getOutputStream());
				dosTemp.writeUTF("SV_FORWARD_REQUEST_FEEDBACK");
				dosTemp.writeUTF(sender);
				dosTemp.writeUTF(receiver);
				dosTemp.writeUTF(feedback);
				break;
			}
		}
	}
	
	public void SendFile(String sender , String receiver , String ext , String fileName , int length , byte[] file) throws IOException, SQLException {
        for (int i = 0 ; i < Server.clientIdentifier.size() ; i++) {
        	if (receiver.equals(Server.clientIdentifier.get(i).getUserName())) {
        		Socket socket = Server.clientIdentifier.get(i).getSocket();
        		DataOutputStream dosTemp = new DataOutputStream(socket.getOutputStream());
        		dosTemp.writeUTF("SV_FORWARD_FILE");
        		dosTemp.writeUTF(ext);
        		dosTemp.writeUTF(fileName);
        		dosTemp.writeInt(length);
        		dosTemp.write(file);
        		
        		
        		Server.textArea.append("Server: " +receiver+ " Đã nhận file " +fileName+ext + " từ " + sender + "\n");	
        		Server.serverDAO.saveLog("Server", receiver+ " Đã nhận file " +fileName+ext + " từ " + sender);
        		ServerReponse(receiver+ " Đã nhận file " + fileName+ext + " từ "+ sender + "\n");
        		break;
        	}
        }
	}
	
	public void CancelSendFile(String sender , String receiver , String fileName) throws IOException, SQLException {
		ServerReponse(receiver+ " Đã từ chối nhận file " + fileName + " từ "+ sender + "\n");
		Server.serverDAO.saveLog("Server", receiver+ " Đã từ chối nhận file " + fileName + " từ "+ sender);
		
		for (int i = 0 ; i < Server.clientIdentifier.size() ; i++) {
			if (sender.equals(Server.clientIdentifier.get(i).getUserName())) {
				Socket socket = Server.clientIdentifier.get(i).getSocket();
				DataOutputStream dosTemp = new DataOutputStream(socket.getOutputStream());
				dosTemp.writeUTF("SV_CANCEL_SENDING_FILE");
				dosTemp.writeUTF(receiver);
				Server.textArea.append("Server: " +receiver+ " Đã từ chối nhận file từ " + sender + "\n");
				break;
			}
		}
	}
	
	public void ClientExited(String userName) throws IOException {
		for (int i = 0 ; i < Server.clientIdentifier.size() ; i++) {
			if (userName.equals(Server.clientIdentifier.get(i).getUserName())) {
				Server.clientIdentifier.remove(i);
				Server.clientAccess = Server.clientIdentifier.size();
				Server.pn4Status.setText(String.valueOf(Server.clientAccess));
				ServerReponse(userName+ " rời phòng");

				Server.textArea.append("Server: " +userName+ " rời phòng" + "\n");
    			try {
					Server.serverDAO.saveLog("Server",userName+ " rời phòng");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				UpdateActiveUsers();
    			break;
			}
		}
	}
}



class ReadServer extends Thread{
	private Socket server;
	private JTextArea txt;

	
	public ReadServer(Socket server,JTextArea txt) {
		this.server = server; 
		this.txt = txt;
	}
	
	public void run() {
		DataInputStream dis = null;
		ServerCommunication serverCommunication;

		try {
			serverCommunication = new ServerCommunication(server);
			dis = new DataInputStream(server.getInputStream());
			
			while(true) {
				String sms = dis.readUTF();
				
				
				if (sms.equals("TP_SENDING_TEXT")) {
					sms = dis.readUTF();
					serverCommunication.SendMessage(sms);
				}
				
				if (sms.equals("TP_IMAGE_TRANSFER")) {
					String sender = dis.readUTF();
			        int length = dis.readInt();
			        if(length>0) {
			        	byte[] message = new byte[length];
			            dis.readFully(message, 0, message.length);
				        serverCommunication.SendImage(sender,length,message);
			        }
				}
				
				if (sms.equals("TP_SENDING_EMOJI")) {
					String sender = dis.readUTF();
					String emoji = dis.readUTF();
					serverCommunication.SendEmoji(sender, emoji);
				}
				
				if (sms.equals("TP_SENDING_REQUEST")) {
					String sender = dis.readUTF();
					String receiver = dis.readUTF();
					String fileName = dis.readUTF();
					serverCommunication.SendFileRequest(sender, receiver, fileName);
				}
				
				if(sms.equals("TP_SENDING_REQUEST_FEEDBACK")) {
					String sender = dis.readUTF();
					String receiver = dis.readUTF();
					String feedback = dis.readUTF();
		
					serverCommunication.SendFileRequestFeedback(sender, receiver, feedback);
				}
				
				if(sms.equals("TP_SENDING_FILE")) {
					String sender = dis.readUTF();
					String receiver = dis.readUTF();
					String ext = dis.readUTF();
					String fileName = dis.readUTF();
			        int length = dis.readInt();  
			        if(length>0) {
			        	byte[] message = new byte[length];
			            dis.readFully(message, 0, message.length); 
			            serverCommunication.SendFile(sender, receiver, ext, fileName, length, message);
			        }
				}
				
				if (sms.equals("TP_CANCEL_SENDING_FILE")) {
					String sender = dis.readUTF();
					String receiver = dis.readUTF();
					String fileName = dis.readUTF();
					serverCommunication.CancelSendFile(sender, receiver , fileName);
				}
				
				if (sms.equals("TP_CLIENT_EXIT")) {
					String userName = dis.readUTF();
					
					serverCommunication.ClientExited(userName);
				}
			}
			
		} catch (Exception e){
			try {
				dis.close();
				server.close();
			} catch (IOException e1) {
				System.out.println("Ngat ket noi");
			}	
		}	
	}
}

