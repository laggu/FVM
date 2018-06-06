package Main;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Status implements Cloneable{

	private static Status status;

	public static Status getInstance() {
		if (status == null) {
			status = new Status();
			return status;
		} else {
			return status;
		}
	}

	private String projectName;
	private String branch;
	private int version;
	private String rootPath;
	private ArrayList<File> addedFile = new ArrayList<>();
	private ArrayList<File> commitedFile = new ArrayList<>();

	private Status() {
		super();
		this.branch = "master";
		this.version = 1;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void increaseVersion(){
		version++;
	}

	public ArrayList<File> getList() {
		return addedFile;
	}

	public void addFile(File f) {
		this.addedFile.add(f);
	}

	public ArrayList<File> getCommitedFile() {
		return commitedFile;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Status status = (Status)super.clone();
		status.addedFile = new ArrayList<File>();

		Iterator it = addedFile.iterator();

		while (it.hasNext()) {
			File f = new File(((File)it.next()).getAbsolutePath());
			status.addedFile.add(f);
		}

		status.commitedFile = new ArrayList<>();

		it = commitedFile.iterator();

		while (it.hasNext()) {
			File f = new File(((File)it.next()).getAbsolutePath());
			status.commitedFile.add(f);
		}

		return status;
	}





}
