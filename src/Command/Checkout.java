package Command;

import Main.Status;

import java.util.ArrayList;

public class Checkout extends BaseCommand{
    private String branchName;
    private int version;

    public Checkout(String branchName, int version) {
        this.branchName = branchName;
        this.version = version;

    }

    @Override
    public void execute() {
        Status status = Status.getInstance();


        // db에서 읽어 status 를 객체를 수정함


        //////////////////            작성 필요               //////////////////////


        //


        ArrayList<String> fileNames_to_copy = new ArrayList<>();


        // db에서 commited 파일 리스트 읽어옴


        //////////////////            작성 필요               //////////////////////


        //




    }
}
