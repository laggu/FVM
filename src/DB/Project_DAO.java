package DB;

import java.sql.*;
import java.util.ArrayList;

public class Project_DAO {

	// insert
	public static int projectInsert(Vo_Project project) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into Project values(?, ?, sysdate)");

		// insert into Project values('1', '2', sysdate);

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql.toString());

			// ? 의 값 바인딩
			ps.setString(1, project.getPName());
			ps.setString(2, project.getPPath());

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

	public static ArrayList<Vo_Project> projectSelect() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from Project");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Vo_Project> projectlist = new ArrayList<>();

		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();

			while (rs.next()) {
				String projectName = rs.getString(1);
				String projectPath = rs.getString(2);
				Vo_Project temp = new Vo_Project(projectName, projectPath);
				projectlist.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}

		return projectlist;
	}
}
