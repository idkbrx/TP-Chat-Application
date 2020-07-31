import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.management.modelmbean.ModelMBean;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import keeptoo.KGradientPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTable;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class ClientDesign extends JFrame {
	private InetAddress host;
	private int port;
	private JPanel contentPane;
	
	static Socket client;
	static File file;
	static JTextField chatArea;
	static JFXPanel jfxPanel = new JFXPanel();
	public String name;
	JLabel lbpn22 = new JLabel("User");
	JButton btnSendTxt = new JButton("Gửi tin nhắn");
	static JTable table;
	static DefaultTableModel tableModel = new DefaultTableModel();
	static String tableChoice;
	static JFileChooser chooser = new JFileChooser();
	static String filePath;

	
	static String iconPath = "C:\\Users\\Tuan\\eclipse-workspace\\TCPDesign2\\Icon\\";
	
	public void defindBoxChat() throws IOException {
		String css = "<!DOCTYPE html>\r\n" + 
				"<meta charset=\"utf-8\">" +
				"<html>\r\n" + 
				"<head>\r\n" + 
				"	<style type=\"text/css\">\r\n" + 
				"		.sender{\r\n" + 
				"			background-color: #0099FF;\r\n" + 
				"			float: right;\r\n" + 
				"			clear:both;\r\n" + 
				"			margin-bottom: -10px;\r\n" + 
				"			padding: 10px;\r\n" + 
				"			color: white ;\r\n" + 
				"			border-radius: 50px;\r\n" + 
				"			font-family: Helvetica; \r\n" + 
				"		}\r\n" + 
				"		.receiver{\r\n" + 
				"			background-color: #F1F0F0;\r\n" + 
				"			float: left;  \r\n" + 
				"			clear:both;\r\n" + 
				"			margin-bottom: -10px;\r\n" + 
				"			padding: 10px;\r\n" + 
				"			border-radius: 50px;\r\n" + 
				"			font-family: Helvetica;\r\n" + 
				"		}\r\n" +
				"		.imgsender{\r\n" + 
				"			clear:both;\r\n" + 
				"			padding: 10px;\r\n" + 
				"			max-width:20%;\r\n" + 
				"			height:auto;\r\n" + 
				"			border-radius: 50px;\r\n" + 
				"			float: right;\r\n" + 
				"		}\r\n" + 
				"		.emojisender{\r\n" + 
				"			clear:both;\r\n" + 
				"			padding: 10px;\r\n" + 
				"			max-width:20%;\r\n" + 
				"			height:auto;\r\n" + 
				"			float: right;\r\n" + 
				"		}\r\n" + 
				"		.imgreceiver{\r\n" + 
				"			clear:both;\r\n" + 
				"			padding: 10px;\r\n" + 
				"			max-width:20%;\r\n" + 
				"			height:auto;\r\n" + 
				"			border-radius: 50px;\r\n" + 
				"			float: left;\r\n" + 
				"           margin-top : -30px;"+
				"        }       \r\n" + 
				"        .imgreceiverheader{\r\n" + 
				"		     color : #90949C;" +
				"            clear: both;\r\n" + 
				"            margin-left: 40px;\r\n" + 
				"            font-family: Helvetica;\r\n" + 
				"            float :left;\r\n" + 
				"        }	" +
				"		.server{\r\n" + 
				"			background-color: #006A4E;\r\n" +
				"			color : white;\r\n" +
				"			float: left;  \r\n" + 
				"			clear:both;\r\n" + 
				"			margin-bottom: -10px;\r\n" + 
				"			padding: 10px;\r\n" + 
				"			border-radius: 50px;\r\n" + 
				"			font-family: Helvetica;\r\n" + 
				"		}" +
				"		.emojireceiver{\r\n" + 
				"			clear:both;\r\n" + 
				"			padding: 10px;\r\n" + 
				"			max-width:20%;\r\n" + 
				"			height:auto;\r\n" + 
				"			float: left;\r\n" + 
				"           margin-top : -30px;"+
				"        }       \r\n" + 
				"	</style>\r\n" + 
				"</head>\r\n" + 
				"<body> \n";
		try {
		    Files.write(Paths.get(file.getAbsolutePath()), css.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		    
		}
	}

	public static void WriteMessageSended(String message) throws IOException {
		String html = "<p class=\"sender\">"+message+"</p> \n";
		try {
		    Files.write(Paths.get(file.getAbsolutePath()), html.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		   
		}
	}
	
	public static void WriteMessageReceived(String message) throws IOException {
		String html = "<p class=\"receiver\">"+message+"</p> \n";
		try {
		    Files.write(Paths.get(file.getAbsolutePath()), html.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		   
		}
	}
	
	public static void WriteServerMessage(String message) throws IOException {
		String html = "<p class=\"server\">"+message+"</p> \n";
		try {
		    Files.write(Paths.get(file.getAbsolutePath()), html.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		   
		}
	}
	
	public static void WriteImageSended(String url) {
		String html = "<img class = \"imgsender\" src=\"file:///"+url+"\">";
		try {
		    Files.write(Paths.get(file.getAbsolutePath()), html.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		   
		}
	}
	
	public static void WriteImageReceived(String url , String userName) {
		String html1 = "<h5 class=\"imgreceiverheader\">"+userName+"</h5> \n";
		String html = "<img class = \"imgreceiver\" src=\"file:///"+url+"\">";
		String htmlfinal = html1+html;
		try {
			Files.write(Paths.get(file.getAbsolutePath()), htmlfinal.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			
		}
	}
	
	
	public static void WriteEmojiReceived(int emojiPos,String userName) {
		String url = "C:\\Users\\Tuan\\eclipse-workspace\\TCPDesign2\\Emoji\\";
		String html1 = "<h5 class=\"imgreceiverheader\">"+userName+"</h5> \n";
		String html = "<img class = \"emojireceiver\" src=\"file:///"+url+"rsz_"+ emojiPos +"pepe.png"+"\">";
		String htmlfinal = html1+html;
		try {
			Files.write(Paths.get(file.getAbsolutePath()), htmlfinal.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			
		}
		refreshWebView();
		
	}
	
	
	public static void WriteEmojiSended(String url) {
		String html = "<img class = \"emojisender\" src=\"file:///"+url+"\">";
		try {
		    Files.write(Paths.get(file.getAbsolutePath()), html.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		   
		}
		refreshWebView();
	}
	


	public ClientDesign(InetAddress host, int port, String name) {
		this.host = host;
		this.port = port;
		this.name = name;
	}
	
	private void execute() throws IOException {
		client = new Socket(host,port);
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF(name);
		
		ReadClient read = new ReadClient(client,name);
		read.start();
	}

	static void refreshWebView() {
		Platform.runLater(() -> {
			WebView webView = new WebView();
			jfxPanel.setScene(new Scene(webView));
               try {
            	   
                   URL url = file.toURI().toURL();
                   webView.getEngine().load(url.toString());        
                   webView.getEngine().getLoadWorker().stateProperty().addListener(
                           new ChangeListener<State>() {
                             @Override public void changed(ObservableValue ov, State oldState, State newState) {
                                 if (newState == Worker.State.SUCCEEDED) {
                                	 webView.getEngine().executeScript("window.scrollTo(0, document.body.scrollHeight);");
                                 }  
                              }
                           });   
               } catch (MalformedURLException e) {
                   e.printStackTrace();
               } 
		});	
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @wbp.parser.constructor
	 */
	

	public ClientDesign(String user) throws IOException {
		
		
		
		
	    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
				 try {
					DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
					dos.writeUTF("TP_CLIENT_EXIT");
					dos.writeUTF(user);
					dos.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Không kết nối được đến server!!");
				}
	        }
	    }, "Shutdown-thread"));
		
        tableModel.addColumn("Active Users");
		table = new JTable(tableModel);
		
		file = File.createTempFile("temp", ".html");
		file.deleteOnExit();
		defindBoxChat();
		refreshWebView();

		lbpn22.setText(user);
		
		ClientDesign client = new ClientDesign(InetAddress.getLocalHost(),1,user);
		client.execute();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setLayout(null);
		pn1.setBackground(Color.WHITE);
		pn1.setBounds(0, 0, 1184, 48);
		contentPane.add(pn1);
		
		JLabel lbIcon1 = new JLabel("TP Chat Client");
		lbIcon1.setIcon(new ImageIcon(iconPath+"3.png"));
		lbIcon1.setBounds(28, 0, 165, 48);
		pn1.add(lbIcon1);
		
		JButton btnNewButton = new JButton("Gửi ảnh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendImage sendImage = new SendImage(user);
				sendImage.start();
			}
		});
		btnNewButton.setBounds(1069, 13, 89, 23);
		pn1.add(btnNewButton);
		
		JButton btnSendFile = new JButton("Gửi file");
		btnSendFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filePath = null;
				try {
					if (table.getModel().getValueAt(table.getSelectedRow(), 0).toString().equals(user)) {
						JOptionPane.showMessageDialog(null, "Bạn không thể gửi file cho chính mình");
					} else {
						 try {
						        int returnVal = chooser.showOpenDialog(null);
						        if(returnVal == JFileChooser.APPROVE_OPTION) {
						        	filePath = chooser.getSelectedFile().getName();
									DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
									
									dos.writeUTF("TP_SENDING_REQUEST");
									dos.writeUTF(user);
									dos.writeUTF(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
									dos.writeUTF(chooser.getSelectedFile().getName());
						        }	
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
					}
				} catch(ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "Bạn phải chọn người gửi trước");
				}
			}
			
		});
		btnSendFile.setBounds(970, 13, 89, 23);
		pn1.add(btnSendFile);
		
		JButton btnAddEmoji = new JButton("Add Emoji");
		btnAddEmoji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String url = "C:\\Users\\Tuan\\eclipse-workspace\\TCPDesign2\\Emoji\\";
				JFrame emojiFrame = new JFrame();
				emojiFrame.setVisible(true);	
				emojiFrame.getContentPane().setLayout(null);
				
				emojiFrame.setSize(new Dimension(765,330));
				
				JButton btnEmoji1 = new JButton("");
				btnEmoji1.setIcon(new ImageIcon(url+"rsz_1pepe.png"));
				btnEmoji1.setBounds(10, 11, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji1);
				
				JButton btnEmoji2 = new JButton("");
				btnEmoji2.setIcon(new ImageIcon(url+"rsz_2pepe.png"));
				btnEmoji2.setBounds(101, 11, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji2);
				
				JButton btnEmoji3 = new JButton("");
				btnEmoji3.setIcon(new ImageIcon(url+"rsz_3pepe.png"));
				btnEmoji3.setBounds(192, 11, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji3);
				
				JButton btnEmoji4 = new JButton("");
				btnEmoji4.setIcon(new ImageIcon(url+"rsz_4pepe.png"));
				btnEmoji4.setBounds(283, 11, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji4);
				
				JButton btnEmoji5 = new JButton("");
				btnEmoji5.setIcon(new ImageIcon(url+"rsz_5pepe.png"));
				btnEmoji5.setBounds(374, 11, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji5);
				
				JButton btnEmoji6 = new JButton("");
				btnEmoji6.setIcon(new ImageIcon(url+"rsz_6pepe.png"));
				btnEmoji6.setBounds(465, 11, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji6);
				
				JButton btnEmoji7 = new JButton("");
				btnEmoji7.setIcon(new ImageIcon(url+"rsz_7pepe.png"));
				btnEmoji7.setBounds(556, 11, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji7);
				
				JButton btnEmoji8 = new JButton("");
				btnEmoji8.setIcon(new ImageIcon(url+"rsz_8pepe.png"));
				btnEmoji8.setBounds(647, 11, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji8);
				
				JButton btnEmoji9 = new JButton("");
				btnEmoji9.setIcon(new ImageIcon(url+"rsz_9pepe.png"));
				btnEmoji9.setBounds(10, 101, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji9);
				
				JButton btnEmoji10 = new JButton("");
				btnEmoji10.setIcon(new ImageIcon(url+"rsz_10pepe.png"));
				btnEmoji10.setBounds(101, 101, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji10);
				
				JButton btnEmoji11 = new JButton("");
				btnEmoji11.setIcon(new ImageIcon(url+"rsz_11pepe.png"));
				btnEmoji11.setBounds(192, 101, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji11);
				
				JButton btnEmoji12 = new JButton("");
				btnEmoji12.setIcon(new ImageIcon(url+"rsz_12pepe.png"));
				btnEmoji12.setBounds(283, 101, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji12);
				
				JButton btnEmoji13 = new JButton("");
				btnEmoji13.setIcon(new ImageIcon(url+"rsz_13pepe.png"));
				btnEmoji13.setBounds(374, 101, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji13);
				
				JButton btnEmoji14 = new JButton("");
				btnEmoji14.setIcon(new ImageIcon(url+"rsz_14pepe.png"));
				btnEmoji14.setBounds(465, 101, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji14);
				
				JButton btnEmoji15 = new JButton("");
				btnEmoji15.setIcon(new ImageIcon(url+"rsz_15pepe.png"));
				btnEmoji15.setBounds(556, 101, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji15);
				
				JButton btnEmoji16 = new JButton("");
				btnEmoji16.setIcon(new ImageIcon(url+"rsz_16pepe.png"));
				btnEmoji16.setBounds(647, 101, 81, 79);
				emojiFrame.getContentPane().add(btnEmoji16);
				
				
				btnEmoji1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_1");
							WriteEmojiSended(url+"rsz_1pepe.png");
							emojiFrame.dispose();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_2");
							WriteEmojiSended(url+"rsz_2pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_3");
							WriteEmojiSended(url+"rsz_3pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_4");
							WriteEmojiSended(url+"rsz_4pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_5");
							WriteEmojiSended(url+"rsz_5pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_6");
							WriteEmojiSended(url+"rsz_6pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_7");
							WriteEmojiSended(url+"rsz_7pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_8");
							WriteEmojiSended(url+"rsz_8pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_9");
							WriteEmojiSended(url+"rsz_9pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_10");
							
							WriteEmojiSended(url+"rsz_10pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_11");
							WriteEmojiSended(url+"rsz_11pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_12");
							WriteEmojiSended(url+"rsz_12pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji13.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_13");
							WriteEmojiSended(url+"rsz_13pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji14.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_14");
							WriteEmojiSended(url+"rsz_14pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji15.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_15");
							WriteEmojiSended(url+"rsz_15pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				btnEmoji16.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DataOutputStream dos = new DataOutputStream(ClientDesign.client.getOutputStream());
							dos.writeUTF("TP_SENDING_EMOJI");
							dos.writeUTF(user);
							dos.writeUTF("EMOJI_16");
							WriteEmojiSended(url+"rsz_16pepe.png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				
				
			}
		});
		btnAddEmoji.setBounds(195, 13, 122, 23);
		pn1.add(btnAddEmoji);
		

		KGradientPanel pn2 = new KGradientPanel();
		pn2.setLayout(null);
		pn2.kStartColor = new Color(0, 204, 255);
		pn2.setkStartColor(new Color(0, 204, 255));
		pn2.kEndColor = new Color(0, 102, 255);
		pn2.setkEndColor(new Color(0, 102, 255));
		pn2.setBounds(0, 47, 1184, 101);
		contentPane.add(pn2);
		
		JLabel lbpn21 = new JLabel("Welcome");
		lbpn21.setForeground(Color.WHITE);
		lbpn21.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		lbpn21.setBounds(174, 11, 177, 53);
		pn2.add(lbpn21);
		
		
		lbpn22.setForeground(Color.WHITE);
		lbpn22.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lbpn22.setBounds(174, 48, 461, 27);
		pn2.add(lbpn22);
		
		JLabel lbIcon2 = new JLabel("");
		lbIcon2.setIcon(new ImageIcon(iconPath+"4.png"));
		lbIcon2.setBounds(56, -15, 108, 131);
		pn2.add(lbIcon2);
		
		chatArea = new JTextField();
		chatArea.setBounds(10, 504, 953, 46);
		contentPane.add(chatArea);
		chatArea.setColumns(10);
		

		btnSendTxt.setBounds(973, 504, 201, 46);
		contentPane.add(btnSendTxt);
		
		btnSendTxt.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SendMessage sendMessage = new SendMessage(user, chatArea.getText());
				sendMessage.start();
				chatArea.setText("");
				refreshWebView();
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(973, 159, 201, 337);
		contentPane.add(scrollPane_1);

		scrollPane_1.setViewportView(table);
		
		jfxPanel.setBounds(10, 159, 953, 334);
		contentPane.add(jfxPanel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 159, 953, 160);

	}
}

