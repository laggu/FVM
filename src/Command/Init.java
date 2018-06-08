package Command;
import DB.Project_DAO;
import DB.Vo_Project;
import Main.Status;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Init extends BaseCommand{

    String projectName;

    public Init(String str){
        projectName = str;
    }

    @Override
    public void execute() {
        String homePath = System.getProperty("user.home");
        Status status = Status.getInstance();

        System.out.println(homePath);

        status.setProjectName(projectName);
        status.setBranch("master");
        status.setVersion(1);
        status.setRootPath(System.getProperty("user.dir"));

        System.out.println(status.getRootPath());

        File dir = new File(status.getRootPath() + "/.fvm/"+ projectName + "/branch/master");
        dir.mkdirs();
        dir = new File(status.getRootPath() + "/.fvm/" + projectName + "/data");
        dir.mkdirs();

        File f = new File(status.getRootPath() + "/.fvm/" + projectName + "/data/data.dat");
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
