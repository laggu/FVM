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

        ArrayList<String> fileNames_to_copy = new ArrayList<>();



        // db에서 commited 파일 리스트 읽어옴


        //////////////////            작성 필요               //////////////////////


        //

        it = status.getAddedFileList().iterator();
        while (it.hasNext()) {
            String fileName = (String) it.next();
            File f = new File(status.getRootPath() + fileName);
            f.delete();
        }


    }


    private void copyFile(File from, File to){
        BufferedReader fr = null;
        BufferedWriter fw = null;

        try {
            fr = new BufferedReader(new FileReader(from));
            fw = new BufferedWriter(new FileWriter(to));

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
