package DB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vo_Commit implements Serializable {

	private String BName;
	private String PName;
	private String TName;
	private String Message;

	private List<String> addedFname = new ArrayList<>();
	private List<String> commitedFname = new ArrayList<>();
	
	public Vo_Commit() {
		super();
	}

	public Vo_Commit(String bName, String pName, String tName, String message, List<String> addedFname,
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

	public String getTName() {
		return TName;
	}

	public void setTName(String tName) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BName == null) ? 0 : BName.hashCode());
		result = prime * result + ((Message == null) ? 0 : Message.hashCode());
		result = prime * result + ((PName == null) ? 0 : PName.hashCode());
		result = prime * result + ((TName == null) ? 0 : TName.hashCode());
		result = prime * result + ((addedFname == null) ? 0 : addedFname.hashCode());
		result = prime * result + ((commitedFname == null) ? 0 : commitedFname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vo_Commit other = (Vo_Commit) obj;
		if (BName == null) {
			if (other.BName != null)
				return false;
		} else if (!BName.equals(other.BName))
			return false;
		if (Message == null) {
			if (other.Message != null)
				return false;
		} else if (!Message.equals(other.Message))
			return false;
		if (PName == null) {
			if (other.PName != null)
				return false;
		} else if (!PName.equals(other.PName))
			return false;
		if (TName == null) {
			if (other.TName != null)
				return false;
		} else if (!TName.equals(other.TName))
			return false;
		if (addedFname == null) {
			if (other.addedFname != null)
				return false;
		} else if (!addedFname.equals(other.addedFname))
			return false;
		if (commitedFname == null) {
			if (other.commitedFname != null)
				return false;
		} else if (!commitedFname.equals(other.commitedFname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vo_Commit [BName=" + BName + ", PName=" + PName + ", TName=" + TName + ", Message=" + Message
				+ ", FName=" + ", addedFname=" + addedFname + ", commitedFname=" + commitedFname + "]";
	}

	

}