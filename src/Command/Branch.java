package Command;

import Main.CommitTree;
import Main.Status;
import java.io.File;

public class Branch extends BaseCommand
{
    private  String branchName;

    public Branch(String branchName)
  {
    this.branchName = branchName;
  }

    @Override
    public void execute()
    {
        Status status = Status.getInstance();
        String branch_dir_str = new String(status.getRootPath() + Status.getFileDelimiter() + ".fvm"+ Status.getFileDelimiter() + status.getProjectName() + Status.getFileDelimiter() +"branch" + Status.getFileDelimiter() + this.branchName);

        CommitTree commitTree = CommitTree.getInstance();
        commitTree.setBranchPoint(status, branchName);
        
        status.getBranchPath();
        File dir = new File(branch_dir_str);

        if (dir.exists()) {
            System.out.println(this.branchName + " is already exited");
            return;
        }

        dir.mkdirs();
        Status.newInstance(branchName);
    }
}
