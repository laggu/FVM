package DB;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//connection management class
public class JDBCUtil {
	public static Connection getConnection() {
		Connection con = null;
		String driver = "";
		String url  = "";
		String user = "";
		String pw   = "";
		
		try {
			//데이터를 키값과 밸류값 형태로 관리하는 맵 구조 =>Propertise객체
			Properties p = new Properties();
			p.load(new FileInputStream("C:\\lib\\db_info.txt"));
			
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			pw = p.getProperty("pw");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user,pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	 public static void close(Connection con, Statement st, ResultSet rs) {
		 try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(con!=null) con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	
	
}
