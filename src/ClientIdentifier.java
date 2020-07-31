import java.net.Socket;

public class ClientIdentifier {
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	private String userName;
	private Socket socket;
	
	public ClientIdentifier(String userName , Socket socket) {
		this.userName = userName;
		this.socket = socket;
	}
	
}
