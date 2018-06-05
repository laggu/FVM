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
        String homePath = System.getProperty("user.home");
        Status.getInstance().setRootPath(homePath);

        File dir = new File(homePath + "/.fvm/"+ projectName + "/branch/master");
        dir.mkdirs();
    }

}
