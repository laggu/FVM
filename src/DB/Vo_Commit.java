package DB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vo_Commit implements Serializable {

	String BName;
	String PName;
	int TName;
	String Message;

	List<String> addedFname = new ArrayList<>();
	List<String> commitedFname = new ArrayList<>();

	public Vo_Commit() {
		super();
	}

	public Vo_Commit(String bName, String pName, int tName) {
		this.BName = bName;
		this.PName = pName;
		this.TName = tName;
	}
	
	public Vo_Commit(String bName, String pName, int tName, String message, List<String> addedFname,
			List<String> commitedFname) {
		super();
		BName = bName;
		PName = pName;
		TName = tName;
		Message = message;
		this.addedFname = addedFname;
		this.commitedFname = commitedFname;
	}

	public String getBName() {
		return BName;
	}

	public void setBName(String bName) {
		BName = bName;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public int getTName() {
		return TName;
	}

	public void setTName(int tName) {
		TName = tName;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public List<String> getAddedFname() {
		return addedFname;
	}

	public void setAddedFname(List<String> addedFname) {
		this.addedFname = addedFname;
	}

	public List<String> getCommitedFname() {
		return commitedFname;
	}

	public void setCommitedFname(List<String> commitedFname) {
		this.commitedFname = commitedFname;
	}



	@Override
	public String toString() {
		return "Vo_Commit [BName=" + BName + ", PName=" + PName + ", TName=" + TName + ", Message=" + Message
				+ ", FName=" + ", addedFname=" + addedFname + ", commitedFname=" + commitedFname + "]";
	}

}