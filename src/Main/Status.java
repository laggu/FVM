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

	public static Status newInstance(){
        status = new Status(status);
        return status;
    }

	public static Status newInstance(String branch){
		if(branch.equals("master"))
			status = new Status(status);
		else
			status = new Status(branch, status);
        return status;
    }

    public static Status emptyInstance(){
		return new Status();
	}

    public static void setStatus(Status s){
		status = s;
	}

	private String projectName;
	private String branch;
	private int version;
	private String rootPath;
    private ArrayList<File> newAddedFileList = null;
	private ArrayList<File> addedFileList = null;
	private ArrayList<File> committedFileList = null;
	private String previousCommit;

	private Status() {
		super();
		this.branch = "master";
		this.version = 1;
        newAddedFileList = new ArrayList<>();
        addedFileList = new ArrayList<>();
        committedFileList = new ArrayList<>();
        this.previousCommit = "root";
	}
	
    public void setAddedFileList(ArrayList<File> addedFileList) {
		this.addedFileList = addedFileList;
	}

	public void setPreviousCommit(String previousCommit) {
		this.previousCommit = previousCommit;
	}

	private Status(Status status){
        this.branch = status.branch;
        this.version = status.version + 1;
        projectName = status.projectName;
		rootPath = status.rootPath;
        newAddedFileList = new ArrayList<>();
        addedFileList = cloneList(status.addedFileList);
        System.out.println("inside Status generator status.addedFileList - " + status.addedFileList);
        //addedFileList.addAll(status.newAddedFileList);
        committedFileList = new ArrayList<>();
        this.previousCommit = status.getCommitName();
    }

	private Status(String branch, Status status){
	    this.branch = branch;
	    this.version = 1;
	    this.previousCommit = status.getPreviousCommit();
		projectName = status.projectName;
		rootPath = status.rootPath;
        newAddedFileList = new ArrayList<>();
        addedFileList = cloneList(status.addedFileList);
        addedFileList.addAll(status.newAddedFileList);
        committedFileList = new ArrayList<>();
    }

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getBranchPath(){
		return rootPath + "/.fvm/" + projectName + "/branch/" + branch + "/" + version;
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

    public ArrayList<File> getNewAddedFileList() {
        return newAddedFileList;
    }

    public ArrayList<File> getAddedFileList() {
        return addedFileList;
    }

	public void addFile(File f) {
		this.newAddedFileList.add(f);
	}

	public ArrayList<File> getCommittedFileList() {
		return committedFileList;
	}

	public void setCommittedFileList(ArrayList<File> committedFileList) {
		this.committedFileList = committedFileList;
	}

	public String getPreviousCommit() {
        return previousCommit;
    }

    public String getCommitName(){
	    return branch + "_" + version;
    }

    public static ArrayList<String> getFileNameFromList(String rootPath, ArrayList<File> list){
        ArrayList<String> fileNameList = new ArrayList<>();

        Iterator it = fileNameList.iterator();

        while (it.hasNext()) {
            File f = (File)it.next();
            String s = f.getAbsolutePath().replace(rootPath+"/","");
            fileNameList.add(s);
        }

        return fileNameList;
    }

    public ArrayList<File> cloneList(ArrayList<File> list){
        ArrayList<File> new_list = new ArrayList<>();

        Iterator it = list.iterator();

        while (it.hasNext()) {
            File f = new File(((File)it.next()).getAbsolutePath());
            new_list.add(f);
        }

        return new_list;
    }

	@Override
	public String toString() {
		return "Status [projectName=" + projectName + ", branch=" + branch + ", version=" + version + ", rootPath="
				+ rootPath + ", newAddedFileList=" + newAddedFileList + ", addedFileList=" + addedFileList
				+ ", committedFileList=" + committedFileList + ", previousCommit=" + previousCommit + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Status status = (Status)super.clone();
		status.addedFileList = new ArrayList<File>();

		Iterator it = addedFileList.iterator();

		while (it.hasNext()) {
			File f = new File(((File)it.next()).getAbsolutePath());
			status.addedFileList.add(f);
		}

		status.committedFileList = new ArrayList<>();

		it = committedFileList.iterator();

		while (it.hasNext()) {
			File f = new File(((File)it.next()).getAbsolutePath());
			status.committedFileList.add(f);
		}

		return status;
	}
}