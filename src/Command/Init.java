package Command;
import java.io.File;

public class Init extends BaseCommand{

    String fileName;

    public Init(String str){
        fileName = str;
    }

    @Override
    public void execute() {
        File dir = new File(fileName);
        dir.mkdirs();
    }

}