class SendMessage extends Thread{
	private String user;
	private String message;

	public SendMessage(String user , String message) {
		this.user = user;
		this.message = message;
	}
	public void run() {
		DataOutputStream dos = null; 
		try {
			dos = new DataOutputStream(ClientDesign.client.getOutputStream());
			dos.writeUTF("TP_SENDING_TEXT");
			dos.writeUTF(user + ": " + message);
			ClientDesign.WriteMessageSended("Bạn" + ": " + message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class SendFile extends Thread{
	private String getFileExtension(String fileName) {
	    String name = fileName;
	    int lastIndexOf = name.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return name.substring(lastIndexOf);
	}
	
	private String getBaseName(String fileName) {
	    int index = fileName.lastIndexOf('.');
	    if (index == -1) {
	        return fileName;
	    } else {
	        return fileName.substring(0, index);
	    }
	}
	private String sender;
	private String receiver;

	public SendFile (String sender, String receiver) {
		this.sender = sender;
		this.receiver = receiver;
	}
	
	
	public void run() {
		DataOutputStream dOut;
    		try {
    	        byte[] array = Files.readAllBytes(Paths.get(ClientDesign.chooser.getSelectedFile().getAbsolutePath()));
    	        dOut = new DataOutputStream(ClientDesign.client.getOutputStream());
    	        dOut.writeUTF("TP_SENDING_FILE");
    	        dOut.writeUTF(sender);
    	        dOut.writeUTF(receiver);
    	        dOut.writeUTF(getFileExtension(ClientDesign.filePath));
    	        dOut.writeUTF(getBaseName(ClientDesign.filePath)); 
    
    			dOut.writeInt(array.length); 
    			dOut.write(array);  
    		} catch (Exception e) {
    			e.printStackTrace();
    		}

	}
}


class SendImage extends Thread{
	private String user;
	//private File file;
	public SendImage(String user) {
		this.user = user;
	}
	
	private String getFileExtension(String fileName) {
	    String name = fileName;
	    int lastIndexOf = name.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return name.substring(lastIndexOf);
	}
	
	public void run() {

		DataOutputStream dOut;
		try {
			
			int choosed = 0;
			while (choosed != 1) {
		        JFileChooser chooser = new JFileChooser();
		        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
		        int returnVal = chooser.showOpenDialog(null);
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		        	String fileName = getFileExtension(chooser.getSelectedFile().getName());
		        	System.out.println(fileName);
		        	if (fileName.equals(".png") || fileName.equals(".jpg") || fileName.equals(".gif")) {
				        byte[] array = Files.readAllBytes(Paths.get(chooser.getSelectedFile().getAbsolutePath()));
				        dOut = new DataOutputStream(ClientDesign.client.getOutputStream());
				        dOut.writeUTF("TP_IMAGE_TRANSFER");
				        dOut.writeUTF(user);
						dOut.writeInt(array.length); 
						dOut.write(array);  
				        ClientDesign.WriteImageSended(chooser.getSelectedFile().getAbsolutePath()); 
				        ClientDesign.refreshWebView();
				        choosed = 1;
		        	}
		        	else {
		        		JOptionPane.showMessageDialog(null, "Không phải file ảnh!");
		        	}
		        }
		        else {
		        	JOptionPane.showMessageDialog(null, "Bạn chưa chọn file");
		        	choosed = 1;
		        }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

class ReadClient extends Thread{
	private Socket client;
	private String user;
	public ReadClient(Socket client , String user) {
		this.client = client;
		this.user = user;
	}
	

	
	
	public void run() {
		DataInputStream dis = null;
		DataOutputStream dos = null;
		File fileTemp;
		int command;

		
		try {
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			
			
			while(true) {
				String sms = dis.readUTF();
				command = 0;
				
	
				
				if (sms.equals("SV_LOG_MESSAGE")) {
					String sender = dis.readUTF();
					String log = dis.readUTF();
					if (sender.equals(user)) {
						ClientDesign.WriteMessageSended(log);
						ClientDesign.refreshWebView();
					}
					else {
						ClientDesign.WriteMessageReceived(sender+": "+log);
						ClientDesign.refreshWebView();
					}
				}
				
				
				if (sms.equals("TP_SV_REPONSE")){
					ClientDesign.WriteServerMessage(dis.readUTF());
					ClientDesign.refreshWebView();
				}
				

				if (sms.equals("SV_FORWARD_TEXT")) {
					ClientDesign.WriteMessageReceived(dis.readUTF());
					ClientDesign.refreshWebView();	
				}
				
				
				if (sms.equals("SV_FORWARD_REQUEST")) {
					String sender = dis.readUTF();
					String receiver = dis.readUTF();
					String fileName = dis.readUTF();
					dos.writeUTF("TP_SENDING_REQUEST_FEEDBACK");
					dos.writeUTF(sender);
					dos.writeUTF(receiver);
					
					if (JOptionPane.showConfirmDialog(null, "Bạn có muốn nhận file " + fileName + " được gửi bởi "+sender+" ?", "Nhận file?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						dos.writeUTF("YES");
					}
					else {
						dos.writeUTF("NO");
					}
	
				}
				
				if(sms.equals("TP_FORWARD_EMOJI")) {
					String sender = dis.readUTF();
					String emoji = dis.readUTF();
					if (emoji.equals("EMOJI_1")) {
						ClientDesign.WriteEmojiReceived(1,sender);
					}
					if (emoji.equals("EMOJI_2")) {
						ClientDesign.WriteEmojiReceived(2,sender);
					}
					if (emoji.equals("EMOJI_3")) {
						ClientDesign.WriteEmojiReceived(3,sender);
					}
					if (emoji.equals("EMOJI_4")) {
						ClientDesign.WriteEmojiReceived(4,sender);
					}
					if (emoji.equals("EMOJI_5")) {
						ClientDesign.WriteEmojiReceived(5,sender);
					}
					if (emoji.equals("EMOJI_6")) {
						ClientDesign.WriteEmojiReceived(6,sender);
					}
					if (emoji.equals("EMOJI_7")) {
						ClientDesign.WriteEmojiReceived(7,sender);
					}
					if (emoji.equals("EMOJI_8")) {
						ClientDesign.WriteEmojiReceived(8,sender);
					}
					if (emoji.equals("EMOJI_9")) {
						ClientDesign.WriteEmojiReceived(9,sender);
					}
					if (emoji.equals("EMOJI_10")) {
						ClientDesign.WriteEmojiReceived(10,sender);
					}
					if (emoji.equals("EMOJI_11")) {
						ClientDesign.WriteEmojiReceived(11,sender);
					}
					if (emoji.equals("EMOJI_12")) {
						ClientDesign.WriteEmojiReceived(12,sender);
					}
					if (emoji.equals("EMOJI_13")) {
						ClientDesign.WriteEmojiReceived(13,sender);
					}
					if (emoji.equals("EMOJI_14")) {
						ClientDesign.WriteEmojiReceived(14,sender);
					}
					if (emoji.equals("EMOJI_15")) {
						ClientDesign.WriteEmojiReceived(15,sender);
					}
					if (emoji.equals("EMOJI_16")) {
						ClientDesign.WriteEmojiReceived(16,sender);
					}
					
					
				}
				
				if(sms.equals("SV_FORWARD_REQUEST_FEEDBACK")) {
					command = 1;
					String sender = dis.readUTF();
					String receiver = dis.readUTF();
					
					String feedback = dis.readUTF();
					if (feedback.equals("YES")) {
						SendFile sendFile = new SendFile(sender, receiver);
						sendFile.start();
					}
					if (feedback.equals("NO")) {
						dos.writeUTF("TP_CANCEL_SENDING_FILE");
						dos.writeUTF(sender);
						dos.writeUTF(receiver);
						dos.writeUTF(ClientDesign.filePath);
						
					}
				}
				
				if(sms.equals("SV_FORWARD_FILE")) {
					command = 1;
					String ext = dis.readUTF();
					String fileName = dis.readUTF();
			        int length = dis.readInt();  
			        
			        System.out.println("SV_FORWARD_FILE");
			        
			        int choosing = 0;
			        
			        while (choosing != 1) {
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.setDialogTitle("Specify a file to save");
						fileChooser.setSelectedFile(new File(fileName+ext));
						int userSelection = fileChooser.showSaveDialog(null);
						if (userSelection == JFileChooser.APPROVE_OPTION) {
							File myObj = fileChooser.getSelectedFile();
					        if(length>0) {
					        	byte[] message = new byte[length];
					            dis.readFully(message, 0, message.length); 
						        try (FileOutputStream fos = new FileOutputStream(myObj.getAbsolutePath())) {
						        	   fos.write(message);
						        }
					        }
					        choosing = 1;
						}
			        }	
				}
				
				if (sms.equals("TP_UPDATE_ACTIVE_USERS")) {
					command = 1;
					ClientDesign.tableModel.setRowCount(0);
					String sms2 = dis.readUTF();
					while(!sms2.equals("TP_UPDATE_ACTIVE_USERS_EXITED")) {
						ClientDesign.tableModel.insertRow(0, new Object[] {sms2});
						sms2 = dis.readUTF();
					}	
				}

				if (sms.equals("TP_IMAGE_TRANSFER")) {
					command = 1;
					fileTemp = File.createTempFile("temp", null);
					fileTemp.deleteOnExit();
					
					String userSent = dis.readUTF();
					int length = dis.readInt();
			        if(length>0) {
			        	byte[] message = new byte[length];
			            dis.readFully(message, 0, message.length);
				        try (FileOutputStream fos = new FileOutputStream(fileTemp.getAbsolutePath())) {
				        	fos.write(message);
				        }
			        }
					
			        ClientDesign.WriteImageReceived(fileTemp.getAbsolutePath(),userSent);
			        ClientDesign.refreshWebView();	
				}
			}
		}

		catch (Exception e) {
			try {
				dis.close();
				client.close();
			} catch (Exception ex) {
				System.out.println("Ngat ket noi voi Server");
			}
		}
	}
}
 




