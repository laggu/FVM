import java.util.ArrayList;

public class Status {

	private static Status status;

	public static Status getInstance() {
		if (status == null) {
			status = new Status();
			return status;
		} else {
			return status;
		}
	}

	ArrayList<String> addedFile = new ArrayList<>();
	String branch;
	int version;

	public Status() {
		super();
		this.branch = "master";
		this.version = 1;
	}

	public ArrayList<String> getList() {
		return addedFile;
	}

	public void addFileName(String name) {
		this.addedFile.add(name);
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

}
