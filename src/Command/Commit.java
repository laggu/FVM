package Command;

import Main.Status;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.security.MessageDigest;

public class Commit extends BaseCommand {

	@Override
	public void execute() {
		Status status = Status.getInstance();
		String branch_dir_str = new String(status.getRootPath() + "/.fvm/branch/" + status.getBranch()+"/"+status.getVersion());

		File dir = new File(branch_dir_str);
		dir.mkdirs();

		ArrayList<File> commitlist = status.getCommittedFileList();
        commitlist.addAll(status.getNewAddedFileList());

		// compare and find files to copy


		//need to write////////////////////////////////////////////////////////////////////


		//


		Iterator it = commitlist.iterator();

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

		Status.newInstance();
	}

	private boolean isChanged(File f, File f2){
		return !getHashcode(f).equals(getHashcode(f2));
	}

	public String getHashcode(File f){

		BufferedInputStream bistream = null;
		try {
			bistream = new BufferedInputStream(new FileInputStream(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		byte[] message = null;
		try {
			message = new byte[bistream.available()];
		} catch (IOException e) {
			e.printStackTrace();
		}
		// SHA를 사용하기 위해 MessageDigest 클래스로부터 인스턴스를 얻는다.
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

		// 해싱할 byte배열을 넘겨준다.
		// SHA-256의 경우 메시지로 전달할 수 있는 최대 bit 수는 2^64-1개 이다.
		md.update(message);

		// 해싱된 byte 배열을 digest메서드의 반환값을 통해 얻는다.
		byte[] hashbytes = md.digest();

		return hashbytes.toString();
	}
}
