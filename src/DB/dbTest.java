package DB;

import static org.junit.Assert.*;

import java.io.File;
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

	@Test
	public void insert() {
		
		Status status = Status.emptyInstance();
		
		ArrayList<File> sample = new ArrayList<>();
		ArrayList<File> sample2 = new ArrayList<>();
		
		status.setBranch("new bb");
		status.setProjectName("kim");
		status.setVersion(0002);
		status.setMessage("new mm");
		
		sample.add(new File("file1"));
		sample.add(new File("file2"));
		sample.add(new File("file3"));
		
		sample2.add(new File("file4"));
		sample2.add(new File("file5"));
		sample2.add(new File("file6"));
				
		status.setAddedFileList(sample);
		status.setCommittedFileList(sample2);
				
		status.setRootPath(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.dir"));
		System.out.println(sample.get(0).getAbsolutePath());

		service.Insert(status);
	
	}
	
	@Test
	public void select () {
		
		Status status = Status.emptyInstance();
		ArrayList<Status> result = new ArrayList<>();
		
		/*status.setProjectName("kim");
		status.setBranch("bname");
		status.setVersion(123456);
		*/
		result = service.CommitSelect("kim");		
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
		
	}

}
