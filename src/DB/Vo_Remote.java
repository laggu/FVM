package DB;

public class Vo_Remote {

	String Id;
	int pw;

	public Vo_Remote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vo_Remote(String id, int pw) {
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

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Vo_Remote [Id=" + Id + ", pw=" + pw + "]";
	}

}
