package DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProjectDAO {
	
	// 프로젝트 등록
	public int projectInsert(ProjectVO project) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into PROJECT(project_name,path,creation_date) values(?,?,?) ");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql.toString());

			// ? 의 값 바인딩
			ps.setString(1, project.getProject_name());
			ps.setString(2, project.getPath());
			ps.setString(3, project.getCreation_date());

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
