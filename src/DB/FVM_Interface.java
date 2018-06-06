package DB;

public interface FVM_Interface {

	public int projectInsert(Vo_Project project);
	
	public int remoteInsert(Vo_Remote remote);
	
	public int repositoryInsert(Vo_Repository repository);
	
	public int Insert(Vo_Commit commit);
	
	public Vo_Commit CommitSelect(Vo_Commit commit);

}
