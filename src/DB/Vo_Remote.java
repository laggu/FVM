package DB;

public class Vo_Remote {

	private String Id;
	private String pw;

	public Vo_Remote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vo_Remote(String id, String pw) {
		super();
		Id = id;
		this.pw = pw;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Vo_Remote [Id=" + Id + ", pw=" + pw + "]";
	}

}
