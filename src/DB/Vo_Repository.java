package DB;

public class Vo_Repository {
	
	private String RepositName;
	private String id;

	public Vo_Repository() {
		super();
	}

	public Vo_Repository(String repositName, String id) {
		super();
		RepositName = repositName;
		this.id = id;
	}

	public String getRepositName() {
		return RepositName;
	}

	public void setRepositName(String repositName) {
		RepositName = repositName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Vo_Repository [RepositName=" + RepositName + ", id=" + id + "]";
	}
	
	
	
}
