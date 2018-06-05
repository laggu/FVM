package Main;
import java.util.ArrayList;

import Command.Add;
import Command.BaseCommand;
import Command.Commit;
import Command.Init;

public class Main {

	public static void main(String[] args) {

		// �̱���
		Status status = Status.getInstance();

		BaseCommand command = null;

		switch (args[1]) {

		case "init":
			command = new Init(args[2]);
			break;

		case "add":
			command = new Add(args[2]);

			break;

		case "commit":
			command = new Commit();
			break;

		case "breanch":
			command = new Branch(asgs[2]);
			break;

		case "merge":
			break;

		case "checkout":
			break;
		default:
			break;
		}

		command.execute();
	}
}
