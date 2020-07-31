import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServerDAO {
	
	List<ServerLog> servers = new ArrayList<>();
	
	public List<ServerLog> getServersLog() {
		return servers;
	}

	public void saveLog(String sender , String log) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Tuan\\eclipse-workspace\\TCPDesign2\\extlibary\\tpchat.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30); 
        
        String sql = "INSERT INTO servers (sender,log) VALUES ('"+sender+"','"+log+"');";
        System.out.println(sql);
        statement.executeUpdate(sql);  
	}
	
	public void getLog() throws SQLException {
		servers.clear();
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Tuan\\eclipse-workspace\\TCPDesign2\\extlibary\\tpchat.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30); 
    	ResultSet resultSet = statement.executeQuery("SELECT * from servers");
        while(resultSet.next())
        {
        	ServerLog temp = new ServerLog(resultSet.getString("sender"),resultSet.getString("log"));
        	servers.add(temp);
        }
	}
	
	public void deleteChatLog() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Tuan\\eclipse-workspace\\TCPDesign2\\extlibary\\tpchat.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30); 
        String sql = "DELETE FROM servers;";
        statement.executeUpdate(sql);  
	}
	public void wipeAllDatabase() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Tuan\\eclipse-workspace\\TCPDesign2\\extlibary\\tpchat.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30); 
        String sql = "DELETE FROM servers;";
        statement.executeUpdate(sql);  
        String sql2 = "DELETE FROM clients;";
        statement.executeUpdate(sql2);
	}
	
	
}
