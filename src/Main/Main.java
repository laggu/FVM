package Main;
import java.util.ArrayList;

import Command.*;
import DB.Create_DAO;
import UI.local.MainUI;

public class Main {

	public static void main(String[] argv) {
		Create_DAO.CreateProject();
		Create_DAO.CreateCommitData();
		Create_DAO.CreateCommittedFile();
		
		new MainUI();
	}
}
