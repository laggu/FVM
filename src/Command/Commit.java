package Command;

import Main.Status;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Commit extends BaseCommand {

	@Override
	public void execute() {
		Status status = Status.getInstance();
		String branch_dir_str = new String(status.getRootPath() + "/.fvm/branch/" + status.getBranch()+"/"+status.getVersion());

		File dir = new File(branch_dir_str);
		dir.mkdirs();

		ArrayList<String> fileNames_to_copy = new ArrayList<>();


		// compare and find files to copy


		//need to write////////////////////////////////////////////////////////////////////


		//


		Iterator it = fileNames_to_copy.iterator();

		while (it.hasNext()) {
			String filename = (String)it.next();
			File new_file = new File(branch_dir_str+filename);
			File original_file = new File(status.getRootPath() + filename);

			BufferedReader fr = null;
			BufferedWriter fw = null;

			try {
				fr = new BufferedReader(new FileReader(original_file));
				fw = new BufferedWriter(new FileWriter(new_file));

				String temp;

				while((temp = fr.readLine())!= null){
					fw.write(temp);
					fw.flush();
				}

				fw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					fw.close();
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
