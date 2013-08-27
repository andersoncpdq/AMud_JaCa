package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DaoFactory {
	public static Connection getConnection () throws SQLException{
		//com.mysql.jdbc.Driver drv = new Driver();
		String url = "jdbc:mysql://localhost/dotproject";		
		return DriverManager.getConnection(url, "root", "root" );		
	}
	
}
