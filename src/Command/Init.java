package Command;
import java.io.File;

public class Init extends BaseCommand{
    @Override
    public void execute() {
    }

    public void execute(String str) {
        File dir = new File(".fvm");
        dir.mkdirs();
    }
}
