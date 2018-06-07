package DB;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class dbTest {

	FVM_Interface service;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		Commit_DAO user = new Commit_DAO();
		Repository_DAO Rdao = new Repository_DAO();
		service = new FVMImple(Rdao);
	}

	@After
	public void tearDown() throws Exception {
		service = null;
		System.out.println("tear down");
	}

	@Test
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
	
	}

}
