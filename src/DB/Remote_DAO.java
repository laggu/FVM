package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Remote_DAO {
	
	// insert
	public int remoteInsert(Vo_Remote remote) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into Remote values(?,?)");

		// insert into Remote values('id','pw');

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql.toString());

			// ? 의 값 바인딩
			ps.setString(1, remote.getId());
			ps.setString(2, remote.getPw());

			// ps실행 => insert 완료 결과값
			result = ps.executeUpdate();

			// 결과값 핸들린

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return result;
	}

}
