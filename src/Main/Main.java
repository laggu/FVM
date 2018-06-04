package Main;
import java.util.ArrayList;

import Command.Add;
import Command.BaseCommand;
import Command.Commit;
import Command.Init;

public class Main {

	public static void main(String[] args) {

		// ΩÃ±€≈Ê
		Status status = Status.getInstance();

		BaseCommand commamd = null;

		switch (args[1]) {

		case "init":
			commamd = new Init();
			break;

		case "add":
			commamd = new Add(args[2]);
			
			break;

		case "commit":
			commamd = new Commit();
			break;

		case "breanch":
			break;

		case "merge":
			break;

		case "checkout":
			break;
		default:
			break;
		}

		commamd.execute();

	}

}
