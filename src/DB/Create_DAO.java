package DB;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Create_DAO {

	public static void CreateProject() {

		String sql = "CREATE TABLE Project (PName VARCHAR2(100) primary key, PPath	VARCHAR2(100), RegDate DATE DEFAULT sysdate)";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql.toString());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}

	}

	public static void CreateCommitData() {
		String sql = "CREATE TABLE CommitData(CommitNo NUMBER(10) NULL primary key, PName VARCHAR2(100) NULL , BName VARCHAR2(100) NULL , TName VARCHAR2(100) NULL , RegDate DATE NULL , Message VARCHAR2(500) NULL )";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
	}

	public static void CreateCommittedFile() {
		String sql = "CREATE TABLE CommitedFile(FName VARCHAR2(100), FStatus VARCHAR2(5), CommitNo NUMBER(10), CONSTRAINT CommitedFile_pk PRIMARY KEY(FName, FStatus, CommitNo))";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
	}

	public static void CreateRemote() {

		String sql = "CREATE TABLE Remote (Id VARCHAR2(100)	NULL primary key , Pw VARCHAR2(100) NULL)";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
	}

	public static void CreateRepository() {
		String sql = "CREATE TABLE Repository(RepositName VARCHAR2(100) NULL primary key , Id VARCHAR2(100)NULL , RegDate DATE DEFAULT sysdate NULL);" 
	+ " ALTER TABLE Repository ADD CONSTRAINT IDX_Repository_FK0 FOREIGN KEY (Id) REFERENCES Remote (Id)";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
	}

}