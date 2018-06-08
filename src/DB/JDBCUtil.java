package DB;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {										// DB와 CONNECTION 관리 클래스
	
	public static Connection getConnection () {
		
		Connection con = null;
		String driver = "";
		String url = "";
		String user = "";
		String pw = "";
		
		try {												// Properties, key(string) - value(string)
			Properties p = new Properties(); 				 
			p.load(new FileInputStream("C:\\lib\\db_info.txt"));  
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			pw = p.getProperty("pw");
			
			Class.forName(p.getProperty("driver"));
			
			
			con = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
															// 자원관리 클래스
	public static void close(Connection con, Statement st, ResultSet rs) {	
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
