package DB;

public class Vo_Project {

	String PName;
	String PPath;

	public Vo_Project() {
		super();
	}

	public Vo_Project(String pName, String pPath) {
		super();
		PName = pName;
		PPath = pPath;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public String getPPath() {
		return PPath;
	}

	public void setPPath(String pPath) {
		PPath = pPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PName == null) ? 0 : PName.hashCode());
		result = prime * result + ((PPath == null) ? 0 : PPath.hashCode());
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
		Vo_Project other = (Vo_Project) obj;
		if (PName == null) {
			if (other.PName != null)
				return false;
		} else if (!PName.equals(other.PName))
			return false;
		if (PPath == null) {
			if (other.PPath != null)
				return false;
		} else if (!PPath.equals(other.PPath))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vo_Project [PName=" + PName + ", PPath=" + PPath + "]";
	}
}
