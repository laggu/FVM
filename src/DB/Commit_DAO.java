package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import DB.JDBCUtil;

public class Commit_DAO {

	private static int start = 0;

	// insert
	public static int Insert(Vo_Commit commit) {

		List<String> addedFname = commit.getAddedFname();
		List<String> commitedFname = commit.getCommitedFname();

		StringBuilder sqlData = new StringBuilder();
		sqlData.append("insert into CommitData values(?,?,?,?,sysdate,?)");
		// insert into CommitData values(1, 'PName', 'BName', 'TName', sysdate,
		// 'Message');

		StringBuilder sqlFile = new StringBuilder();
		sqlFile.append("insert into CommitedFile values(?,?,?)");
		// insert into CommitedFile values('fname','fstatus',
		// CommitedFileIndex.nextval);

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		// Commitdata insert
		try {

			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sqlData.toString());

			// ? 의 값 바인딩
			ps.setInt(1, ++start);
			ps.setString(2, commit.getPName());
			ps.setString(3, commit.getBName());
			ps.setInt(4, commit.getTName());
			ps.setString(5, commit.getMessage());
			System.out.println("-----------check --------------");

			// ps실행 => insert 완료 결과값
			result = ps.executeUpdate();
			System.out.println("-----------check --------------");

			ps.clearParameters();
			ps.close();
			// 결과값 핸들린z
			System.out.println("-----------check --------------");

			for (int i = 0; i < addedFname.size(); i++) {
				ps = con.prepareStatement(sqlFile.toString());
				ps.setString(1, addedFname.get(i));
				ps.setString(2, "a");
				ps.setInt(3, start);
				result = ps.executeUpdate();
				ps.clearParameters();
				ps.close();
			}

			for (int i = 0; i < commitedFname.size(); i++) {
				ps = con.prepareStatement(sqlFile.toString());
				ps.setString(1, commitedFname.get(i));
				ps.setString(2, "c");
				ps.setInt(3, start);
				result = ps.executeUpdate();
				ps.clearParameters();
				ps.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
	return result;
	}
	

	// select
	public Vo_Commit CommitSelect(Vo_Commit commit) {

		Vo_Commit user = null;
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select * from commitdata c, COMMITEDFILE cf where c.COMMITNO = cf.COMMITNO and bname =? and tname =? and pname=?");

		// select * from commitdata c, COMMITEDFILE cf
		// where c.COMMITNO = cf.COMMITNO and bname = 'null' and tname = 'null' and
		// pname = 'null';

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql.toString());

			// ? 의 값 바인딩
			ps.setString(1, commit.getBName());
			ps.setInt(2, commit.getTName());
			ps.setString(3, commit.getPName());

			// ps실행
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new Vo_Commit();
				user.setBName(rs.getString(1));
				user.setTName(rs.getInt(2));
				user.setPName(rs.getString(3));
				user.setMessage(rs.getString(4));
				user.setMessage(rs.getString(5));
				user.setMessage(rs.getString(6));
			}

			// 결과값 핸들린

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return user;
	}
}
