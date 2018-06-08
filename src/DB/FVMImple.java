package DB;

import java.util.ArrayList;
import java.util.List;

import Main.Status;

public class FVMImple implements FVM_Interface {

	Project_DAO ProjectDAO;
	Remote_DAO RemoteDAO;
	Repository_DAO RepositoryDAO;
	Commit_DAO CommitDAO;
	
	public FVMImple(Repository_DAO rdao) {
		super();
	}

	public FVMImple(Project_DAO projectDAO, Remote_DAO remoteDAO, Repository_DAO repositoryDAO, Commit_DAO commitDAO) {
		super();
		ProjectDAO = projectDAO;
		RemoteDAO = remoteDAO;
		RepositoryDAO = repositoryDAO;
		CommitDAO = commitDAO;
	}

	public FVMImple(Commit_DAO user) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int projectInsert(Vo_Project project) {
		return ProjectDAO.projectInsert(project);
	}

	@Override
	public int remoteInsert(Vo_Remote remote) {
		return RemoteDAO.remoteInsert(remote);
	}

	@Override
	public int repositoryInsert(Vo_Repository repository) {
		return RepositoryDAO.repositoryInsert(repository);
	}

	@Override
	public int Insert(Vo_Commit commit) {
		return CommitDAO.Insert(commit);
	}

	@Override
	public ArrayList<Status> CommitSelect(Vo_Commit commit) {
		return CommitDAO.CommitSelect(commit);
	}

	public Project_DAO getProjectDAO() {
		return ProjectDAO;
	}

	public void setProjectDAO(Project_DAO projectDAO) {
		ProjectDAO = projectDAO;
	}

	public Remote_DAO getRemoteDAO() {
		return RemoteDAO;
	}

	public void setRemoteDAO(Remote_DAO remoteDAO) {
		RemoteDAO = remoteDAO;
	}

	public Repository_DAO getRepositoryDAO() {
		return RepositoryDAO;
	}

	public void setRepositoryDAO(Repository_DAO repositoryDAO) {
		RepositoryDAO = repositoryDAO;
	}

	public Commit_DAO getCommitDAO() {
		return CommitDAO;
	}

	public void setCommitDAO(Commit_DAO commitDAO) {
		CommitDAO = commitDAO;
	}

	
	
	
	
}
