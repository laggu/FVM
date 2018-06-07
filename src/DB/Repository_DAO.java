package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Repository_DAO {
	// insert
		public static int repositoryInsert(Vo_Repository repository) {

			StringBuilder sql = new StringBuilder();
			sql.append("insert into Repository values(?,?,sysdate)");

			// insert into Repository values('repositanme', 'id', sysdate);

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			int result = 0;

			try {
				con = JDBCUtil.getConnection();
				ps = con.prepareStatement(sql.toString());

				// ? 의 값 바인딩
				ps.setString(1, repository.getRepositName());
				ps.setString(2, repository.getId());

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
