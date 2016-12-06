package apligs.dao;

import javax.naming.*;
import javax.sql.*;

public class MySQLApligs {

	private static DataSource MySQLApligs = null;
	private static Context context = null;
	
	public static DataSource MySQLApligs() throws Exception {
		if(MySQLApligs != null) 
			return MySQLApligs;
		
		try {
			if(context == null) {
				context = new InitialContext();
			}
			
			MySQLApligs = (DataSource) context.lookup("java:comp/env/" + "ApligsMySQL");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return MySQLApligs;
	}
}
