package Command;

import Main.Status;

public class Add extends BaseCommand {

	String fileName;

	public Add(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void execute() {
		
		Status status = Status.getInstance();
		status.addFileName(fileName);
	}

}
