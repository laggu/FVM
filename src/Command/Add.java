package Command;

import Main.Status;

import java.io.File;

public class Add extends BaseCommand {

	String fileName;
	Status status;

	public Add(String fileName) {
		this.fileName = fileName;
		status = Status.getInstance();
	}

	@Override
	public void execute() {
		File f = new File(status.getRootPath()+"/"+fileName);

		if (!f.exists()) {
			System.out.println("file does not exist");
		} else if (f.isDirectory()){
			addDir(f);
		}

		//status.addFile(f);
		System.out.println("added file number : " + status.getNewAddedFileList().size());
	}

	private void addDir(File dir){
		File[] list = dir.listFiles();

		for (File file: list) {
			if(file.isDirectory())
				addDir(file);
			else
				status.addFile(file);
		}
	}



}
