package Main;

import java.util.ArrayList;

class Node{
    private Status s;
    private Node parent;
    private ArrayList<Node> leaves;

    String getProjectName(){
        return s.getProjectName();
    }

    String getBranchName(){
        return s.getBranch();
    }

    int getVersion(){
        return s.getVersion();
    }
}

public class CommitTree {
    private Node root;

    public CommitTree() {
        root = new Node();
    }


}
