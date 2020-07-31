import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
public class ClientDAO {

    List<ClientAcc> clients = new ArrayList<>();

    public void getClientAcc() throws SQLException {
    	clients.clear();
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Tuan\\eclipse-workspace\\TCPDesign2\\extlibary\\tpchat.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30); 
    	ResultSet resultSet = statement.executeQuery("SELECT * from clients");
        while(resultSet.next())
        {
        	ClientAcc temp = new ClientAcc(resultSet.getString("user_name"),resultSet.getString("password"));
        	clients.add(temp);
        }
    }
    
    public boolean loginGate(String userName , String passWord) throws SQLException {
    	getClientAcc();
    	for (int i = 0 ; i < clients.size() ; i++) {
    		if (userName.equals(clients.get(i).getUserName()) && passWord.equals(clients.get(i).getPassWord())) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean signUpGate(String userName , String passWord) throws SQLException {
    	getClientAcc();
    	for (int i = 0 ; i < clients.size() ; i++) {
    		if (userName.equals(clients.get(i).getUserName())){
    			return false;
    		}
    	}
    	
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Tuan\\eclipse-workspace\\TCPDesign2\\extlibary\\tpchat.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30); 
        String sql = "INSERT INTO clients (user_name,password) VALUES ('"+userName+"','"+passWord+"');";
        statement.executeUpdate(sql);
    	return true;
    }
    
}