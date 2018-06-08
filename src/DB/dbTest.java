
package DB;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Main.Status;

public class dbTest {

	FVM_Interface service;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		
		Commit_DAO user = new Commit_DAO();
		
		service = new FVMImple(user);
	}

	@After
	public void tearDown() throws Exception {
		service = null;
		System.out.println("tear down");
	}

	/*@Test
	public void insert() {
		Vo_Commit user = new Vo_Commit();
		List<String> sample = new ArrayList<>();
		List<String> sample2 = new ArrayList<>();
		
		user.setBName("bame");
		user.setPName("pame");
		user.setTName(20);
		user.setMessage("mg");
		
		sample.add("file1");
		sample.add("file2");
		sample.add("file3");
		
		sample2.add("file4");
		sample2.add("file5");
				
		user.setAddedFname(sample);
		user.setCommitedFname(sample2);
				

		service.Insert(user);
	
	}*/
	
	@Test
	public void select () {
		Vo_Commit commit = new Vo_Commit();
		ArrayList<Status> result = new ArrayList<>();
		
		commit.setPName("kim");
		commit.setBName("bname");
		commit.setTName(123456);
		
		result = service.CommitSelect(commit);		
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
		
	}

}
