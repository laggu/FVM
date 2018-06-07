package DB;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.JDBCUtil;
import Main.Status;

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

			// ps실행 => insert 완료 결과값
			result = ps.executeUpdate();

			ps.clearParameters();
			ps.close();
			// 결과값 핸들린z

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
	public static ArrayList<Status> CommitSelect(Vo_Commit commit) {

		StringBuilder sql = new StringBuilder();
		sql.append("select * from commitdata c, commitedfile cf, project p where p.pname =c.pname and c.commitno=cf.commitno and c.pname =? order by c.commitno");

		/*
		 * select * from commitdata c, commitedfile cf, project p where p.pname =
		 * c.pname order by c.commitno;
		 */
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Status> statuslist = new ArrayList<>();

		Status status = null;
				
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql.toString());
			// ? 의 값 바인딩
			ps.setString(1, commit.getPName());
			// ps실행
			rs = ps.executeQuery();
	
			int previousCommitNumber = -1;
			ArrayList<File> list = null;
			ArrayList<File> list2 = null;

			while (rs.next()) {
				if (previousCommitNumber != rs.getInt(1)) {

					if (status != null) {
						statuslist.add(status);
					}

					status = new Status();
					
					list = new ArrayList<File>();
					list2 = new ArrayList<File>();
					status.setAddedFileList(list);
					status.setCommittedFileList(list2);
					status.setProjectName(rs.getString(2));
					status.setBranch(rs.getString(3));
					status.setRootPath(rs.getString(11));
					status.setVersion(rs.getInt(4));

					previousCommitNumber = rs.getInt(1);
				} else {
					status = new Status();
					
					list = new ArrayList<File>();
					list2 = new ArrayList<File>();
					status.setAddedFileList(list);
					status.setCommittedFileList(list2);
					status.setProjectName(rs.getString(2));
					status.setBranch(rs.getString(3));
					status.setRootPath(rs.getString(11));
					status.setVersion(rs.getInt(4));

					if (rs.getString(8).contains("a")) {
						list.add(new File(rs.getString(8)));
					}

					if (rs.getString(8).contains("c")) {
						list2.add(new File(rs.getString(8)));
					}
				}
			}

			statuslist.add(status);

			// 결과값 핸들린
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}

		return statuslist;
	}
}
