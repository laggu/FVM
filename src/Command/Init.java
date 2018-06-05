package Command;
import Main.Status;

import java.io.File;

public class Init extends BaseCommand{

    String projectName;

    public Init(String str){
        projectName = str;
    }

    @Override
    public void execute() {
        String rootPath = System.getProperty("user.dir");
        Status.getInstance().setRootPath(rootPath);

        Status.getInstance().getRootPath() + "/.fvm/branch/" + Status.getInstance().getBranch() + Status.getInstance().getVersion();


        File dir = new File(rootPath + "/.fvm/branch/master");
        dir.mkdirs();
    }

}
