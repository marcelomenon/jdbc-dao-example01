package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Class to open the connection with the mysql database

public class ConnectionFactory {
	public Connection getConnection() {
	try {
		// The DriverManager Class communicate with all the available drivers
		// The getConnection method indicate which database will be used
		return DriverManager.getConnection("jdbc:mysql://localhost/database01", "root", "admin");
		
	// Java Exception Handling
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}

}
}
