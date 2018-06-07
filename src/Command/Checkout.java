package Command;

import Main.CommitTree;
import Main.Status;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Checkout extends BaseCommand{
    private String branch;

    public Checkout(String branch) {
        this.branch = branch;
        System.out.println("checkout generator" + branch);
    }

    @Override
    public void execute() {
        Status status = Status.getInstance();

        ArrayList addedFileList = status.getAddedFileList();

        Iterator it = addedFileList.iterator();

        while (it.hasNext()) {
            File f = (File)it.next();
            f.delete();
        }

        CommitTree commitTree = CommitTree.getInstance();

        Status.setStatus(commitTree.getStatus(branch));
        status = Status.getInstance();
        System.out.println("after setStatus " + status.getVersion());
        System.out.print("commitTree.getStatus(branch).getAddedFileList() ");
        System.out.println(commitTree.getStatus(branch).getAddedFileList());
        System.out.println(status.getAddedFileList());

        ArrayList<File> files_to_copy = status.cloneList(status.getAddedFileList());

        Status previousCommit = status;


        System.out.println(files_to_copy);

        while(!files_to_copy.isEmpty()){
            ArrayList<File> previousCommitList = previousCommit.getCommittedFileList();
            System.out.print("previousCommitList: ");
            System.out.println(previousCommitList);

            it = previousCommitList.iterator();

            while (it.hasNext()) {
                File previousFile = (File)it.next();
                System.out.print("previousFile: ");
                System.out.println(previousFile);

                Iterator it_checklist = files_to_copy.iterator();

                while (it_checklist.hasNext()) {
                    File currentFile = (File)it_checklist.next();
                    System.out.print("currentFile: ");
                    System.out.println(currentFile);
                    System.out.println("status.getRootPath()" + status.getRootPath());
                    System.out.println("previousCommit.getBranchPath())" + previousCommit.getBranchPath());
                    if (isSameFile(currentFile,previousFile,status.getRootPath(),previousCommit.getBranchPath())) {
                        System.out.println("same");
                        File f = new File(currentFile.toString());

                        copyFile(previousFile,f);
                        files_to_copy.remove(currentFile);
                        break;
                    }
                }
            }


            previousCommit = commitTree.getParent(previousCommit);
            if(previousCommit == null)
                break;
        }

        // db에서 commited 파일 리스트 읽어옴


        //////////////////            작성 필요               //////////////////////


        //
    }


    private void copyFile(File from, File to){
        BufferedInputStream fis = null;
        BufferedOutputStream fos = null;

        try {
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

    private boolean isSameFile(File original, File commitedFIle, String rootPath, String branchPath){
        String originalName = original.getAbsolutePath().replace(rootPath, "");
        String commitFileName = commitedFIle.getAbsolutePath().replace(branchPath, "");

        return originalName.equals(commitFileName);
    }
}
