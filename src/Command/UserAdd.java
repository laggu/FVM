package Command;

public class UserAdd extends BaseCommand {

    private String id;
    private String pw;

    public UserAdd(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    @Override
    public void execute() {

    }
}
