package Main;
import java.util.ArrayList;

import Command.*;
import DB.Commit_DAO;
import DB.Create_DAO;
import UI.local.MainUI;

public class Main {

	public static void main(String[] argv) {
		Create_DAO.CreateProject();
		Create_DAO.CreateCommitData();
		Create_DAO.CreateCommittedFile();
		Commit_DAO.maxNumSelect();
		
		new MainUI();
	}
}
