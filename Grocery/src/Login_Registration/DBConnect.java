package Login_Registration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBConnect {
	
	
	Connection conn;
	
	
	public DBConnect() throws ClassNotFoundException, SQLException{
		
		
		String hostname = "localhost";
		String dbname = "Grocery";
		String username = "root";
		String password = "";
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String connectionURL = "jdbc:mysql://"+ hostname +":3306/"+dbname;
		
		conn = DriverManager.getConnection(connectionURL,username,password);
		
		if(conn != null){
			System.out.println("Success");
		}
	
		
		
	}
	
	
	public boolean checkUser(String username, String password) throws SQLException{
		
		
		String sql = "SELECT * FROM admin WHERE username = '"+username+"' AND password = '"+password+"' ";
		
		
		Statement stm = conn.createStatement();
		
		ResultSet rs = stm.executeQuery(sql);
		
		if(rs.next()== true){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	public void insertUser(String nome, String cognome, String indirizzo, String città, String password, String email, String telefono) throws SQLException{
		
		
		Statement stm = conn.createStatement();
		
		String sql = "INSERT INTO users (nome,cognome,indirizzo,citta,password,email,telefono)" 
				+ "VALUES('"+nome+"','"+cognome+"' , '"+indirizzo+"' , '"+città+"', '"+password+"', '"+email+"' , '"+telefono+"' )";
		
		
		
		
		stm.executeUpdate(sql);
		
		

		
	}
	
	
	
	

}
