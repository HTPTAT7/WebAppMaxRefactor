package by.http.password.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WrapMySqlConnect implements AutoCloseable {
	
	private Connection cn;
	
	public Connection getConnection() throws SQLException {
//		ResourceBundle resource = ResourceBundle.getBundle("db_config");
		String url = "jdbc:mysql://localhost:3306/library_max?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";//resource.getString("db.url");
		String user = "root";
		String pass = "root";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver).newInstance();
			cn = DriverManager.getConnection(url, user, pass);
			
		} catch(ClassNotFoundException e) {
			throw new SQLException("Driver not loaded", e);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return cn;
	}

	@Override
	public void close() throws Exception {
		cn.close();
		
	}

}
