package Command;
import DB.Project_DAO;
import DB.Vo_Project;
import Main.Status;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Init extends BaseCommand{

    private String projectName;
    private String rootPath;

    public Init(String str, String path){
        projectName = str;
        rootPath = path;
    }

    @Override
    public void execute() {
        Status status = Status.getInstance();

        status.setProjectName(projectName);
        status.setBranch("master");
        status.setVersion(1);
        status.setRootPath(rootPath);

        System.out.println(status.getRootPath());

        File dir = new File(status.getRootPath() + Status.getFileDelimiter() + ".fvm"+  Status.getFileDelimiter() + projectName +  Status.getFileDelimiter() + "branch" +  Status.getFileDelimiter() + "master");
        dir.mkdirs();
        dir = new File(status.getRootPath() +  Status.getFileDelimiter() + ".fvm" +  Status.getFileDelimiter() + projectName +  Status.getFileDelimiter() + "data");
        dir.mkdirs();

        File f = new File(status.getRootPath() +  Status.getFileDelimiter() + ".fvm"  +  Status.getFileDelimiter() + projectName +  Status.getFileDelimiter() + "data" +  Status.getFileDelimiter() +"data.dat");
        try {
            FileOutputStream os = new FileOutputStream(f);
            os.write(projectName.getBytes());
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Vo_Project project = new Vo_Project(projectName, status.getRootPath());
        Project_DAO.projectInsert(project);
    }
}
