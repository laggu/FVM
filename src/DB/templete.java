package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class templete {
	public static void main(String[] args) {
		
		String sql = "";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
				
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			// ? 값 바인딩
			// ps 실행
			// 결과값 핸들링
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		
	}
}
