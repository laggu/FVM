package Command;

import DB.Commit_DAO;
import Main.CommitTree;
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

		File dir = new File(status.getBranchPath());
		dir.mkdirs();

		ArrayList<File> commitlist = status.getCommittedFileList();
        commitlist.addAll(status.getNewAddedFileList());

        ArrayList<File> checkList = status.cloneList(status.getAddedFileList());
		CommitTree commitTree = CommitTree.getInstance();
		Status previousCommit = status;

        while(!checkList.isEmpty()){
			previousCommit = commitTree.getParent(previousCommit);
			if(previousCommit == null)
				break;
			ArrayList<File> previousCommitList = previousCommit.getCommittedFileList();

			Iterator it = previousCommitList.iterator();

			while (it.hasNext()) {
				File previousFile = (File)it.next();

				Iterator it_checklist = checkList.iterator();

				while (it_checklist.hasNext()) {
					File currentFile = (File)it_checklist.next();
					if (isSameFile(currentFile,previousFile,status.getRootPath(),previousCommit.getBranchPath())) {
						if(isChanged(previousFile,currentFile)){
							System.out.println(previousFile);
							System.out.println(currentFile);
							System.out.println("changed");
							commitlist.add(currentFile);
						}
						//it_checklist.remove();
						System.out.println("remove");
						System.out.println(checkList);
						checkList.remove(currentFile);
						System.out.println(checkList);
						break;
					}
				}

			}
		}

		System.out.print("commitlist : ");
		System.out.println(commitlist);

		Iterator it = commitlist.iterator();
		ArrayList<File> list = new ArrayList<>();

		while (it.hasNext()) {
			File original_file = (File)it.next();
			String filename = original_file.getAbsolutePath().replace(status.getRootPath(), "");
			File new_file = new File(status.getBranchPath()+Status.getFileDelimiter()+filename);

			copyFile(original_file, new_file);

			list.add(new_file);
		}

		status.setCommittedFileList(list);
		System.out.print("status.getAddedFileList()");
		System.out.println(status.getAddedFileList());
		status.getAddedFileList().addAll(status.getNewAddedFileList());
		commitTree.addCommitNode(status);
		//Commit_DAO.Insert(status);
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

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hashbytes.length; ++i) {
			sb.append(Integer.toString((hashbytes[i]&0xff)+0x100,16).substring(1));
		}

		System.out.println(sb.toString());


		return sb.toString();
	}

	private boolean isSameFile(File original, File commitedFIle, String rootPath, String branchPath){
        System.out.println(original);
        System.out.println(commitedFIle);
        System.out.println(rootPath);
        System.out.println(branchPath);
		System.out.println(commitedFIle.getAbsolutePath());
		String originalName = original.getAbsolutePath().replace(rootPath, "");
		String commitFileName = commitedFIle.getAbsolutePath().replace(branchPath, "");

		System.out.println(originalName);
		System.out.println(commitFileName);

		System.out.println("isSame?? = " + originalName.equals(commitFileName) );
		return originalName.equals(commitFileName);
	}

	private void copyFile(File from, File to){
		BufferedInputStream fis = null;
		BufferedOutputStream fos = null;

		try {
			if(!to.getParentFile().exists())
				to.getParentFile().mkdirs();

			fis = new BufferedInputStream(new FileInputStream(from));
			fos = new BufferedOutputStream(new FileOutputStream(to));

			byte[] buf = new byte[1024];
			int read;
			while((read = fis.read(buf)) != -1) {
				fos.write(buf, 0, read);
			}

			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
