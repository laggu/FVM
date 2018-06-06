package db;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;


public class Commit_DAO {

	private static int start = 0;
	
	// insert
	public int Insert(Vo_Commit commit) {

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

		Iterator i1 = addedFname.iterator();
		Iterator i2 = commitedFname.iterator();

		// Commitdata insert
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sqlData.toString());

			// ? 의 값 바인딩
			ps.setString(1, start++);
			ps.setString(2, commit.getPName());
			ps.setString(3, commit.getBName());
			ps.setString(4, commit.getTName());
			ps.setString(5, commit.getMessage());

			// ps실행 => insert 완료 결과값
			result = ps.executeUpdate();

			// 결과값 핸들린z

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// Commitedfile insert
		while (i1.hasNext()) {

			try {
				con = JDBCUtil.getConnection();
				ps = con.prepareStatement(sqlData.toString());

				// ? 의 값 바인딩
				ps.setString(1, (String) i1.next()); // added -> filename / a
				ps.setString(2, "a"); // added -> filename / a
				ps.setString(3, start);
				
				// ps실행 => insert 완료 결과값
				result = ps.executeUpdate();

				// 결과값 핸들린

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		while (i2.hasNext()) {

			try {
				con = JDBCUtil.getConnection();
				ps = con.prepareStatement(sqlFile.toString());

				// ? 의 값 바인딩
				ps.setString(1, (String) i2.next()); // added -> filename / a
				ps.setString(2, "c"); // added -> filename / a

				// ps실행 => insert 완료 결과값
				result = ps.executeUpdate();

				// 결과값 핸들린

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		JDBCUtil.close(con, ps, rs);
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
			ps.setString(2, commit.getTName());
			ps.setString(3, commit.getPName());

			// ps실행
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new Vo_Commit();
				user.setBName(rs.getString(1));
				user.setTName(rs.getString(2));
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
